package com.example.runanalyser.databasestuff;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {User.class, Game.class, Follower.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();

    public abstract GameDao gameDao();

    public abstract FollowerDao followerDao();

    private static final int NUM_OF_THREADS = 4;

    public static final ExecutorService dtbWriteExecutor = Executors.newFixedThreadPool(NUM_OF_THREADS);

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
