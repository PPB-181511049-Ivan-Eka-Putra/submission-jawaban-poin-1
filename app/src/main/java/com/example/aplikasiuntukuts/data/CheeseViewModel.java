package com.example.aplikasiuntukuts.data;

import android.app.Application;
import android.database.Cursor;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class CheeseViewModel extends AndroidViewModel {

    private CheeseRepository mRepository;

    private LiveData<Cursor> mAllCheeses;

    public CheeseViewModel(@NonNull Application application) {
        super(application);
        mRepository = new CheeseRepository(application);
        mAllCheeses = mRepository.getAllCheeses();
    }
}
