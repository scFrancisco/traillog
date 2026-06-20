package com.francisco.traillog;


import com.francisco.traillog.model.Workout;

public class Main {
    public static void main(String[] args)
        {
            Workout treino1;
            Workout treino2;
            treino1 = new Workout("Zona 2",63.2,8000);
            treino2 = new Workout("Zona 1",23.2,7000);


            System.out.println("Treino : \n" + treino1.getWorkoutName() +
                    "\nDistancia: \n" + treino1.getDistanceInKm() +
                    "\nTempo: \n" +treino1.getTimeInSeconds() +
                    "\nVelocidade Média: \n" +treino1.calculateAVGSpeed());
            System.out.println("Treino : \n" + treino2.getWorkoutName() +
                    "\nDistancia: \n" + treino2.getDistanceInKm() +
                    "\nTempo: \n" +treino2.getTimeInSeconds() +
                    "\nVelocidade Média: \n" +treino2.calculateAVGSpeed());


        }
}
