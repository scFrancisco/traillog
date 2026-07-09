package com.francisco.traillog.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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

    @Test
    void should_returnAllStrings_when_createWorkoutWithArgsValid(){
        Workout workout = new Workout("test1",40,3600);
        workout.setPowerAVG(1);
        workout.setHrAVG(2);
        workout.setPowerMAX(3);
        workout.setHrMAX(4);
        workout.setTss(5);
        workout.setSpeedAVG(6.0);
        workout.setSpeedMAX(7.0);
        String expected ="Workout{" +
                "distanceInKm=40.0" +
                ", workoutName='test1'" +
                ", timeInSeconds=3600"+
                ", powerAVG=1" +
                ", hrAVG=2" +
                ", powerMAX=3" +
                ", hrMAX=4" +
                ", tss=5" +
                ", speedAVG=6.0" +
                ", speedMAX=7.0" +
                "}";
        assertEquals(expected, workout.toString());
    }

    @Test
    void should_returnNAStrings_when_optionalFieldsAreNull(){
        Workout workout = new Workout("test1",40,3600);
        String expected ="Workout{" +
                "distanceInKm=40.0" +
                ", workoutName='test1'" +
                ", timeInSeconds=3600"+
                ", powerAVG=N/A" +
                ", hrAVG=N/A" +
                ", powerMAX=N/A" +
                ", hrMAX=N/A" +
                ", tss=N/A" +
                ", speedAVG=N/A" +
                ", speedMAX=N/A" +
                "}";
        assertEquals(expected, workout.toString());

    }

    @Test
    void should_returnTrue_whenWorkoutIsEquals(){
        Workout workout = new Workout("test1",40,3600);
        Workout workout2 = new Workout("test1",40,3600);

        assertEquals(workout,workout2);
        assertEquals(workout2,workout);
    }

    @Test
    void should_returnFalse_whenWorkoutIsNotEqualsName(){
        Workout workout = new Workout("test1",40,3600);
        Workout workout2 = new Workout("test2",40,3600);
        
        assertNotEquals(workout,workout2);
        assertNotEquals(workout2,workout);
    }
    @Test
    void should_returnFalse_whenWorkoutIsNotEqualsDistance(){
        Workout workout = new Workout("test1",40,3600);
        Workout workout2 = new Workout("test1",41,3600);

        assertNotEquals(workout,workout2);
        assertNotEquals(workout2,workout);
    }

    @Test
    void should_returnFalse_whenWorkoutIsNotEqualsTime(){
        Workout workout = new Workout("test1",40,3600);
        Workout workout2 = new Workout("test1",40,3601);

        assertNotEquals(workout,workout2);
        assertNotEquals(workout2,workout);
    }
    @Test
    void should_returnTrue_whenWorkoutIsEqualsHashCode(){
        Workout workout = new Workout("test1",40,3600);
        Workout workout2 = new Workout("test1",40,3600);
        assertEquals(workout.hashCode(),workout2.hashCode());
    }

    @Test
    void should_returnFalse_whenWorkoutIsNull(){
        Workout workout = new Workout("test1",40,3600);
        assertNotEquals(workout,null);
    }

    @Test
    void should_returnTrue_whenAddWorkoutHash(){
        Workout workout = new Workout("test1",40,3600);
        Workout workout2 = new Workout("test1",40,3600);

        HashSet<Workout> workouts = new HashSet<>();
        workouts.add(workout);
        assertEquals(false,workouts.add(workout2));

        assertEquals(1,workouts.size());


    }
}