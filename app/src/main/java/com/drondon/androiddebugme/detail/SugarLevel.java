package com.drondon.androiddebugme.detail;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Date;

/**
 * Created by andriimiroshnychenko on 3/18/18.
 */

public class SugarLevel {

    private final static int UNKNOWN = -1;
    public final static int LOW = 100;
    public final static int NORMAL = 101;
    public final static int HIGH = 102;

    private Date date;
    private float level;

    @Status
    private int status = UNKNOWN;

    @Retention(RetentionPolicy.SOURCE)
    @IntDef(value = {UNKNOWN, LOW, NORMAL, HIGH})
    public @interface Status {
    }

    public SugarLevel(Date date, float level) {
        this.date = date;
        this.level = level;
    }

    public Date getDate() {
        return date;
    }

    public float getLevel() {
        return level;
    }

    @Status
    public int getStatus() {
        if (status == UNKNOWN) {
            status = calculateStatusByLevel();
        }
        return status;
    }

    @Status
    private int calculateStatusByLevel() {
        if (level >= 0 && level < 3.9f) {
            return LOW;
        } else if (level >= 3.9f && level <= 5.0f) {
            return NORMAL;
        } else if (level > 5.0f && level <= 7.2f) {
            return HIGH;
        }
        return UNKNOWN;
    }
}
