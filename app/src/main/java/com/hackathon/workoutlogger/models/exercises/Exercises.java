package com.hackathon.workoutlogger.models.exercises;

/**
 * Created by AAR on 11/1/14.
 */
public class Exercises {
    public final static String BASE_TYPE = "base";
    public final static String ONLY_TIME_TYPE = "only_time";
    public final static String TIME_AND_WEIGHT_TYPE = "time_and_weight";

    private String name;

    protected String type;

//    protected Exercises(){
//    }

    public Exercises(String name){
        this.name = name;
        type = BASE_TYPE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }
}
