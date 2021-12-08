package com.example.rnr_reporter.DataBase.DAOs;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.rnr_reporter.DataBase.Entities.Injury;

import java.util.List;

@Dao
public interface injuryDAO {
    @Insert//(onConflict = OnConflictStrategy.REPLACE)
    public void insertInjury(Injury injury);

    @Query("SELECT * FROM Injury")
    LiveData<List<Injury>> getAll();

}