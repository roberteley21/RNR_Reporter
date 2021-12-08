package com.example.rnr_reporter;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.rnr_reporter.DataBase.Entities.Injury;
import com.example.rnr_reporter.DataBase.rnrRepository;

import java.util.List;

public class rnrViewModel extends AndroidViewModel {
    private rnrRepository mRepository;

  //  private final LiveData<List<Injury>> mAllInjuries;

    public rnrViewModel (Application application) {
        super(application);
        mRepository = new rnrRepository(application);
      //  mAllInjuries = mRepository.getAllInjuries();
    }

 //   LiveData<List<Injury>> getAllWords() { return mAllInjuries; }

    public void insert(Injury p_injury) { mRepository.insert(p_injury); }
}
