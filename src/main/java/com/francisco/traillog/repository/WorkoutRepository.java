package com.francisco.traillog.repository;

import com.francisco.traillog.model.Workout;

import java.util.ArrayList;
import java.util.List;

public class WorkoutRepository {
    private List<Workout> workouts = new ArrayList<>();

    public void  addWorkout(Workout workout){
        for (Workout w : workouts){
            if( w.getWorkoutName().equals(workout.getWorkoutName()) && w.getTimeInSeconds() == workout.getTimeInSeconds() && w.getDistanceInKm() == workout.getDistanceInKm() ){
                throw new IllegalStateException("Workout already exists");
            }
        }
        workouts.add(workout);
    }

    public List<Workout> getAllWorkouts() {
        return new ArrayList<>(workouts);
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
