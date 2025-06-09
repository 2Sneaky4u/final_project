package com.example.runanalyser;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.runanalyser.databasestuff.AppDatabase;
import com.example.runanalyser.databasestuff.Game;
import com.example.runanalyser.databasestuff.GameDao;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class EditGameActivity extends AppCompatActivity {

    private GameDao gameDao;
    private Game curGame;

    private TextView NameTxt;
    private TextView GenreTxt;
    private TextView ReviewTxt;
    private TextView RatingTxt;
    private TextView StatusTxt;

    private ArrayList<View> visibilityViews = new ArrayList<>();
    private TextInputEditText editName;
    private TextInputEditText editGenre;
    private TextInputEditText editRating;
    private TextInputEditText editReview;
    private TextInputEditText editStatus;

    private Button editInfo;
    private Button saveEdits;
    private FloatingActionButton delGame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_game);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.editGame), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        AppDatabase appDatabase = AppDatabase.getDatabase(this);

        gameDao = appDatabase.gameDao();

        NameTxt = findViewById(R.id.gameNameView);
        GenreTxt = findViewById(R.id.gameGenreView);
        ReviewTxt = findViewById(R.id.gameReviewView);
        RatingTxt = findViewById(R.id.gameRatingView);
        StatusTxt = findViewById(R.id.gameStatusView);
        delGame = findViewById(R.id.deleteGameFAB);

        visibilityViews.add(findViewById(R.id.gtextInputLayout));
        visibilityViews.add(findViewById(R.id.gtextInputLayout2));
        visibilityViews.add(findViewById(R.id.gtextInputLayout3));
        visibilityViews.add(findViewById(R.id.gtextInputLayout4));
        visibilityViews.add(findViewById(R.id.gtextInputLayout5));
        visibilityViews.add(findViewById(R.id.warningTextg));
        editName = findViewById(R.id.newNameText);
        editGenre = findViewById(R.id.newGenreText);
        editRating = findViewById(R.id.newRatingText);
        editReview = findViewById(R.id.newReviewText);
        editStatus = findViewById(R.id.newStatusText);
        editInfo = findViewById(R.id.editGameinfoBtn);
        saveEdits = findViewById(R.id.saveGameEditsBtn);

        int curgameid = getIntent().getIntExtra(Globals.DEST_ID, 0);

        if (!getIntent().getBooleanExtra(Globals.ITEM_EDITABLE, false)) {
            editInfo.setActivated(false);
            saveEdits.setActivated(false);
            delGame.setActivated(false);
            editInfo.setVisibility(View.GONE);
            saveEdits.setVisibility(View.GONE);
            delGame.setVisibility(View.GONE);
        }

        if (curgameid == 0) {
            curGame = new Game();
            curGame.userId = Globals.getCurUser().id;
        } else {
            new Thread(() -> {
                curGame = gameDao.getGameByID(curgameid);
                runOnUiThread(() -> refreshGameInfo());
                System.out.println("--> cur game in thread " + curGame);
            }).start();
            System.out.println("--> cur game after thread " + curGame);
        }

        editInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (View layout : visibilityViews) {
                    layout.setVisibility(View.VISIBLE);
                }
                editName.setVisibility(View.VISIBLE);
                editGenre.setVisibility(View.VISIBLE);
                editRating.setVisibility(View.VISIBLE);
                editReview.setVisibility(View.VISIBLE);
                saveEdits.setVisibility(View.VISIBLE);
                editStatus.setVisibility(View.VISIBLE);
                editInfo.setVisibility(View.INVISIBLE);
            }
        });

        saveEdits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("---> on click check start" + this + " <---> " + Globals.getCurUser().id);

                String name = editName.getText().toString();
                String genre = editGenre.getText().toString();
                String rating = (editRating.getText().toString());
                String status = (editStatus.getText().toString());
                String desc = editReview.getText().toString();
                if (validateValue(name, genre, rating, status, desc)) {
                    curGame.name = name;
                    curGame.genre = genre;
                    curGame.rating = Integer.parseInt(rating);
                    curGame.completion = Integer.parseInt(status);
                    curGame.review = desc;
                    new Thread(() -> {
                        if (curgameid != 0) {
                            gameDao.editGame(curGame);
                        } else {
                            gameDao.insertGame(curGame);
                            finish();
                        }
                        System.out.println("---> on click check end" + this + " <---> " + Globals.getCurUser());
                    }).start();
                    for (View layout : visibilityViews) {
                        layout.setVisibility(View.INVISIBLE);
                    }
                    editName.setVisibility(View.INVISIBLE);
                    editGenre.setVisibility(View.INVISIBLE);
                    editRating.setVisibility(View.INVISIBLE);
                    editReview.setVisibility(View.INVISIBLE);
                    editStatus.setVisibility(View.INVISIBLE);
                    saveEdits.setVisibility(View.INVISIBLE);
                    editInfo.setVisibility(View.VISIBLE);
                    refreshGameInfo();
                }

            }
        });

        delGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("--> fab clicked " + curGame);
                final CharSequence[] options = {"Are you sure you want to delete this game?\nThis cannot be undone.", "Delete", "Cancel"};
                AlertDialog.Builder builder = new AlertDialog.Builder(EditGameActivity.this);
                builder.setTitle("Delete Game?");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (options[which].equals("Delete")) {
                            AppDatabase.dtbWriteExecutor.execute(() -> {
                                gameDao.delGame(curGame);
                                finish();
                            });
                        } else if (options[which].equals("Cancel")) {
                            dialog.dismiss();
                        } else if (which == 1) {
                        }
                    }
                });
                builder.show();
            }
        });
    }

    private void showToast(String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(EditGameActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validateValue(String name, String genre, String rating, String status, String desc) {

        if (name.isEmpty() || genre.isEmpty() || rating.isEmpty() || status.isEmpty() || desc.isEmpty()) {
            showToast("All fields must be filled");
            return false;
        }
        int rate = Integer.parseInt(rating);
        if (rate > 10 || rate < 1) {
            showToast("Rating must be between 1 and 10");
            return false;
        }
        int completion = Integer.parseInt(status);
        if (completion > 100 || completion < 0) {
            showToast("Completion status must be between 0 and 100");
            return false;
        }

        return true;
    }

    private void refreshGameInfo() {
        NameTxt.setText(curGame.name);
        editName.setText(curGame.name);
        GenreTxt.setText(curGame.genre);
        editGenre.setText(curGame.genre);
        ReviewTxt.setText(curGame.review);
        editReview.setText(curGame.review);
        RatingTxt.setText(String.valueOf(curGame.rating));
        editRating.setText(String.valueOf(curGame.rating));
        StatusTxt.setText(String.valueOf(curGame.completion));
        editStatus.setText(String.valueOf(curGame.completion));

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();

    }
}