package com.example.miruka.starbuzz;

public class Drink {
    private  String name;
    private String description;
    private int imageResourceId;

    //drinks is an array of three drinks
    public static final Drink[] drinks = {
            new Drink("Latte","A couple of Espresso shots with steamed milk", R.drawable.latte),
            new Drink("Cappuccino","Espresso,hot milk,and steamed milk foam",R.drawable.cappuccino),
            new Drink("Filter","Highest quality beans roasted and brewed fresh",R.drawable.filter)
    };

    //Each drink has a name,description and an image resource
    private Drink(String name,String description,int imageResourceId){
        this.name=name;
        this.description=description;
        this.imageResourceId=imageResourceId;

    }
//Getters for the private variables
    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String toString() {
        return this.name;
    }
}
