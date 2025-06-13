package com.example.runanalyser.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.runanalyser.Globals;
import com.example.runanalyser.R;
import com.example.runanalyser.databasestuff.AppDatabase;
import com.example.runanalyser.databasestuff.FollowerDao;
import com.example.runanalyser.databasestuff.User;
import com.example.runanalyser.databasestuff.UserAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class FollowPageFragment extends Fragment {
    private UserAdapter userAdapter;
    private MediatorLiveData<List<User>> usersLiveData = new MediatorLiveData<>();
    private LiveData<List<User>> currentUsersData;
    private boolean showFollowers; // Flag to determine whether to show followers or following
    private int userId;
    private FloatingActionButton close;

    public static FollowPageFragment newInstance(boolean showFollowers, int userid) {
        FollowPageFragment fragment = new FollowPageFragment();
        Bundle args = new Bundle();
        args.putBoolean("showFollowers", showFollowers);
        args.putInt("userId", userid);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (getArguments() != null) {
            showFollowers = getArguments().getBoolean("showFollowers", true);
            userId = getArguments().getInt("userId", Globals.getCurUser().id);
        }
        return inflater.inflate(R.layout.fragment_users_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AppDatabase dataBase = AppDatabase.getDatabase(requireContext());
        FollowerDao followerDao = dataBase.followerDao();
        RecyclerView userRC = view.findViewById(R.id.usersRecyclerView);
        TextView title = view.findViewById(R.id.textView5);
        String t = showFollowers ?
                "Followers" :
                "Following";
        title.setText(t);
        close = view.findViewById(R.id.closeFragFAB2);
        close.setVisibility(View.VISIBLE);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().popBackStack();
            }
        });

        TextView userCount = view.findViewById(R.id.userCountTxt);
        new Thread(() -> {
            int count = showFollowers ?
                    followerDao.countFollowers(userId) :
                    followerDao.countFollowing(userId);
            requireActivity().runOnUiThread(() -> userCount.setText(String.valueOf(count)));
        }).start();

        // Initialize adapter
        userAdapter = new UserAdapter(new ArrayList<>(), getActivity(), user -> {
            return;
        });

        userRC.setLayoutManager(new LinearLayoutManager(requireContext()));
        userRC.setAdapter(userAdapter);

        // Search functionality
        TextInputLayout searchUserInput = view.findViewById(R.id.usersSearchBar);
        EditText searchText = searchUserInput.getEditText();
        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                usersLiveData.removeSource(currentUsersData);
                currentUsersData = showFollowers ?
                        followerDao.searchFollowerListById(userId, editable.toString()) :
                        followerDao.searchFollowingListById(userId, editable.toString());
                usersLiveData.addSource(currentUsersData, users -> usersLiveData.setValue(users));
            }
        });

        currentUsersData = showFollowers ?
                followerDao.searchFollowerListById(userId, "") :
                followerDao.searchFollowingListById(userId,"");

        // LiveData observation
        usersLiveData.observe(getViewLifecycleOwner(), users -> userAdapter.setUsers(users));

        usersLiveData.addSource(currentUsersData, users -> usersLiveData.setValue(users));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        usersLiveData.removeSource(currentUsersData);
    }
}