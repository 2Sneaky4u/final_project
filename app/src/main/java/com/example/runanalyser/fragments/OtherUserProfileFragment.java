package com.example.runanalyser.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.runanalyser.Globals;
import com.example.runanalyser.R;
import com.example.runanalyser.SearchNavigationActivity;
import com.example.runanalyser.databasestuff.AppDatabase;
import com.example.runanalyser.databasestuff.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class OtherUserProfileFragment extends Fragment {

    private ImageView userPfp;
    private TextView curName;
    private FloatingActionButton exitFab;
    private GameRCFragment myGamesFrag;
    private User user;
    private AppDatabase database;
    private TextView followers;
    private TextView following;

    public OtherUserProfileFragment() {
        SearchNavigationActivity nav = (SearchNavigationActivity) getActivity();
        nav.switchFragToUserpage();
    }

    public OtherUserProfileFragment(User user) {
        this.user = user;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_other_user_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        database = AppDatabase.getDatabase(getActivity());

        // Initialize views
        userPfp = view.findViewById(R.id.profileBtn2);
        curName = view.findViewById(R.id.curusername2);
        exitFab = view.findViewById(R.id.closeFragFAB);
        followers = view.findViewById(R.id.followerCountTxt2);
        following = view.findViewById(R.id.followingCountTxt2);

        if (user != null) {
            displayUserProfile(user);
        }

        exitFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchNavigationActivity nav = (SearchNavigationActivity) getActivity();
                nav.switchFragToUserpage();
            }
        });
    }

    private void displayUserProfile(User user) {
        curName.setText(user.username);

        // Set profile picture
        if (user.pfpURI != null) {
            userPfp.setImageURI(Uri.parse(user.pfpURI));
        }

        new Thread(() -> {
            int ercount = database.followerDao().countFollowers(user.id);
            int ngcount = database.followerDao().countFollowing(user.id);
            getActivity().runOnUiThread(() -> {
                followers.setText(String.valueOf(ercount));
                following.setText(String.valueOf(ngcount));
            });
        }).start();

        // Setup games fragment
        myGamesFrag = new GameRCFragment(user);
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentContainerView4, myGamesFrag, "OtherUserGames");
        transaction.commit();
    }
}