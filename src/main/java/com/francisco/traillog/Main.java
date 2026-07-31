package com.francisco.traillog;



import com.francisco.traillog.model.Workout;
import com.francisco.traillog.repository.memory.InMemoryWorkoutRepository;

import java.time.LocalDateTime;


public class Main {
    public static void main(String[] args)
        {
            Workout treino1;
            Workout treino2;
            InMemoryWorkoutRepository inMemoryWorkoutRepository = new InMemoryWorkoutRepository();

            treino1 = new Workout("Zona 2",63.2,8000, LocalDateTime.now());
            treino2 = new Workout("Zona 1",23.2,7000, LocalDateTime.now());

            inMemoryWorkoutRepository.addWorkout(treino1);
            inMemoryWorkoutRepository.addWorkout(treino2);

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

            inMemoryWorkoutRepository.findByNameOptional("Treino").ifPresent(w-> System.out.println("Treino: " + w.getWorkoutName()));
            inMemoryWorkoutRepository.findByNameOptional("Zona 1").ifPresent(w-> System.out.println("Treino: " + w.getWorkoutName()));
            System.out.println(1.0 == -1.0);
            System.out.println(Double.compare(1.0, -1.0));
        }
}
