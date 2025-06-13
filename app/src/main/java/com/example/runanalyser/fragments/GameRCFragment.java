package com.example.runanalyser.fragments;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.runanalyser.EditGameActivity;
import com.example.runanalyser.Globals;
import com.example.runanalyser.R;
import com.example.runanalyser.databasestuff.AppDatabase;
import com.example.runanalyser.databasestuff.Game;
import com.example.runanalyser.databasestuff.GameAdapter;
import com.example.runanalyser.databasestuff.GameDao;
import com.example.runanalyser.databasestuff.User;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class GameRCFragment extends Fragment {

    private final GameAdapter gameAdapter = new GameAdapter(new ArrayList<>(), getActivity(), new GameAdapter.OnGameClickListener() {
        @Override
        public void onGameClick(Game game) {
            Intent intent = new Intent(getActivity(), EditGameActivity.class);
            intent.putExtra(Globals.DEST_ID, game.id);
            intent.putExtra(Globals.ITEM_EDITABLE,user == Globals.getCurUser());
            getActivity().startActivity(intent);
        }
    });


    private final MediatorLiveData<List<Game>> gamesLiveData = new MediatorLiveData<>();
    private LiveData<List<Game>> currentGamesData;
    private User user;
    private Activity activity;


    public GameRCFragment() {
        this.user = Globals.getCurUser();
    }

    public GameRCFragment(User user) {
        this.user = user;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game_rc, container, false);
        AppDatabase dataBase = AppDatabase.getDatabase(getActivity());
        GameDao gameDao = dataBase.gameDao();

        activity = requireActivity();

        RecyclerView gameRc;
        gameRc = view.findViewById(R.id.gamesRecyclerView);
        gameRc.setLayoutManager(new LinearLayoutManager(activity));
        gameRc.setAdapter(gameAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                AppDatabase.dtbWriteExecutor.execute(new Runnable() {
                    @Override
                    public void run() {
                        if (direction == ItemTouchHelper.LEFT) {
                            List<Game> gameList = gameAdapter.getCurrentList();
                            Game destGame = gameList.get(viewHolder.getAdapterPosition());
                            final CharSequence[] options = {"Are you sure you want to delete this game?\nThis cannot be undone.", "Delete", "Cancel"};
                            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                            builder.setTitle("Delete Game?");
                            builder.setItems(options, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if (options[which].equals("Delete")) {
                                        AppDatabase.dtbWriteExecutor.execute(() -> {
                                            gameDao.delGame(destGame);
                                        });
                                    } else if (options[which].equals("Cancel")) {
                                        dialog.dismiss();
                                        gameAdapter.notifyDataSetChanged();
                                    } else if (which == 1) {
                                    }
                                }
                            });
                            activity.runOnUiThread(()->builder.show());
                        }
                    }
                });
            }
        });
        itemTouchHelper.attachToRecyclerView(gameRc);

        TextInputLayout searchGameInput = view.findViewById(R.id.gameSearchBar);
        EditText searchText = searchGameInput.getEditText();
        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                gamesLiveData.removeSource(currentGamesData);

                currentGamesData = gameDao.getGamesForUserid(user.id, editable.toString());

                gamesLiveData.addSource(currentGamesData, new Observer<List<Game>>() {
                    @Override
                    public void onChanged(List<Game> games) {
                        gamesLiveData.setValue(games);
                    }
                });
            }
        });
        gamesLiveData.observe(getActivity(), new Observer<List<Game>>() {
            @Override
            public void onChanged(List<Game> games) {
                gameAdapter.setGames(games);
            }
        });

        currentGamesData = gameDao.getGamesForUserid(user.id, "");
        gamesLiveData.addSource(currentGamesData, new Observer<List<Game>>() {
            @Override
            public void onChanged(List<Game> games) {
                gamesLiveData.setValue(games);
            }
        });

        TextView gamecount = view.findViewById(R.id.gameCountTxt);
        new Thread(()->{
            int count = gameDao.countConnectedGamesToUserId(user.id);
            activity.runOnUiThread(()-> gamecount.setText(String.valueOf(count)));
        }).start();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}