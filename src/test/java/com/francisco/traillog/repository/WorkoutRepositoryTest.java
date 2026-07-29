package com.francisco.traillog.repository;

import com.francisco.traillog.exception.DuplicateWorkoutException;
import com.francisco.traillog.exception.WorkoutNotFoundException;
import com.francisco.traillog.model.Workout;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class WorkoutRepositoryTest {
    WorkoutRepository workoutRepository;
    LocalDateTime dateTime;

    @BeforeEach
    void setUp() {
        workoutRepository = new WorkoutRepository();
        dateTime = LocalDateTime.now();
    }
    @Test
    void should_addWorkout_when_workoutArgIsValid() {
        workoutRepository.addWorkout(new Workout("test1",1,1,dateTime));
        workoutRepository.addWorkout(new Workout("test2",2,2,dateTime));

        assertEquals(2, workoutRepository.getAllWorkouts().size());
    }
    @Test
    void should_throwException_when_addWorkoutArgIsNull() {
        
        assertThrows(IllegalArgumentException.class, () -> workoutRepository.addWorkout(null));
    }
    @Test
    void should_throwException_when_addWorkoutIsDuplicate() {
        
        workoutRepository.addWorkout(new Workout("test1",1,1,dateTime));
        workoutRepository.addWorkout(new Workout("test2",2,2,dateTime));
        assertThrows(DuplicateWorkoutException.class, () -> workoutRepository.addWorkout(new Workout("test1",1,1,dateTime)));
    }

    @Test
    void should_getAllWorkouts_when_workoutExists() {
        workoutRepository.addWorkout(new Workout("test1",1,1,dateTime));
        workoutRepository.addWorkout(new Workout("test2",2,2,dateTime));
        assertEquals(2, workoutRepository.getAllWorkouts().size());
    }
    @Test
    void should_getNoWorkouts_when_workoutsDoNotExist() {
        
        assertEquals(0, workoutRepository.getAllWorkouts().size());
    }

    @Test
    void should_getWorkout_when_findByNameArgIsValid() {
        
        Workout workout = new Workout("test1",1,1,dateTime);
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
    @Test
    void shoul_returnAllWorkout_Above_MinDistance_when_workoutsExist(){
        workoutRepository.addWorkout(new Workout("test1",1,1,dateTime));
        workoutRepository.addWorkout(new Workout("test1",2,1,dateTime));
        workoutRepository.addWorkout(new Workout("test1",3,1,dateTime));
        workoutRepository.addWorkout(new Workout("test1",4,1,dateTime));

        List<Workout> workouts = workoutRepository.filterByMinDistance(2.0);
        List<Workout> workoutsExpected = List.of(new Workout("test1",2,1,dateTime)
        , new Workout("test1",3,1,dateTime)
        , new Workout("test1",4,1,dateTime)
        );
        assertEquals(workoutsExpected,workouts);
    }
    @Test
    void shoul_returnAllWorkoutDistance_when_workoutsExist(){
        workoutRepository.addWorkout(new Workout("test1",1,1,dateTime));
        workoutRepository.addWorkout(new Workout("test2",2,2,dateTime));

        assertEquals(3, workoutRepository.getTotalDistance());
    }
    @Test
    void should_returnAllWorkoutsName_when_workoutExists() {
        workoutRepository.addWorkout(new Workout("test1",1,1,dateTime));
        workoutRepository.addWorkout(new Workout("test2",2,2,dateTime));
        workoutRepository.addWorkout(new Workout("test3",3,3,dateTime));
        List<String> workouts = workoutRepository.getAllWorkoutNames();
        List<String> workoutsExpected = List.of("test1", "test2", "test3");

        assertEquals( workoutsExpected, workouts);
    }
    @Test
    void should_returnAllWorkouts_sortedByDistance_when_workoutExists() {
        workoutRepository.addWorkout(new Workout("test1",1,1,dateTime));
        workoutRepository.addWorkout(new Workout("test1",3,1,dateTime));
        workoutRepository.addWorkout(new Workout("test1",2,1,dateTime));


        List<Workout> workouts = workoutRepository.getWorkoutsSortedByDistance();
        List<Workout> workoutsExpected = List.of(new Workout("test1",1,1,dateTime),
                new Workout("test1",2,1,dateTime    ),
                new Workout("test1",3,1,dateTime));
        assertEquals(workoutsExpected, workouts);
    }
    @Test
    void should_returnAllWorkouts_groupByName_when_workoutsExist() {
        workoutRepository.addWorkout(new Workout("test1",1,1,dateTime));
        workoutRepository.addWorkout(new Workout("test2",2,2,dateTime));
        workoutRepository.addWorkout(new Workout("test2",3,3,dateTime));
        workoutRepository.addWorkout(new Workout("test3",4,4,dateTime));

        Map<String, List<Workout>> workouts = workoutRepository.getWorkoutsGroupedByName();
        Map<String, List<Workout>> workoutsExpected = Map.of(
                "test1", List.of(new Workout("test1",1,1,dateTime)),
                "test2", List.of(new Workout("test2",2,2,dateTime),new Workout("test2",3,3,dateTime)),
                "test3", List.of(new Workout("test3",4,4,dateTime))
        );
        assertEquals(workoutsExpected, workouts);

    }

    @Test
    void should_returnCounterOfAllWorkouts_groupByName_when_workoutsExist() {
        workoutRepository.addWorkout(new Workout("test1",1,1,dateTime));
        workoutRepository.addWorkout(new Workout("test2",2,2,dateTime));
        workoutRepository.addWorkout(new Workout("test3",3,3,dateTime));
        workoutRepository.addWorkout(new Workout("test3",4,4,dateTime));

        Map<String, Long> workouts = workoutRepository.getWorkoutsCountByName();
        Map<String, Long> workoutsExpected = Map.of(
                "test1",1L,
                "test2",1L,
                "test3",2L
        );

        assertEquals(workoutsExpected, workouts);
    }

    @Test
    void should_returnWorkout_when_nameExists(){
        Workout workout = new Workout("test1",1,1,dateTime);
        workoutRepository.addWorkout(workout);
        assertEquals(Optional.of(workout),workoutRepository.findByNameOptional("test1"));
    }

    @Test
    void should_returnEmptyOptional_when_nameNotFound(){
        Workout workout = new Workout("test1",1,1,dateTime);
        workoutRepository.addWorkout(workout);
        assertEquals(Optional.empty(),workoutRepository.findByNameOptional("test2"));
    }

    @Test
    void should_returnEmptyOptional_when_nameArgIsNull(){
        workoutRepository.addWorkout(new Workout("test1",1,1,dateTime));
        assertEquals(Optional.empty(),workoutRepository.findByNameOptional(null));
    }
    @Test
    void should_addWorkout_when_sameNameDistanceTime_butDifferentDateTime(){
        workoutRepository.addWorkout(new Workout("test1",1,1,dateTime));
        workoutRepository.addWorkout(new Workout("test1",1,1,dateTime.plusDays(7)));

        assertEquals(2,workoutRepository.getAllWorkouts().size());
    }

    @Test
    void should_returnAllWorkouts_sortedByDateTime_when_workoutsExist(){
        workoutRepository.addWorkout(new Workout("test1",1,1,dateTime));
        workoutRepository.addWorkout(new Workout("test2",2,2,dateTime.plusDays(7)));
        workoutRepository.addWorkout(new Workout("test3",3,3,dateTime.plusMinutes(30)));

        List<Workout> workouts = List.of(
                new Workout("test1",1,1,dateTime),
                new Workout("test3",3,3,dateTime.plusMinutes(30)),
                new Workout("test2",2,2,dateTime.plusDays(7))
        );

        assertEquals(workouts,workoutRepository.getWorkoutsSortedByDateTime());
    }
}