package com.example.miruka.workout;

public class Workout {
    private  String name,description;

    public static final Workout[] workouts={
            new Workout("The Limb Loosener","5 Handstand push-ups\n10 1- legged squats\n15 Pull-Ups"),
            new Workout("Core Agony","100 Pull-Ups\n100 Sit-Ups\n100 Squats"),
            new Workout("The Wimp Special","5 Pull-Ups\n10 Push-Ups\n15 Squats"),
            new Workout("Strength and Length","500 meter run\n21 x 1.5 pood kettle ball swing\n21 x Pull-Ups")
    };

   private     Workout(String name,String description){
       this.name=name;
       this.description=description;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return this.name;
    }
}
