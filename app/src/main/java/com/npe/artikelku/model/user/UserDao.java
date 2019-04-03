package com.npe.artikelku.model.user;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

@Dao
public interface UserDao {
    @Insert
    void insert(UserModel userModel);
    @Update
    void update(UserModel userModel);
    @Delete
    void delete(UserModel userModel);
    @Query("DELETE FROM user_table")
    void deleteAllUser();
    @Query("SELECT * FROM user_table ORDER BY id ASC")
    LiveData<UserModel> getAllUser();
}
