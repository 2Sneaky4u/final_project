package com.example.runanalyser.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.runanalyser.Globals;
import com.example.runanalyser.MainActivity;
import com.example.runanalyser.R;
import com.example.runanalyser.UserProfileActivity;
import com.example.runanalyser.databasestuff.AppDatabase;
import com.example.runanalyser.databasestuff.User;

public class LoginFragment extends Fragment {

    private AppDatabase appDatabase;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        appDatabase = AppDatabase.getDatabase(requireContext());
        EditText usernameEditText = view.findViewById(R.id.logUsernameEditText);
        EditText passwordEditText = view.findViewById(R.id.logPasswordEditText);
        Button loginButton = view.findViewById(R.id.loginButton);

        loginButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(getActivity(), "Please fill all fields🥀🥀🥀", Toast.LENGTH_SHORT).show();
            } else {
                new Thread(() -> {
                    User user = appDatabase.userDao().getUserByUsernameNPassword(username, password);
                    requireActivity().runOnUiThread(() -> {
                        if (user != null) {
                            Toast.makeText(getActivity(), "Login successful", Toast.LENGTH_SHORT).show();
                            Globals.setCurUser(user);
                            Intent intent = new Intent(getActivity(), UserProfileActivity.class);
                            startActivity(intent);

                        } else {
                            Toast.makeText(getActivity(), "Invalid credentials🥀🥀🥀", Toast.LENGTH_SHORT).show();
                        }
                    });
                }).start();
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView switchfrag = view.findViewById(R.id.gotosignup);

        switchfrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.changeFragToSignup();
            }
        });
    }
}
