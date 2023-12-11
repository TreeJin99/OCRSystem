package com.android.ocrsystem.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.android.ocrsystem.model.UserInfo;

import java.util.List;

@Dao
public interface UserInfoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(UserInfo userInfo);

    @Query("SELECT * FROM userinfo WHERE id = :userId")
    UserInfo getUserInfoById(int userId);

    @Update
    void updateUserInfo(UserInfo userInfo);

}

