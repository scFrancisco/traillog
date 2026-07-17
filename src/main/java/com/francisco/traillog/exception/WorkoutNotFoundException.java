package com.francisco.traillog.exception;

public class WorkoutNotFoundException extends TrailLogException {
    public WorkoutNotFoundException(String message) {
        super(message);
    }

    public static WorkoutNotFoundException forName(String name) {
        return new WorkoutNotFoundException("Workout not found " +  name);
    }
}
