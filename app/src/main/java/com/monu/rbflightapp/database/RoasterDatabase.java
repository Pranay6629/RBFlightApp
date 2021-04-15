package com.monu.rbflightapp.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.monu.rbflightapp.dao.RoasterDao;
import com.monu.rbflightapp.entitty.Roaster;

@Database(entities = {Roaster.class}, version = 1)
public abstract class RoasterDatabase extends RoomDatabase {
    public abstract RoasterDao roasterDao();
}
