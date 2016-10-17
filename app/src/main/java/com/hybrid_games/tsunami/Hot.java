package com.hybrid_games.tsunami;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Diego on 13/06/2016.
 */
public class Hot extends Mode {

    private App app = new App();

    Hot() {}


    void initialisationStrings() {

        setMode(HOT);
        setModePart(HOT_PART);


        /*add(0,30,0,app.context().getResources().getStringArray(R.array.title_si));
        add(1,40,1,app.context().getResources().getStringArray(R.array.title_defi));
        add(2,50,2,app.context().getResources().getStringArray(R.array.title_mime));
        add(3,50,3,app.context().getResources().getStringArray(R.array.title_lemeilleur));
        add(4,50,4,app.context().getResources().getStringArray(R.array.title_dure_debut));
        add(9,60,9,app.context().getResources().getStringArray(R.array.title_normal));
        add(6,20,6,app.context().getResources().getStringArray(R.array.title_hot));
        add(8,40,8,app.context().getResources().getStringArray(R.array.title_jamais));

        add(Categorie.REPONSE_, 0, Categorie.REPONSE_, app.context().getResources().getStringArray(R.array.title_tsunami_reponse));
        add(Categorie.SEQUENCE_, 0, Categorie.SEQUENCE_, app.context().getResources().getStringArray(R.array.title_tsunami_sequence));*/
    }



}
