package com.example.runanalyser;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.runanalyser.databasestuff.AppDatabase;
import com.example.runanalyser.databasestuff.User;
import com.example.runanalyser.databasestuff.UserDao;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class EditUserActivity extends AppCompatActivity {


    private AppDatabase appDatabase;
    private UserDao userDao;

    private ImageView previewProfilePic;
    private TextView UsernameTxt;
    private TextView PasswordTxt;
    private TextView DescriptionTxt;
    private TextView PhoneTxt;
    private TextView title;

    private ArrayList<View> visibilityViews = new ArrayList<>();
    private TextInputEditText editUsername;
    private TextInputEditText editPassword;
    private TextInputEditText editPhone;
    private TextInputEditText editDesc;

    private Button editUser;
    private Button saveEdits;
    private Button exitbtn;
    private FloatingActionButton delUser;
    private ActivityResultLauncher<String> requestPermissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback<Boolean>() {
        @Override
        public void onActivityResult(Boolean result) {
            if (result) {
                dispatchTakePictureIntent();
            } else showToast("The app needs camera access");
        }
    });

    private ActivityResultLauncher<String> pickImageLauncher = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
        @Override
        public void onActivityResult(Uri o) {
            if (o != null) {
                Uri uri = copyImageToAppDir(o);
                Globals.getCurUser().pfpURI = uri.toString();
                previewProfilePic.setImageURI(uri);
            }
        }
    });

    private ActivityResultLauncher<Intent> takePictureLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult o) {
            if (o.getResultCode() == Activity.RESULT_OK) {
                Intent data = o.getData();
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                Uri uri = saveImageToInternalStorage(imageBitmap);
                previewProfilePic.setImageURI(uri);
                Globals.getCurUser().pfpURI = uri.toString();
            } else {
                showToast("Camera permission is required to take photos");
            }
        }
    });

    private Uri copyImageToAppDir(Uri contentUri) {
        InputStream is = null;
        OutputStream os = null;
        try {
// Create file access components
            is = getContentResolver().openInputStream(contentUri);
            File outputDir = getApplicationContext().getFilesDir();
            File outputFile = new File(outputDir, "copied_image_" + System.currentTimeMillis() + ".jpg");
            os = new FileOutputStream(outputFile);
            byte[] buffer = new byte[1024];
            int length;
// Copy the file
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
            os.flush();
// Return the Uri of the copied file
            return Uri.fromFile(outputFile);
        } catch (IOException e) {
            showToast("Failed to copy image: ");
            e.printStackTrace();
            return null;
        } finally {
// Ensure all streams are properly closed
            try {
                if (is != null) {
                    is.close();
                }
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Uri saveImageToInternalStorage(Bitmap bitmap) {
        String imageName = "image_" + System.currentTimeMillis() + ".jpg";
        File storageDir = new File(getApplicationContext().getFilesDir(), "YourAppImages");
        if (!storageDir.exists()) {
            if (!storageDir.mkdirs()) {
                showToast("Failed to create directory");
                return null;
            }
        }
        File imageFile = new File(storageDir, imageName);
        try (FileOutputStream fos = new FileOutputStream(imageFile)) {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            showToast("Image saved to internal storage: " + imageFile.getAbsolutePath());
            return Uri.fromFile(imageFile);
        } catch (IOException e) {
            showToast("Failed to save image");
            e.printStackTrace();
        }
        return null;
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            takePictureLauncher.launch(takePictureIntent);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_user);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.editUser), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        appDatabase = AppDatabase.getDatabase(this);
        userDao = appDatabase.userDao();

        previewProfilePic = findViewById(R.id.profilePreview);
        UsernameTxt = findViewById(R.id.myUsernameView);
        PasswordTxt = findViewById(R.id.myPasswordView);
        DescriptionTxt = findViewById(R.id.myBioView);
        PhoneTxt = findViewById(R.id.myPhoneView);
        exitbtn = findViewById(R.id.leavebtn);
        delUser = findViewById(R.id.deleteUserFAB);
        title = findViewById(R.id.textView);
        title.setText(getIntent().getStringExtra("Title") + " your user");

        visibilityViews.add(findViewById(R.id.textInputLayout));
        visibilityViews.add(findViewById(R.id.textInputLayout2));
        visibilityViews.add(findViewById(R.id.textInputLayout3));
        visibilityViews.add(findViewById(R.id.textInputLayout4));
        visibilityViews.add(findViewById(R.id.warningText));
        editUsername = findViewById(R.id.newUsernameText);
        editPassword = findViewById(R.id.newPasswordText);
        editPhone = findViewById(R.id.newPhoneText);
        editDesc = findViewById(R.id.newDescText);
        editUser = findViewById(R.id.editUserinfoBtn);
        saveEdits = findViewById(R.id.saveEditsBtn);

        editUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (View layout : visibilityViews) {
                    layout.setVisibility(View.VISIBLE);
                }
                editUsername.setVisibility(View.VISIBLE);
                editPassword.setVisibility(View.VISIBLE);
                editPhone.setVisibility(View.VISIBLE);
                editDesc.setVisibility(View.VISIBLE);
                saveEdits.setVisibility(View.VISIBLE);
                previewProfilePic.setClickable(true);
                exitbtn.setVisibility(View.INVISIBLE);
                editUser.setVisibility(View.INVISIBLE);
            }
        });

        saveEdits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editUsername.getText().toString();
                String password = editPassword.getText().toString();
                String phone = editPhone.getText().toString();
                String desc = editDesc.getText().toString();

                new Thread(() -> {
                    boolean saveSuccessful = true;

                    if (!username.isEmpty()) {
                        if (validateUsernameInput(username)) {
                            User checkuser = appDatabase.userDao().getUserByUsername(username);
                            if (checkuser != null && !checkuser.username.equals(Globals.getCurUser().username)) {
                                showToast("Username already exists");
                                saveSuccessful = false;
                            } else {
                                Globals.getCurUser().username = username;
                            }
                        } else {
                            saveSuccessful = false;
                        }
                    }

                    if (!password.isEmpty()) {
                        if (validatePasswordInput(password)) {
                            Globals.getCurUser().password = password;
                        } else {
                            saveSuccessful = false;
                        }
                    }

                    if (!phone.isEmpty()) {
                        Globals.getCurUser().phonenumber = phone;
                    }

                    if (!desc.isEmpty()) {
                        Globals.getCurUser().description = desc;
                    }

                    if (saveSuccessful) {
                        userDao.editUser(Globals.getCurUser());

                        runOnUiThread(() -> {
                            for (View layout : visibilityViews) {
                                layout.setVisibility(View.INVISIBLE);
                            }
                            editUsername.setVisibility(View.INVISIBLE);
                            editPassword.setVisibility(View.INVISIBLE);
                            editPhone.setVisibility(View.INVISIBLE);
                            editDesc.setVisibility(View.INVISIBLE);
                            saveEdits.setVisibility(View.INVISIBLE);
                            previewProfilePic.setClickable(false);
                            exitbtn.setVisibility(View.VISIBLE);
                            editUser.setVisibility(View.VISIBLE);
                            refreshUserInfo();
                        });
                    }
                }).start();
            }
        });

        previewProfilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence[] options = {"Take Picture", "Pick from Gallery", "Cancel"};
                AlertDialog.Builder builder = new AlertDialog.Builder(EditUserActivity.this);
                builder.setTitle("Choose your image source");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (options[which].equals("Take Picture")) {
                            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                                requestPermissionLauncher.launch(Manifest.permission.CAMERA);
                            }
                        } else if (options[which].equals("Pick from Gallery")) {
                            pickImageLauncher.launch("image/*");
                        } else if (options[which].equals("Cancel")) {
                            dialog.dismiss();
                        }
                    }
                });
                builder.show();
            }
        });
        previewProfilePic.setClickable(false);


        exitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditUserActivity.this, UserProfileActivity.class);
                startActivity(intent);
            }
        });

        delUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final CharSequence[] options = {"Are you sure you want to delete your user?\nThis cannot be undone.", "Delete", "Cancel"};
                AlertDialog.Builder builder = new AlertDialog.Builder(EditUserActivity.this);
                builder.setTitle("Delete User?");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (options[which].equals("Delete")) {
                            AppDatabase.dtbWriteExecutor.execute(()->{
                                userDao.delUser(Globals.getCurUser());
                                Globals.logOut(EditUserActivity.this);
                            });
                        } else if (options[which].equals("Cancel")) {
                            dialog.dismiss();
                        }else if (which == 1) {
                        }
                    }
                });
                builder.show();
            }
        });

        refreshUserInfo();
    }

    private void showToast(String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(EditUserActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validateUsernameInput(@NonNull String username) {
        if (username.length() < 3) {
            showToast("Username must be 3 characters or longer");
            return false;
        }
        if (username.matches(".*\\d.*")) {
            showToast("Username can't contain any numbers");
            return false;
        }

        return true; // All validations passed
    }

    private boolean validatePasswordInput(@NonNull String password) {
        if (password.length() < 8) {
            showToast("Password must be 8 characters or longer");
            return false;
        }
        if (!password.matches(".*\\d.*")) {
            showToast("Password must contain at least one number");
            return false;
        }
        if (!password.matches(".*[A-Z].*")) {
            showToast("Password must contain at least one capital letter");
            return false;
        }
        return true;
    }

    private void refreshUserInfo() {
        UsernameTxt.setText(Globals.getCurUser().username);
        PasswordTxt.setText(Globals.getCurUser().password);
        DescriptionTxt.setText(Globals.getCurUser().description);
        PhoneTxt.setText(Globals.getCurUser().phonenumber);
        if (Globals.getCurUser().pfpURI != null)
            previewProfilePic.setImageURI(Uri.parse(Globals.getCurUser().pfpURI));
    }


}


