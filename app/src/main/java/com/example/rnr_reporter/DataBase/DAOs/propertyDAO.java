package com.example.rnr_reporter.DataBase.DAOs;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.rnr_reporter.DataBase.Entities.Property;

import java.util.List;

@Dao
public interface propertyDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertProperty(Property propertyForm);

    @Query("SELECT * FROM Property")
    LiveData<List<Property>> getAll();

}
