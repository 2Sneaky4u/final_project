package com.example.runanalyser;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.runanalyser.fragments.OtherUserProfileFragment;
import com.example.runanalyser.fragments.UsersPageFragment;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class SearchNavigationActivity extends AppCompatActivity {

    private NavigationView navView;
    private DrawerLayout drawerLayout;
    private MaterialToolbar materialToolbar;

    private final FragmentManager fragmentManager = getSupportFragmentManager();
    private final UsersPageFragment usersPageFragment = new UsersPageFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        drawerLayout = findViewById(R.id.DvirDrawerLayout);
        navView = findViewById(R.id.DvirNavigationView);
        materialToolbar = findViewById(R.id.materialToolbar);
        View headerView = navView.getHeaderView(0);
        TextView usernametxt = headerView.findViewById(R.id.textView6);
        ImageView navProfilebtn = headerView.findViewById(R.id.navProfile);
        ImageView closeDrawerBtn = headerView.findViewById(R.id.closeDrawerImage);

        if (Globals.getCurUser() != null) {
            usernametxt.setText(Globals.getCurUser().username);
            if (Globals.getCurUser().pfpURI != null)
                navProfilebtn.setImageURI(Uri.parse(Globals.getCurUser().pfpURI));
        } else usernametxt.setText("Empty user");

        navProfilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("--> profile btn clicked");
                Intent intent = new Intent(SearchNavigationActivity.this, UserProfileActivity.class);
                SearchNavigationActivity.this.startActivity(intent);
            }
        });
        closeDrawerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("--> close btn clicked");
                drawerLayout.closeDrawer(navView);
            }
        });

        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("--> opened");
                drawerLayout.openDrawer(navView);
            }
        });

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                int itemId = item.getItemId();
                if (itemId == R.id.userspage) {
                    System.out.println("--> userpage btn clicked");
                    switchFragToUserpage();
                } else if (itemId == R.id.abtmepage) {
                    System.out.println("--> about me btn clicked");
                    intent = new Intent(SearchNavigationActivity.this, AbtMeActivity.class);
                    startActivity(intent);
                    finish();
                } else if (itemId == R.id.logoutBtn) {
                    System.out.println("--> logout btn clicked");
                    Globals.logOut(SearchNavigationActivity.this);
                }
                return false;
            }
        });
    }

    public void switchFragToUserpage() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentContainerView3, usersPageFragment, "Users Search");
        transaction.commit();
    }

    public void switchFragToNewUserProfile(OtherUserProfileFragment usersProfileFragment) {
        System.out.println("---> clicked a user");
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentContainerView3, usersProfileFragment, "New User Profile");
        System.out.println("---> replaced transaction");
        transaction.commit();
        System.out.println("---> commited transaction");
    }
}