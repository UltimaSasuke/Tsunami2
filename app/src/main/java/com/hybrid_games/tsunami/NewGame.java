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
 * Created by Diego on 15/10/2016.
 */
public class NewGame extends Activity {

    /*
        Game Mode
     */
    static final int TRAINING = 0;
    static final int TSUNAMI = 1;
    static final int HOT = 3;
    static final int VERSUS = 4;
    private Mode mode;
    private int m;

    private TextView title;
    private TextView texte;
    private TextView nQuestion;

    //private LinearLayout layout;
    private Game game;
    private Slide current_slide;
    private int n_question = 0;
    private ArrayList<String> joueurs = new ArrayList<String>();
    private App app = new App();
    RelativeLayout layout = null;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        layout = (RelativeLayout) RelativeLayout.inflate(this, R.layout.game, null);


        Typeface fonttitle = Typeface.createFromAsset(getAssets(), "fonts/The Light Brigade.otf");

        Typeface fonttexte = Typeface.createFromAsset(getAssets(), "fonts/Beautiful Heartbeat.otf");

        Intent i = getIntent();
        joueurs = (ArrayList<String>) getIntent().getSerializableExtra("joueurs");
        m = (int) getIntent().getSerializableExtra("mode");
        title = (TextView) layout.findViewById (R.id.name);
        texte = (TextView) layout.findViewById (R.id.indication);
        nQuestion = (TextView) layout.findViewById(R.id.nQuestion);

        title.setTypeface(fonttitle);
        texte.setTypeface(fonttexte);


        if(m == 1) mode = new Training();
        else if (m == 2) mode = new Tsunami();
        else if (m == 3) mode = new Hot();

        game = new Game(joueurs, mode);



        layout.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                current_slide = game.getNextSlide();
                ++n_question;
                if(n_question >= game.getNbSlideSlide()) {
                    Intent mainActivity = new Intent(NewGame.this, MainActivity.class);
                    startActivity(mainActivity);
                }
                title.setText(current_slide.getTitle());
                texte.setText(current_slide.getMessage());
                //title.startAnimation(current_slide.getTitleAnimation());
                //texte.startAnimation(current_slide.getTitleAnimation());
                nQuestion.setText(n_question + "/" + (game.getNbSlideSlide() - 1));





                layout.setBackgroundColor(current_slide.getColor());
            }
        });
        current_slide = game.getCurrentSlide();
        layout.setBackgroundColor(current_slide.getColor());

        ++n_question;

        title.setText(current_slide.getTitle());
        texte.setText(current_slide.getMessage());
        //nQuestion.setText(n_question);


        setContentView(layout);


    }


}
