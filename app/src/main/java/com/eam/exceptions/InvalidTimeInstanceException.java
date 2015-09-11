package com.eam.exceptions;

import java.io.IOException;

public class InvalidTimeInstanceException extends IOException {
    public static final int HOUR = 0;
    public static final int MINUTE = 1;

    public InvalidTimeInstanceException(String msg) {
        super(msg);
    }
}
