package com.hybrid_games.tsunami;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Diego on 12/06/2016.
 */



public class Choix  extends Activity {

    private View training;
    private ArrayList<String> joueurs = new ArrayList<String>();
    private Mode mode;

    App app = new App();

    GameMode goTraining;
    GameMode goTsunami;
    GameMode goHot;
    GameMode goVersus;
    GameMode goBlind;
    GameMode goCustom;

    RelativeLayout layout = null;
    LinearLayout layoutGame = null;

    ViewGroup.LayoutParams rel_btn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        joueurs = (ArrayList<String>) getIntent().getSerializableExtra("joueurs");

        layout = (RelativeLayout) RelativeLayout.inflate(this, R.layout.choix_jeux, null);
        layoutGame = (LinearLayout) layout.findViewById(R.id.layoutGame);

        //Typeface font = Typeface.createFromAsset(getAssets(), "fonts/DrippyWatercolor.ttf");
        Typeface fonttitle = Typeface.createFromAsset(App.context().getAssets(), "fonts/The Light Brigade.otf");

        TextView tv = (TextView) layout.findViewById(R.id.textView4);
                tv.setTypeface(fonttitle);


        setContentView(layout);



        goTraining = new GameMode(App.context(), "Entrainement", "Ce mode de jeu est un mode pour débuter les soirée, pas besoin de réfléchir il va juste falloir boire.");
        goTsunami = new GameMode(App.context(), "Tsunami", "Tsunami est le mode classique, il va falloit parier et pointer ! Qui sera au coeur de l'action ?");
        goHot = new GameMode(App.context(), "Hot", "C'est le mode de jeu coquin, parfait pour une fin de soirée ! Oserez vous faire ce qu'on vous propose ?");
        goVersus = new GameMode(App.context(), "Versus", "Défiez vous en équipe !");
        goBlind = new GameMode(App.context(), "Blind Test", "Coming soon !");
        goCustom = new GameMode(App.context(), "Personnalise", "Coming soon !");


        layoutGame.addView(goTraining);
        layoutGame.addView(goTsunami);
        layoutGame.addView(goHot);
        layoutGame.addView(goVersus);
        layoutGame.addView(goBlind);
        layoutGame.addView(goCustom);


        goTraining.setBackgroundColor(getResources().getColor(R.color.mime));
        goTsunami.setBackgroundColor(getResources().getColor(R.color.tsunami));
        goHot.setBackgroundColor(getResources().getColor(R.color.hot));
        goVersus.setBackgroundColor(getResources().getColor(R.color.notAvailable));
        goBlind.setBackgroundColor(getResources().getColor(R.color.notAvailable));
        goCustom.setBackgroundColor(getResources().getColor(R.color.notAvailable));

        goTsunami.setWidth();
        goTraining.setWidth();
        goHot.setWidth();
        goVersus.setWidth();
        goBlind.setWidth();
        goCustom.setWidth();

        goTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondeActivite = new Intent(Choix.this, NewGame.class);
                secondeActivite.putExtra("joueurs", joueurs);
                secondeActivite.putExtra("mode", 1);
                startActivity(secondeActivite);
            }
        });

        goTsunami.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondeActivite = new Intent(Choix.this, NewGame.class);
                secondeActivite.putExtra("joueurs", joueurs);

                secondeActivite.putExtra("mode", 2);

                startActivity(secondeActivite);
            }
        });

        goHot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondeActivite = new Intent(Choix.this, NewGame.class);
                secondeActivite.putExtra("joueurs", joueurs);
                secondeActivite.putExtra("mode", 3);

                startActivity(secondeActivite);
            }
        });


    }




}
