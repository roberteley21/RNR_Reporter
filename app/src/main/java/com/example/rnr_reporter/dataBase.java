package com.example.rnr_reporter;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.rnr_reporter.DAOs.injuryDAO;
import com.example.rnr_reporter.DAOs.propertyDAO;
import com.example.rnr_reporter.DAOs.situationDAO;
import com.example.rnr_reporter.Entities.injuryForm;
import com.example.rnr_reporter.Entities.propertyForm;
import com.example.rnr_reporter.Entities.situationForm;

@Database(version=5, entities={injuryForm.class, propertyForm.class, situationForm.class})
abstract public class dataBase extends RoomDatabase {
    abstract public injuryDAO getInjuryDAO();
    abstract public propertyDAO getPropertyDAO();
    abstract public situationDAO getSituationDAO();

    private static dataBase dbInstance;

    static public dataBase getDataBase(final Context context) {
        if(dbInstance == null) {
            dbInstance = Room.databaseBuilder( context, dataBase.class, "dataBase").build();
        }
        return dbInstance;
    }
}
