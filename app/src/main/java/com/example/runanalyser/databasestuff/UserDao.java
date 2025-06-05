package com.example.runanalyser.databasestuff;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    long insertUser(User user);

    @Update
    void editUser(User user);

    @Delete
    void delUser(User user);

    @Query("SELECT * FROM users WHERE username = :username AND password = :password")
    User getUserByUsernameNPassword(String username, String password);

    @Query("SELECT * FROM users WHERE username = :username")
    User getUserByUsername(String username);

    @Query("SELECT * FROM users WHERE userId = :id")
    User getUserByID(String id);

    @Query("SELECT COUNT(*) AS game_item_count\n" +
            "FROM GAMES \n" +
            "WHERE Games.userId = :id;")
    int countConnectedGamesToUserById(int id);

    @Query("SELECT COUNT(*) FROM users")
    int countUsers();

    @Query("SELECT Round(AVG(Games.rating),2) AS average_rating FROM Games WHERE Games.userId = :id")
    double getAvgReviewFromAUser(int id);

    @Query("SELECT * FROM users where users.username like :s ||'%'")
    LiveData<List<User>> getUsersListByName(String s);

    @Query("SELECT * FROM users where users.username like :s ||'%' and users.userId != :id")
    LiveData<List<User>> getUsersListByNameExCur(String s, int id);
}

