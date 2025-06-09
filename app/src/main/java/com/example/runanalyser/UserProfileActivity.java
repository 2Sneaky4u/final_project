package com.example.runanalyser;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.runanalyser.databasestuff.AppDatabase;
import com.example.runanalyser.fragments.GameRCFragment;
import com.example.runanalyser.fragments.UsersPageFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class UserProfileActivity extends AppCompatActivity {

    private ImageView editUserBtn;
    private TextView curName;
    private FloatingActionButton addgameFab;
    private FloatingActionButton searchFab;

    AppDatabase database;
    private TextView followers;
    private TextView following;
    private final GameRCFragment myGamesFrag = new GameRCFragment(Globals.getCurUser());
    private final FragmentManager fragmentManager = getSupportFragmentManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_users);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.profile), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        switchFragToGamesPage();

        database = AppDatabase.getDatabase(this);

        searchFab = findViewById(R.id.searchFAB);
        addgameFab = findViewById(R.id.addGameFAB);
        editUserBtn = findViewById(R.id.profileBtn);
        curName = findViewById(R.id.curusername);
        followers = findViewById(R.id.followerCountTxt);
        following = findViewById(R.id.followingCountTxt);

        System.out.println("---> " + this + " <---> " + Globals.getCurUser());
        System.out.println("---> " + this + " <---> " + Globals.getCurUser().username);

        new Thread(() -> {
            int ercount = database.followerDao().countFollowers(Globals.getCurUser().id);
            int ngcount = database.followerDao().countFollowing(Globals.getCurUser().id);
            runOnUiThread(() -> {
                followers.setText(String.valueOf(ercount));
                following.setText(String.valueOf(ngcount));
            });
        }).start();
        curName.setText(Globals.getCurUser().username);
        if (Globals.getCurUser().pfpURI != null)
            editUserBtn.setImageURI(Uri.parse(Globals.getCurUser().pfpURI));
        editUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfileActivity.this, EditUserActivity.class);
                startActivity(intent);
            }
        });
        addgameFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfileActivity.this, EditGameActivity.class);
                intent.putExtra(Globals.DEST_ID, 0);
                intent.putExtra(Globals.ITEM_EDITABLE, true);
                startActivity(intent);

            }
        });
        searchFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserProfileActivity.this, SearchNavigationActivity.class));
            }
        });

//        followers.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(UserProfileActivity.this, SearchNavigationActivity.class);
//                i.putExtra(Globals.NAV_OPENING, 1);
//                startActivity(i);            }
//        });
//        following.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(UserProfileActivity.this, SearchNavigationActivity.class);
//                i.putExtra(Globals.NAV_OPENING, 2);
//                startActivity(i);
//            }
//        });

    }
    public void switchFragToGamesPage() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentContainerView2, myGamesFrag, "Your games");
        transaction.commit();
    }
}