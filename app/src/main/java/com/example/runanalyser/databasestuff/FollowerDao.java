package com.example.runanalyser.databasestuff;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface FollowerDao {
    @Insert
    long insertFollower(Follower follower);

    @Update
    void editFollower(Follower follower);

    @Delete
    void delFollower(Follower follower);

    @Query("SELECT *\n" +
            "FROM Users\n" +
            "JOIN Followers ON users.userId = followers.followingId\n" +
            "WHERE followers.followerId = :id\n" +
            "ORDER BY users.username ASC")
    LiveData<List<User>> getFollowingListById(int id);
    @Query("SELECT count(*)\n" +
            "FROM Users\n" +
            "JOIN Followers ON Users.userId = Followers.followingId\n" +
            "WHERE Followers.followerId = :id")
    int countFollowing(int id);

    @Query("SELECT *\n" +
            "FROM Users\n" +
            "JOIN Followers ON users.userId = followers.followerId\n" +
            "WHERE followers.followingId = :id\n" +
            "ORDER BY users.username ASC")
    LiveData<List<User>> getFollowerListById(int id);
    @Query("SELECT count(*)\n" +
            "FROM Users\n" +
            "JOIN Followers ON Users.userId = Followers.followerId\n" +
            "WHERE Followers.followingId = :id")
    int countFollowers(int id);

}
