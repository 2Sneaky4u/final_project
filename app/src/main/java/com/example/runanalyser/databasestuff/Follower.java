package com.example.runanalyser.databasestuff;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "followers", foreignKeys = {@ForeignKey(entity = User.class, parentColumns = "userId", childColumns = "followerId", onDelete = ForeignKey.CASCADE), @ForeignKey(entity = User.class, parentColumns = "userId", childColumns = "followingId", onDelete = ForeignKey.CASCADE)},
primaryKeys = {"followerId","followingId"})

public class Follower {
    public int followerId;
    public int followingId;

    public Follower(int followerId, int followingId) {
        this.followerId = followerId;
        this.followingId = followingId;
    }
}
