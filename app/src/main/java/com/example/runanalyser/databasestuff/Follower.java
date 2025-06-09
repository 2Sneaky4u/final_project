package com.example.runanalyser.databasestuff;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "followers", foreignKeys = {@ForeignKey(entity = User.class, parentColumns = "userId", childColumns = "followerId", onDelete = ForeignKey.CASCADE), @ForeignKey(entity = User.class, parentColumns = "userId", childColumns = "followingId", onDelete = ForeignKey.CASCADE)})

public class Follower {
    @PrimaryKey
    public int followerId;
    @PrimaryKey
    public int followingId;

    public Follower(int followerId, int followingId) {
        this.followerId = followerId;
        this.followingId = followingId;
    }
}
