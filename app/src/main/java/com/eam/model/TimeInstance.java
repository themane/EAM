package com.eam.model;

import com.eam.exceptions.ExceptionFactory;
import com.eam.exceptions.InvalidTimeInstanceException;

/**
 * Created by degupta on 9/10/2015.
 */
public class TimeInstance {
    int hour;
    int minute;

    public TimeInstance(int hour, int minute) throws InvalidTimeInstanceException {
        validate(hour, minute);

        this.hour = hour;
        this.minute = minute;
    }

    private void validate(int hour, int minute) throws InvalidTimeInstanceException {
        if (hour < 0 || hour > 24) {
            throw ExceptionFactory.getInvalidTimeInstanceException(InvalidTimeInstanceException.HOUR, hour);
        }

        if (minute < 0 || minute > 24) {
            throw ExceptionFactory.getInvalidTimeInstanceException(InvalidTimeInstanceException.MINUTE, minute);
        }
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    @Override
    public String toString() {
        return hour + ":" + minute + " hrs";
    }
}
