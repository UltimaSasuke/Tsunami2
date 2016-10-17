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
public class Training extends Mode {

    private App app = new App();

    Training() {}


    void initialisationStrings() {


        setMode(TRAINING);
        setModePart(TRAINING_PART);

     }





}
