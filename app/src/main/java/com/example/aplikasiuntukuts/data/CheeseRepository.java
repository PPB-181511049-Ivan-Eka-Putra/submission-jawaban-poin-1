package com.example.aplikasiuntukuts.data;

import android.app.Application;
import android.database.Cursor;

import androidx.lifecycle.LiveData;

public class CheeseRepository {

    private CheeseDao mCheeseDao;
    private LiveData<Cursor> mAllCheeses;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    CheeseRepository(Application application) {
        SampleDatabase db = SampleDatabase.getInstance(application);
        mCheeseDao = db.cheese();
        mAllCheeses = mCheeseDao.selectAll();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<Cursor> getAllCheeses() {
        return mAllCheeses;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(Cheese cheese) {
        SampleDatabase.databaseWriteExecutor.execute(() -> {
            mCheeseDao.insert(cheese);
        });
    }
}
