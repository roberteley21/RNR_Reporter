package com.example.rnr_reporter.DataBase;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.rnr_reporter.DataBase.DAOs.injuryDAO;
import com.example.rnr_reporter.DataBase.Entities.Injury;

import java.util.List;

public class rnrRepository {
    private injuryDAO mInjuryDao;
    private LiveData<List<Injury>> mAllInjury;

    public rnrRepository(Application application) {
        dataBase db = dataBase.getDatabase(application);
        mInjuryDao = db.getInjuryDAO();
        mAllInjury = mInjuryDao.getAll();
    }

   /* public LiveData<List<Injury>> getAllInjuries() {
        return mAllInjury;
    } */

    public void insert(Injury p_injury) {
        try {
            dataBase.databaseWriteExecutor.execute(() -> {
                mInjuryDao.insertInjury(p_injury);
            });
        } catch(Exception e){
            System.out.println(e);
        }
    }
}
