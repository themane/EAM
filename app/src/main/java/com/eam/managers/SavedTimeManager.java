package com.eam.managers;

import android.util.Log;

import com.eam.exceptions.InvalidTimeInstanceException;
import com.eam.model.TimeInstance;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by degupta on 9/10/2015.
 */
public class SavedTimeManager {
    private static final String TAG = "SavedTimeManager";
    private static SavedTimeManager instance;

    private List<TimeInstance> timeInstances;
    private ExecutorService service;

    private SavedTimeManager() {
        timeInstances = new ArrayList<>();
        service = Executors.newSingleThreadExecutor();

        initialize();
    }

    private void initialize() {
        File file = new File(context.getFilesDir(), filename);
    }

    public static SavedTimeManager getInstance() {
        if (instance == null) {
            instance = new SavedTimeManager();
        }
        return instance;
    }

    public TimeInstance addTime(int hour, int minute) {
        try {
            TimeInstance timeInstance = new TimeInstance(hour, minute);
            timeInstances.add(timeInstance);
            commit();
            return timeInstance;

        } catch (InvalidTimeInstanceException e) {
            Log.i(TAG, "Trying to add invalid time: " + e.getMessage());
        }
        return null;
    }

    private void commit() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };

        service.submit(runnable);
    }

    public void removeTime(TimeInstance timeInstance) {
        timeInstances.remove(timeInstance);
    }
}
