package com.example.runanalyser.databasestuff;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface GameDao {

    @Insert
    Void insertGame(Game game);

    @Update
    Void editGame(Game game);

    @Delete
    Void delGame(Game game);

    @Query("SELECT * FROM games WHERE gameId = :id")
    Game getGameByID(int id);

    @Query("Select * from games where games.userId = :id and games.name like :name || '%' order by rating,genre desc")
    LiveData<List<Game>> getGamesForUserid(int id, String name);

    @Query("SELECT COUNT(*) \n" +
            "FROM GAMES \n" +
            "WHERE Games.userId = :id;")
    int countConnectedGamesToUserId(int id);
    }

