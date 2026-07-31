package com.francisco.traillog.repository;

import com.francisco.traillog.model.Workout;

import java.util.Optional;
import java.util.Set;

 public interface WorkoutRepository {
     /**
      * @throws IllegalArgumentException if workout is null
      * @throws DuplicateWorkoutException if a workout with the same identity already exists
      */
     void addWorkout(Workout workout);

     /**
      * @throws IllegalArgumentException if name is null
      * @throws WorkoutNotFoundException if a workout not found for that name
      */
     Workout findByName(String name);
     Optional<Workout> findByNameOptional(String name);
     Set<Workout> getAllWorkouts();

}
