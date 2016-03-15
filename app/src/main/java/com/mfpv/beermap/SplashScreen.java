package com.mfpv.beermap;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;
import com.google.gson.Gson;

public class SplashScreen extends Activity {

    SQLiteDatabase sqLite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        //This sets custom font the text view
        TextView tv = (TextView) findViewById(R.id.logo_title);
        Typeface face = Typeface.createFromAsset(getAssets(),
                "assets/fonts/kingthings_hand.ttf");
        tv.setTypeface(face);

        android.app.ActionBar actionBar = getActionBar();
        actionBar.hide();
    }
}
