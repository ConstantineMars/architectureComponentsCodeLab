package com.example.android.sunshine.data.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Constantine Mars on 9/18/17.
 */

@Dao
public interface WeatherDao {
    @Query("SELECT * FROM weather")
    List<WeatherEntry> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void bulkInsert(WeatherEntry... weatherEntries);

    // Deletes a single user
    @Delete
    void delete(WeatherEntry weatherEntry);
}
