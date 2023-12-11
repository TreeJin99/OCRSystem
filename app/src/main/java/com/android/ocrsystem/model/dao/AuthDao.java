package com.android.ocrsystem.model.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.android.ocrsystem.model.UserInfo;


@Dao
public interface AuthDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void createUser(UserInfo userInfo);

    @Update
    public void updateUserInfo(UserInfo userInfo);

    @Query("SELECT * FROM userinfo WHERE email = :email AND password = :password")
    UserInfo getSignIn(String email, String password);

    @Query("SELECT * FROM userinfo WHERE id = :userId")
    UserInfo getUserInfoById(int userId);


}

