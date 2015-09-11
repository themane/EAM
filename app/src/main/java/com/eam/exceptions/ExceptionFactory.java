package com.eam.exceptions;

/**
 * Created by degupta on 9/11/2015.
 */
public class ExceptionFactory {

    public static InvalidTimeInstanceException getInvalidTimeInstanceException(int type, int value) {
        switch (type) {
            case InvalidTimeInstanceException.HOUR:
                return new InvalidTimeInstanceException("Invalid hour value: " + value);
            case InvalidTimeInstanceException.MINUTE:
                return new InvalidTimeInstanceException("Invalid minute value: " + value);
            default:
                return null;
        }

    }
}
