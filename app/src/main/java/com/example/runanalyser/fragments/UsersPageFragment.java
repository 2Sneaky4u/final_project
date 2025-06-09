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
import com.example.runanalyser.SearchNavigationActivity;
import com.example.runanalyser.databasestuff.AppDatabase;
import com.example.runanalyser.databasestuff.User;
import com.example.runanalyser.databasestuff.UserAdapter;
import com.example.runanalyser.databasestuff.UserDao;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class UsersPageFragment extends Fragment {
    private UserAdapter userAdapter;
    private MediatorLiveData<List<User>> usersLiveData = new MediatorLiveData<>();
    private LiveData<List<User>> currentUsersData;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_users_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AppDatabase dataBase = AppDatabase.getDatabase(requireContext());
        UserDao userDao = dataBase.userDao();
        RecyclerView userRC = view.findViewById(R.id.usersRecyclerView);

        TextView usercount = view.findViewById(R.id.userCountTxt);
        new Thread(()->{
            int count = userDao.countUsers();
            getActivity().runOnUiThread(()-> usercount.setText(String.valueOf(count)));
        }).start();

        // Initialize adapter
        userAdapter = new UserAdapter(new ArrayList<>(), getActivity(), new UserAdapter.OnUserClickListener() {
            @Override
            public void onUserClick(User user) {
                SearchNavigationActivity nav = (SearchNavigationActivity) getActivity();
                nav.switchFragToNewUserProfile(new OtherUserProfileFragment(user));
            }
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
                currentUsersData = userDao.getUsersListByNameExCur(editable.toString(), Globals.getCurUser().id);
                usersLiveData.addSource(currentUsersData, users -> usersLiveData.setValue(users));
            }
        });

        // LiveData observation
        usersLiveData.observe(getViewLifecycleOwner(), users -> userAdapter.setUsers(users));

        currentUsersData = userDao.getUsersListByNameExCur("", Globals.getCurUser().id);
        usersLiveData.addSource(currentUsersData, users -> usersLiveData.setValue(users));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        usersLiveData.removeSource(currentUsersData);
    }
}