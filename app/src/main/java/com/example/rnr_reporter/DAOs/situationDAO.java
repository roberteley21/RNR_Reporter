package com.example.rnr_reporter.DAOs;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.rnr_reporter.Entities.situationForm;

import java.util.List;

@Dao
public interface situationDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertSituation(situationForm situationForm);

    @Query("SELECT * FROM injuryForm")
    List<situationForm> getAll();
}
