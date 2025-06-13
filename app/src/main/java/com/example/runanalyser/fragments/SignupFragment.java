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

import com.example.runanalyser.EditUserActivity;
import com.example.runanalyser.Globals;
import com.example.runanalyser.MainActivity;
import com.example.runanalyser.R;
import com.example.runanalyser.databasestuff.AppDatabase;
import com.example.runanalyser.databasestuff.User;

public class SignupFragment extends Fragment {

    private AppDatabase appDatabase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);

        appDatabase = AppDatabase.getDatabase(requireContext());

        EditText usernameEditText = view.findViewById(R.id.signUsernameEditText);
        EditText passwordEditText = view.findViewById(R.id.signPasswordEditText);
        EditText confirmPasswordEditText = view.findViewById(R.id.confirm_signPasswordEditText);
        Button signupButton = view.findViewById(R.id.signupButton);

        signupButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();
            String confirmpassword = confirmPasswordEditText.getText().toString().trim();

            if (validateInput(username, password, confirmpassword)) {
                new Thread(() -> {
                    User existingUser = appDatabase.userDao().getUserByUsername(username);
                    User newUser = new User(username, password);
                    if (existingUser == null) {
                        newUser.id = ((int) appDatabase.userDao().insertUser(newUser));
                    }
                    getActivity().runOnUiThread(() -> {
                        if (existingUser != null) {
                            showToast("Username already exists🥀🥀🥀");
                        } else {
                            showToast("Signup successfully");
                            Globals.setCurUser(newUser);
                            Intent intent = new Intent(getActivity(), EditUserActivity.class);
                            intent.putExtra("Title", "Create");
                            startActivity(intent);
                        }
                    });
                }).start();
            }
        });

        return view;
    }

    private void showToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    private boolean validateInput(@NonNull String username, String password, String confirmPassword) {
        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            showToast("Please fill all fields🥀🥀🥀");
            return false;
        }
        if (username.length() < 3) {
            showToast("Username must be 3 characters or longer🥀🥀🥀");
            return false;
        }
        if (username.matches(".*\\d.*")) {
            showToast("Username can't contain any numbers🥀🥀🥀");
            return false;
        }
        if (password.length() < 8) {
            showToast("Password must be 8 characters or longer🥀🥀🥀");
            return false;
        }
        if (!password.matches(".*\\d.*")) {
            showToast("Password must contain at least one number🥀🥀🥀");
            return false;
        }
        if (!password.matches(".*[A-Z].*")) {
            showToast("Password must contain at least one capital letter🥀🥀🥀");
            return false;
        }
        if (!password.equals(confirmPassword)) {
            showToast("Passwords do not match🥀🥀🥀");
            return false;
        }
        return true; // All validations passed
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView switchfrag = view.findViewById(R.id.gotologin);

        switchfrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.changeFragToLogin();
            }
        });
    }
}
