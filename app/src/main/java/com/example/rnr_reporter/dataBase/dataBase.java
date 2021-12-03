package com.example.rnr_reporter.dataBase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.rnr_reporter.DAOs.injuryDAO;
import com.example.rnr_reporter.Entities.injuryForm;

@Database(version=1, entities={injuryForm.class})
abstract class dataBase extends RoomDatabase {
    abstract public injuryDAO getInjuryDAO();

}
