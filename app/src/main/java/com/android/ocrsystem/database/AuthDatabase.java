package com.android.ocrsystem.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.android.ocrsystem.model.UserAccount;

@Database(entities = {UserAccount.class}, version = 1)
public abstract class AuthDatabase extends RoomDatabase {
}
