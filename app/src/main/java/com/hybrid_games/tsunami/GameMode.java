package com.hybrid_games.tsunami;

import android.content.Context;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Diego on 18/06/2016.
 */
public class GameMode extends LinearLayout {

    private String title;
    private String description;
    TextView textView;
    TextView descriptionView;

    public GameMode(Context context, String title, String description) {
        super(context);
        this.title = title;        this.description = description;


        Typeface fonttitle = Typeface.createFromAsset(App.context().getAssets(), "fonts/The Light Brigade.otf");
        Typeface fonttexte = Typeface.createFromAsset(App.context().getAssets(), "fonts/Beautiful Heartbeat.otf");


        setOrientation(VERTICAL);

        textView = new TextView(context);
        textView.setText('\n' + title + '\n');
        textView.setTypeface(fonttitle);

        descriptionView = new TextView(context);
        descriptionView.setText(description + '\n');
        descriptionView.setTypeface(fonttexte);
        addView(textView);
        addView(descriptionView);




        textView.setTextSize(30);
        descriptionView.setTextSize(20);


    }

    public void setWidth() {

        textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        descriptionView.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        textView.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        descriptionView.setTextAlignment(TEXT_ALIGNMENT_CENTER);

    }


}
