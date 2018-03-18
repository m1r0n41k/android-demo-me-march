package com.drondon.androiddebugme.detail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by andriimiroshnychenko on 3/18/18.
 */

public class DummyContent {

    private static List<SugarLevel> levels = Collections.emptyList();
    private static Random random = new Random();

    public static List<SugarLevel> getLevels() {
        if (levels.size() == 0) {
            long now = System.currentTimeMillis();
            levels = generateDummyData(100, new Date(now - TimeUnit.DAYS.toMillis(16)), new Date(now));
        }
        return levels;
    }

    private static List<SugarLevel> generateDummyData(int count, Date startData, Date endData) {
        long startTime = startData.getTime();
        long days = TimeUnit.MILLISECONDS.toDays(endData.getTime() - startTime);
        int countPerDay = (int) (count / days);
        long timeBetweenPoint = TimeUnit.HOURS.toMillis(16) / countPerDay;
        long oneDayInMilliseconds = TimeUnit.DAYS.toMillis(1);
        List<SugarLevel> levels = new ArrayList<>();
        for (long day = 0; day < days; day++) {
            for (int i = 0; i < countPerDay; i++) {
                float value = random.nextFloat() * 7.2f;
                levels.add(new SugarLevel(new Date(startTime + day * oneDayInMilliseconds + timeBetweenPoint + i), value));
            }
        }
        return levels;
    }

}
