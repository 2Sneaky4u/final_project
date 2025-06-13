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
    void insertFollower(Follower follower);

    @Update
    void editFollower(Follower follower);

    @Delete
    void delFollower(Follower follower);

    @Query("SELECT count(*)\n" +
            "FROM Users\n" +
            "JOIN Followers ON Users.userId = Followers.followingId\n" +
            "WHERE Followers.followerId = :id")
    int countFollowing(int id);

    @Query("SELECT count(*)\n" +
            "FROM Users\n" +
            "JOIN Followers ON Users.userId = Followers.followerId\n" +
            "WHERE Followers.followingId = :id")
    int countFollowers(int id);

    @Query("SELECT * \n" +
            "FROM Followers \n" +
            "WHERE followerId = :followerUserId \n" +
            "AND followingId = :targetUserId")
    Follower getFollowItemByIds(int followerUserId, int targetUserId);

    @Query("SELECT * FROM users WHERE userId IN (SELECT followingId FROM followers WHERE followerId = :id) AND username LIKE '%' || :query || '%'")
    LiveData<List<User>> searchFollowingListById(int id, String query);

    @Query("SELECT * FROM users WHERE userId IN (SELECT followerId FROM followers WHERE followingId = :id) AND username LIKE '%' || :query || '%'")
    LiveData<List<User>> searchFollowerListById(int id, String query);

}
