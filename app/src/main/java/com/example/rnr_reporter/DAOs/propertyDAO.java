package com.example.rnr_reporter.DAOs;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.rnr_reporter.Entities.propertyForm;

import java.util.List;

@Dao
public interface propertyDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertProperty(propertyForm propertyForm);

    @Query("SELECT * FROM injuryForm")
    List<propertyForm> getAll();
}
