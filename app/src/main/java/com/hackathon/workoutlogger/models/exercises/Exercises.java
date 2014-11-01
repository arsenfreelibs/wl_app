package com.hackathon.workoutlogger.models.exercises;

/**
 * Created by AAR on 11/1/14.
 */
public class Exercises {
    private String name;

    public Exercises(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
