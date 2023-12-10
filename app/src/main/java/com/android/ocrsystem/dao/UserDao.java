package com.android.ocrsystem.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.android.ocrsystem.model.UserInfo;

import java.util.List;

@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(UserInfo userInfo);

    @Query("SELECT * FROM userinfo")
    List<UserInfo> getAllUsers();
}

