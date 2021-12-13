package com.example.rnr_reporter.DataBase;

import android.content.Context;

import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.rnr_reporter.DataBase.DAOs.injuryDAO;
import com.example.rnr_reporter.DataBase.DAOs.propertyDAO;
import com.example.rnr_reporter.DataBase.DAOs.situationDAO;
import com.example.rnr_reporter.DataBase.Entities.Injury;
import com.example.rnr_reporter.DataBase.Entities.Property;
import com.example.rnr_reporter.DataBase.Entities.Situation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(version=8, entities={Injury.class, Property.class, Situation.class})
abstract public class dataBase extends RoomDatabase {
    abstract public injuryDAO getInjuryDAO();
    abstract public propertyDAO getPropertyDAO();
    abstract public situationDAO getSituationDAO();

    private static volatile dataBase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static public dataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (dataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            dataBase.class, "dataBase")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
