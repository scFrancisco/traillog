package com.francisco.traillog.repository;

import com.francisco.traillog.model.Workout;

import java.util.LinkedHashSet;
import java.util.Set;

public class WorkoutRepository {
    private Set<Workout> workouts = new LinkedHashSet<>();


    public void  addWorkout(Workout workout){
        if(workout == null)
            throw new IllegalArgumentException("workout cannot be null");
        boolean result= workouts.add(workout);
        if(!result)
            throw new IllegalStateException("workout already exists");
    }

    public Set<Workout> getAllWorkouts() {
        return new LinkedHashSet<>(workouts);
    }
    public Workout findByName(String name) {
        if (name==null || name.isEmpty())
            throw new IllegalArgumentException("Workout name cannot be null or empty");
        for (Workout w : workouts){
            if(w.getWorkoutName().equals(name)){
                return w;
            }
        }
        throw new IllegalStateException("Workout not found");
    }

}
