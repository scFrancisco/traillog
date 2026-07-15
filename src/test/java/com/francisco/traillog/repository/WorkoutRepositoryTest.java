package com.francisco.traillog.repository;

import com.francisco.traillog.exception.DuplicateWorkoutException;
import com.francisco.traillog.exception.WorkoutNotFoundException;
import com.francisco.traillog.model.Workout;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkoutRepositoryTest {
    WorkoutRepository workoutRepository;

    @BeforeEach
    void setUp() {
        workoutRepository = new WorkoutRepository();
    }
    @Test
    void should_addWorkout_when_workoutArgIsValid() {
        workoutRepository.addWorkout(new Workout("test1",1,1));
        workoutRepository.addWorkout(new Workout("test2",2,2));

        assertEquals(2, workoutRepository.getAllWorkouts().size());
    }
    @Test
    void should_throwException_when_addWorkoutArgIsNull() {
        
        assertThrows(IllegalArgumentException.class, () -> workoutRepository.addWorkout(null));
    }
    @Test
    void should_throwException_when_addWorkoutIsDuplicate() {
        
        workoutRepository.addWorkout(new Workout("test1",1,1));
        workoutRepository.addWorkout(new Workout("test2",2,2));
        assertThrows(DuplicateWorkoutException.class, () -> workoutRepository.addWorkout(new Workout("test1",1,1)));
    }

    @Test
    void should_getAllWorkouts_when_workoutExists() {
        workoutRepository.addWorkout(new Workout("test1",1,1));
        workoutRepository.addWorkout(new Workout("test2",2,2));
        assertEquals(2, workoutRepository.getAllWorkouts().size());
    }
    @Test
    void should_getNoWorkouts_when_workoutsDoNotExist() {
        
        assertEquals(0, workoutRepository.getAllWorkouts().size());
    }

    @Test
    void should_getWorkout_when_findByNameArgIsValid() {
        
        Workout workout = new Workout("test1",1,1);
        workoutRepository.addWorkout(workout);
        assertEquals(workout, workoutRepository.findByName("test1"));
    }
    @Test
    void should_throwException_when_findByNameArgIsNull() {
        
        assertThrows(IllegalArgumentException.class, () -> workoutRepository.findByName(null));
    }
    @Test
    void should_throwException_when_findByNameArgIsEmpty(){
        
        assertThrows(IllegalArgumentException.class, () -> workoutRepository.findByName(""));
    }
    @Test
    void should_throwException_when_findByNameArgIsInvalid() {
        
        assertThrows(WorkoutNotFoundException.class, () -> workoutRepository.findByName("test"));
    }


}