package com.monu.rbflightapp.database;

import android.content.Context;

import androidx.room.Room;

public class DatabaseClient {
    private Context context;
    private static DatabaseClient mInstance;

    private RoasterDatabase roasterDatabase;

    public DatabaseClient(Context context) {
        this.context = context;

        roasterDatabase = Room.databaseBuilder(context, RoasterDatabase.class, "alldata").build();

    }

    public static synchronized DatabaseClient getInstance(Context context){
        if (mInstance == null){
            mInstance = new DatabaseClient(context);

        }
        return mInstance;
    }

    public RoasterDatabase getRoasterDatabase(){
        return roasterDatabase;
    }

}
