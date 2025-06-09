package com.example.runanalyser.databasestuff;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "games", foreignKeys = @ForeignKey(entity = User.class, parentColumns = "userId", childColumns = "userId", onDelete = ForeignKey.CASCADE))
public class Game {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "gameId")
    public int id;

    public int userId;

    public String name;
    public String genre;
    public int completion;
    public int rating;
    public String review;

    public Game() {
    }
}
