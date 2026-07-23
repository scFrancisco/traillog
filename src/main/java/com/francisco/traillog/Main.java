package com.francisco.traillog;


import com.francisco.traillog.model.Workout;
import com.francisco.traillog.repository.WorkoutRepository;

import java.util.List;

public class Main {
    public static void main(String[] args)
        {
            Workout treino1;
            Workout treino2;
            WorkoutRepository workoutRepository = new WorkoutRepository();

            treino1 = new Workout("Zona 2",63.2,8000);
            treino2 = new Workout("Zona 1",23.2,7000);

            workoutRepository.addWorkout(treino1);
            workoutRepository.addWorkout(treino2);

            System.out.println("Treino : \n" + treino1.getWorkoutName() +
                    "\nDistancia: \n" + treino1.getDistanceInKm() +
                    "\nTempo: \n" +treino1.getTimeInSeconds() +
                    "\nVelocidade Média: \n" +treino1.calculateAVGSpeed());
            System.out.println("Treino : \n" + treino2.getWorkoutName() +
                    "\nDistancia: \n" + treino2.getDistanceInKm() +
                    "\nTempo: \n" +treino2.getTimeInSeconds() +
                    "\nVelocidade Média: \n" +treino2.calculateAVGSpeed());
            treino1.setPowerAVG(251);
            treino1.setPowerMAX(424);

            //System.out.println(workoutRepository.findByName("Zona 4"));
            //System.out.println(treino1);
            System.out.println(Double.NaN == Double.NaN);
            System.out.println(0.0 == -0.0);
            System.out.println(Double.compare(Double.NaN, Double.NaN));
            System.out.println(Double.compare(0.0, -0.0));
            List<String> nomes = List.of("a", "b", "c");
            nomes.stream().filter(s -> s.equals("a"));
        }
}
