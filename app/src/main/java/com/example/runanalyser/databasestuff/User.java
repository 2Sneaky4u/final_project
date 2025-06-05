package com.example.runanalyser.databasestuff;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "userId")
    public int id;

    public String username;
    public String password;
    public String phonenumber;
    public String description;
    public String pfpURI;

    // Constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
