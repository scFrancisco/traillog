package com.francisco.traillog.exception;

import com.francisco.traillog.model.Workout;

public class DuplicateWorkoutException extends TrailLogException{
    public DuplicateWorkoutException(String message){
        super(message);
    }

    public static DuplicateWorkoutException forWorkout(Workout workout){
        return new DuplicateWorkoutException("workout already exists " +  workout);
    }

}
