package com.hybrid_games.tsunami;

import android.view.animation.Animation;

/**
 * Created by Diego on 15/10/2016.
 */
public class Slide {

    private String title;
    private String message;
    private int color;
    private Animation anim;

    public Slide(String title, String message, int color/*, Animation anim*/) {

        this.title = title;
        this.message = message;
        this.color = color;
        this.anim = anim;
    }


    public String getTitle() { return title; }
    public Animation getAnim() { return anim; }
    public String getMessage() {
        return message;
    }
    public int getColor() { return color;}
}

