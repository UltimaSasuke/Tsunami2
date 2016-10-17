package com.hybrid_games.tsunami;

    import android.app.Activity;
    import android.content.Intent;
    import android.content.pm.ActivityInfo;
    import android.graphics.Typeface;
    import android.os.Bundle;
    import android.support.v7.app.AppCompatActivity;
    import android.text.Layout;
    import android.view.View;
    import android.view.Window;
    import android.view.WindowManager;
    import android.widget.EditText;
    import android.widget.LinearLayout;
    import android.widget.RelativeLayout;
    import android.widget.TextView;

    import java.util.ArrayList;
    import java.util.Random;

    /**
     * Created by Diego on 13/06/2016.
     */
    public class Tsunami extends Mode{

        private App app = new App();

        Tsunami() {}


        void initialisationStrings() {


            setMode(TSUNAMI);
            setModePart(TSUNAMI_PART);

            /*for(int i = 0; i < 500; ++i) add(i,0,i,null);


            add(0,30,0,app.context().getResources().getStringArray(R.array.title_si));
            add(1,40,1,app.context().getResources().getStringArray(R.array.title_defi));
            add(2,50,2,app.context().getResources().getStringArray(R.array.title_mime));
            add(3,50,3,app.context().getResources().getStringArray(R.array.title_lemeilleur));
            add(4,50,4,app.context().getResources().getStringArray(R.array.title_dure_debut));
            add(9,60,9,app.context().getResources().getStringArray(R.array.title_normal));
            add(5,20,5,app.context().getResources().getStringArray(R.array.title_tsunami_question));
            add(7,40,7,app.context().getResources().getStringArray(R.array.title_qui_pourrait));

            add(Categorie.REPONSE_, 0, Categorie.REPONSE_, app.context().getResources().getStringArray(R.array.title_tsunami_reponse));
            add(Categorie.SEQUENCE_, 0, Categorie.SEQUENCE_, app.context().getResources().getStringArray(R.array.title_tsunami_sequence));*/

        }


    }

