package com.example.rnr_reporter.DataBase;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.rnr_reporter.DataBase.DAOs.injuryDAO;
import com.example.rnr_reporter.DataBase.DAOs.propertyDAO;
import com.example.rnr_reporter.DataBase.DAOs.situationDAO;
import com.example.rnr_reporter.DataBase.Entities.Injury;
import com.example.rnr_reporter.DataBase.Entities.Property;
import com.example.rnr_reporter.DataBase.Entities.Situation;

import java.util.List;

public class rnrRepository {
    private injuryDAO mInjuryDao;
    private propertyDAO mPropertyDao;
    private situationDAO mSituationDao;
    private LiveData<List<Injury>> mAllInjuries;
    private LiveData<List<Property>> mAllProperties;
    private LiveData<List<Situation>> mAllSituations;

    public rnrRepository(Application application) {
        dataBase db = dataBase.getDatabase(application);
        this.mInjuryDao = db.getInjuryDAO();
        this.mPropertyDao = db.getPropertyDAO();
        this.mSituationDao = db.getSituationDAO();
        this.mAllInjuries = mInjuryDao.getAll();
        this.mAllProperties = mPropertyDao.getAll();
        this.mAllSituations = mSituationDao.getAll();
    }

    public LiveData<List<Injury>> getAllInjuries() {
        return this.mAllInjuries;
    }

    public LiveData<List<Property>> getAllProperties() {
        return this.mAllProperties;
    }

    public LiveData<List<Situation>> getAllSituations() {
        return this.mAllSituations;
    }

    public void insertInjury(Injury p_injury) {
        dataBase.databaseWriteExecutor.execute(() -> {
            this.mInjuryDao.insertInjury(p_injury);
        });
    }

    public void insertProperty(Property p_property) {
        dataBase.databaseWriteExecutor.execute(() -> {
            this.mPropertyDao.insertProperty(p_property);
        });
    }

    public void insertSituation(Situation p_situation) {
        dataBase.databaseWriteExecutor.execute(() -> {
            this.mSituationDao.insertSituation(p_situation);
        });
    }

}
