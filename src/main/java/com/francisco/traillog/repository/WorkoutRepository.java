package com.francisco.traillog.repository;

import com.francisco.traillog.exception.DuplicateWorkoutException;
import com.francisco.traillog.exception.WorkoutNotFoundException;
import com.francisco.traillog.model.Workout;

import java.util.*;
import java.util.stream.Collectors;

public class WorkoutRepository {
    private Set<Workout> workouts = new LinkedHashSet<>();


    public void  addWorkout(Workout workout){
        if(workout == null)
            throw new IllegalArgumentException("workout cannot be null");
        boolean result= workouts.add(workout);
        if(!result)
            throw new DuplicateWorkoutException("workout already exists " +  workout);
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
        throw WorkoutNotFoundException.forName(name);
    }
    public List<Workout> filterByMinDistance(double minKm) {
        return workouts.stream().filter(w -> w.getDistanceInKm()>=minKm).collect(Collectors.toList());
    }

    public double getTotalDistance() {
        return workouts.stream().mapToDouble(Workout::getDistanceInKm).sum();
    }

    public List<String> getAllWorkoutNames(){
        return workouts.stream().map(Workout::getWorkoutName).collect(Collectors.toList());
    }

    public List<Workout> getWorkoutsSortedByDistance(){
        return workouts.stream().sorted(Comparator.comparingDouble(Workout::getDistanceInKm)).collect(Collectors.toList());
    }
    public Map<String, List<Workout>> getWorkoutsGroupedByName(){
        return workouts.stream().collect(Collectors.groupingBy(Workout::getWorkoutName));
    }

    public Map<String, Long> getWorkoutsCountByName(){
        return workouts.stream().collect(Collectors.groupingBy(Workout::getWorkoutName,Collectors.counting()));
    }

    public Optional<Workout> findByNameOptional(String name){
        return workouts.stream().filter(w -> w.getWorkoutName().equals(name)).findFirst();
    }
}
