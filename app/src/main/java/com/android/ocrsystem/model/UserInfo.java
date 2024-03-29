package com.android.ocrsystem.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.android.ocrsystem.util.converter.AllergyListConverter;
import java.util.List;

@TypeConverters(AllergyListConverter.class)
@Entity(tableName = "userinfo")
public class UserInfo {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "password")
    private String password;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "allergy")
    private List<String> allergyList;

    @ColumnInfo(name = "created_at")
    private long createdAt;

    public UserInfo(String name, String email, String password, List<String> allergyList) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.allergyList = allergyList;
        this.createdAt = System.currentTimeMillis();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public List<String> getAllergyList() {
        return allergyList;
    }

    public void setAllergyList(List<String> allergyList) {
        this.allergyList = allergyList;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", allergyList=" + allergyList +
                ", createdAt=" + createdAt +
                '}';
    }

}