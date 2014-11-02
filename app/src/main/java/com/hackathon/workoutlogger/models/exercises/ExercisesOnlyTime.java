package com.hackathon.workoutlogger.models.exercises;

/**
 * Created by AAR on 11/2/14.
 */
public class ExercisesOnlyTime extends Exercises {

    private String repeatsCount;
    private String time;

    public ExercisesOnlyTime(String name, String repeatsCount, String time){
        super(name);
        this.setRepeatsCount(repeatsCount);
        this.setTime(time);
        type = ONLY_TIME_TYPE;
    }

    public String getRepeatsCount() {
        return repeatsCount;
    }

    public void setRepeatsCount(String repeatsCount) {
        this.repeatsCount = repeatsCount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
