package com.hybrid_games.tsunami;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    ArrayList<EditText> nameJoueur = new ArrayList<EditText>();
    ArrayList<String> joueurs = new ArrayList<String>();
    ListView listJoueur;
    private Button gameChoix;
    RelativeLayout layout = null;
    RelativeLayout.LayoutParams layoutparams = null;
    RelativeLayout buttonLayout;
    Button plus;

    static final int START_BUTTONS = 4;
    static final int NB_BUTTONS = 51;
    private int current_display_button = 0;

    private TextView titleGame;
    private TextView descriptionGame;
    private TextView alcoolDangerous;

    private String[] description;

    App app = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        app = new App();


        Typeface fonttitle = Typeface.createFromAsset(App.context().getAssets(), "fonts/The Light Brigade.otf");

        Typeface font = Typeface.createFromAsset(App.context().getAssets(), "fonts/Beautiful Heartbeat.otf");
        Timer timer = new Timer();
        MyTimer mt = new MyTimer();
        timer.schedule(mt, 1000, 1000);

        description = app.context().getResources().getStringArray(R.array.description);


        layout = (RelativeLayout) RelativeLayout.inflate(this, R.layout.activity_main, null);

        titleGame = (TextView) layout.findViewById(R.id.textView);
        descriptionGame = (TextView) layout.findViewById(R.id.textView2);
        alcoolDangerous = (TextView) layout.findViewById(R.id.textView3);
        titleGame.setTypeface(fonttitle);
        descriptionGame.setTypeface(font);
        alcoolDangerous.setTypeface(font);
        buttonLayout = (RelativeLayout) layout.findViewById(R.id.zoneButton);


        for (int i = 0; i < NB_BUTTONS + 1; ++i) {

            nameJoueur.add(new EditText(this));
            nameJoueur.get(i).setHint("Joueur " + (i + 1));
            nameJoueur.get(i).setId((i));
            nameJoueur.get(i).setWidth(300);

        }
        plus = (Button) layout.findViewById(R.id.plus);
        plus.setTypeface(font);

        plus.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                if (current_display_button == 0) {

                    addButton();
                    nameJoueur.get(0).setVisibility(View.INVISIBLE);
                }
                if (current_display_button < NB_BUTTONS)
                    addButton();
            }
        });


        setContentView(layout);


        gameChoix = (Button) findViewById(R.id.choix);
        gameChoix.setTypeface(font);

        gameChoix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondeActivite = new Intent(MainActivity.this, Choix.class);
                createJoueur();
                if (joueurs.size() >= 2) {
                    secondeActivite.putExtra("joueurs", joueurs);
                    startActivity(secondeActivite);
                }
                else
                    Toast.makeText(getApplicationContext(), "Il faut au moins 2 joueurs !", Toast.LENGTH_LONG).show();

            }

        });

        plus.performClick();

        GradientDrawable gd = new GradientDrawable();
        gd.setColor(App.context().getResources().getColor(R.color.tsunami));
        gd.setCornerRadii(new float[]{50,50,50,50,10,0,0,10});
        gd.setStroke(1, 0xFF000000);

        GradientDrawable gd_t = new GradientDrawable();
        gd_t.setColor(App.context().getResources().getColor(R.color.tsunami));
        gd_t.setCornerRadii(new float[]{0,0,0,0,50,50,50,50});
        gd_t.setStroke(1, 0xFF000000);

        plus.setBackgroundDrawable(gd);
        gameChoix.setBackgroundDrawable(gd_t);
    }


    private void addButton() {

        buttonLayout.addView(nameJoueur.get(current_display_button));

        if (current_display_button > 7)
            nameJoueur.get(current_display_button).requestFocus();

        nameJoueur.get(current_display_button).setHint("Joueur " + (current_display_button));
        nameJoueur.get(current_display_button).setId(current_display_button);

        layoutparams = (RelativeLayout.LayoutParams) nameJoueur.get(current_display_button).getLayoutParams();
        if (current_display_button != 0)
            layoutparams.addRule(RelativeLayout.BELOW, nameJoueur.get(current_display_button - 1).getId());
        else
            layoutparams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        layoutparams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        layoutparams.setMargins(10, 10, 10, 10);
        nameJoueur.get(current_display_button).setLayoutParams(layoutparams);
        ++current_display_button;

    }

    private void createJoueur() {

        for (int i = 0; i < NB_BUTTONS; ++i) {

            if (nameJoueur.get(i).getText().length() > 0) {

                joueurs.add(nameJoueur.get(i).getText().toString());

            }

        }
    }

    protected void onResume() {

        for (int i = 0; i < 6; ++i)
            plus.performClick();


        super.onResume();
    }

    class MyTimer extends TimerTask {

        public void run() {


            runOnUiThread(new Runnable() {

                public void run() {
                    Random rand = new Random();

                    descriptionGame.setText(description[rand.nextInt(description.length)]);
                }
            });
        }

    }
}

