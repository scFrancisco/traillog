package com.francisco.traillog.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkoutTest {
    @Test
    void should_createWorkout_when_workoutArgIsValid(){
        Workout workout = new Workout("test1",1,2);
        assertEquals("test1",workout.getWorkoutName());
        assertEquals(1,workout.getDistanceInKm());
        assertEquals(2,workout.getTimeInSeconds());
    }

    @Test
    void should_throwException_when_createWorkoutWithNameNull(){
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new Workout(null,1,2));
        assertEquals("workoutName cannot be null.", ex.getMessage());
    }
    @Test
    void should_throwException_when_createWorkoutWithNameEmpty(){
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->new Workout("",2,3));
        assertEquals("workoutName cannot be empty.",ex.getMessage());
    }

    @Test
    void should_throwException_when_createWorkoutWithDistanceNegative(){
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->new Workout("test1",-1,2));
        assertEquals("distanceInKm cannot be negative during construction: -1.0",ex.getMessage());
    }
    @Test
    void should_createWorkout_when_createWorkoutWithDistanceZero(){
        Workout workout = new Workout("test1",0,1);
        assertEquals("test1",workout.getWorkoutName());
        assertEquals(0,workout.getDistanceInKm());
        assertEquals(1,workout.getTimeInSeconds());
    }
    @Test
    void should_throwException_when_createWorkoutWithTimeZero(){
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->new Workout("test1",0,0));
        assertEquals("timeInSeconds cannot be negative during construction: 0",ex.getMessage());
    }
    @Test
    void should_throwException_when_createWorkoutWithTimeNegative(){
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->new Workout("test1",0,-1));
        assertEquals("timeInSeconds cannot be negative during construction: -1",ex.getMessage());
    }
    @Test
    void should_calculateAVGSpeed_when_createWorkoutWithArgsValid(){
        Workout workout = new Workout("test1",40,3600);
        assertEquals(40,workout.calculateAVGSpeed());
    }
}