package com.example.rnr_reporter.DataBase.DAOs;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.rnr_reporter.DataBase.Entities.Situation;

import java.util.List;

@Dao
public interface situationDAO {
    @Insert//(onConflict = OnConflictStrategy.REPLACE)
    public void insertSituation(Situation situationForm);

    @Query("SELECT * FROM Situation")
    LiveData<List<Situation>> getAll();

}
