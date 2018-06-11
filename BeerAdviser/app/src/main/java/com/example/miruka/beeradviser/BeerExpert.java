package com.example.miruka.beeradviser;

import java.util.ArrayList;
import java.util.List;

public class BeerExpert
{
    List<String> getBrands(String color_of_beer)
    {
        List<String> brands= new ArrayList<>();
        if (color_of_beer.equals("amber"))
        {
            brands.add("Jack Amber");
            brands.add("Red Moose");
        }
        else
            {
                brands.add("Jail Pale Ale");
                brands.add("Gout Stout");
            }
        return brands;
    }
}
