package com.example.runanalyser;

import android.app.Activity;
import android.content.Intent;

import com.example.runanalyser.databasestuff.User;

public class Globals {
    public static final String DEST_ID = "SNCJQWNFBWN";
    public static final String ITEM_EDITABLE = "SKNMFKJDSNVJKNA";
    private static User curUser;

    public static User getCurUser() {
        return curUser;
    }

    public static void setCurUser(User curUser) {
        Globals.curUser = curUser;
    }

    public static void logOut(Activity context) {
        curUser = null;
        context.finishAffinity();
        context.startActivity(new Intent(context, MainActivity.class));
    }

}
