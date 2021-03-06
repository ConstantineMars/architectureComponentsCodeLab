package com.example.android.sunshine.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

/**
 * Created by Constantine Mars on 9/18/17.
 */

@Database(entities = {WeatherEntry.class}, version = 1)
@TypeConverters(DateConverter.class)
public abstract class WeatherDatabase extends RoomDatabase {
    public abstract WeatherDao weatherDao(); //Getters for Dao

    private static final String DATABASE_NAME = "weather";

    // For Singleton instantiation
    private static final Object LOCK = new Object();
    private static volatile WeatherDatabase sInstance;

    public static WeatherDatabase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                if (sInstance == null) {
                    sInstance = Room.databaseBuilder(context.getApplicationContext(),
                            WeatherDatabase.class, WeatherDatabase.DATABASE_NAME).build();
                }
            }
        }
        return sInstance;
    }
}
