package com.monu.rbflightapp.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.monu.rbflightapp.entitty.Roaster;

import java.util.List;

@Dao
public interface RoasterDao {

    @Query("SELECT * FROM task")
    List<Roaster> getAll();

    @Insert
    void insert(Roaster roaster);

}
