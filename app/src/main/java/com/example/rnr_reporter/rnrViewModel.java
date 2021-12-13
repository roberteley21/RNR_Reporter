package com.example.rnr_reporter;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import com.example.rnr_reporter.DataBase.Entities.Injury;
import com.example.rnr_reporter.DataBase.Entities.Property;
import com.example.rnr_reporter.DataBase.Entities.Situation;
import com.example.rnr_reporter.DataBase.rnrRepository;

import java.util.List;

public class rnrViewModel extends AndroidViewModel {
    private rnrRepository repository;

    private final LiveData<List<Injury>> mAllInjuries;
    private final LiveData<List<Property>> mAllProperties;
    private final LiveData<List<Situation>> mAllSituations;

    public rnrViewModel (Application application) {
        super(application);
        repository = new rnrRepository(application);
        mAllInjuries = repository.getAllInjuries();
        mAllProperties = repository.getAllProperties();
        mAllSituations = repository.getAllSituations();
    }

    public LiveData<List<Injury>> getAllInjuries() { return mAllInjuries; }

    public LiveData<List<Property>> getAllProperties() { return mAllProperties; }

    public LiveData<List<Situation>> getAllSituations() { return mAllSituations; }

    public void insertInjury(Injury p_injury) { repository.insertInjury(p_injury); }

    public void insertProperty(Property p_property) { repository.insertProperty(p_property); }

    public void insertSituation(Situation p_situation) { repository.insertSituation(p_situation); }
}

