package com.example.miruka.starbuzz;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkActivity extends Activity {
public static final String EXTRA_DRINKID="drinkId";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        //Get Drink from intent
        int drinkId=(Integer)getIntent().getExtras().get(EXTRA_DRINKID);
        Drink drink=Drink.drinks[drinkId];//Use the drinkid to get details of the drink the user chooses

        //Populate the drink name
        TextView name=(TextView)findViewById(R.id.name);
        name.setText(drink.getDescription());

        //Populate the drink Description
        TextView description=(TextView)findViewById(R.id.description);
        name.setText(drink.getDescription());

        //Populate the drink image
        ImageView photo=(ImageView)findViewById(R.id.photo);
        photo.setImageResource(drink.getImageResourceId());
        photo.setContentDescription(drink.getName());
    }
}
