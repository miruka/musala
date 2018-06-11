package com.example.miruka.beeradviser;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.List;//we are using this extra class so we need to import it

public class FindBeerActivity extends Activity {
TextView brands;
Spinner color_of_beer;
String beerType;
private BeerExpert expert =new BeerExpert(); //add an instance of a class(BeerExpert) as a private variable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);
    }
    public void onClickFindBeer(View view)
    {
        brands=(TextView)findViewById(R.id.brands);
        color_of_beer=(Spinner)findViewById(R.id.color_of_beer);
        beerType=String.valueOf(color_of_beer.getSelectedItem());


       List<String> brandList=expert.getBrands(beerType);//we use BeerExpert to Get List of Brands
       StringBuilder brandsFormatted =new StringBuilder();// Build a string using the values in the list

       for (String brand:brandList)
       {
           brandsFormatted.append(brand).append('\n'); //Display each brand on a new line
       }
       //Display the Beers
        brands.setText(brandsFormatted);//Displays the results in a text View
    }
}
