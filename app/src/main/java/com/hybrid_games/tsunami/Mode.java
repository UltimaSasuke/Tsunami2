package com.hybrid_games.tsunami;

import java.util.ArrayList;

/**
 * Created by Diego on 15/10/2016.
 */
abstract class Mode {

    protected ArrayList<Integer> p_m = new ArrayList<Integer>();
    protected ArrayList<Integer> categorie = new ArrayList<Integer>();
    protected int nbCategorie;
    static final int TEAMNAME_ = 0;
    static final int SI_ = 1;
    static final int DEFI_ = 2;
    static final int MIME_ = 3;
    static final int LEPLUSFORT_ = 4;
    static final int CADUREDEBUT_ = 5;
    static final int CADUREFIN_ = 6;
    static final int TSUNAMI_ = 7;
    static final int REPONSE_ = 8;
    static final int SEQUENCE_ = 9;
    static final int NORMAL_ = 10;
    static final int HOT_ = 11;
    static final int QUIPOURRAIT_ = 12;
    static final int JAMAIS_ = 13;
    private String[] nameSlide = {"Si tu as deja", "Defi", "Mime", "C'est moi le plus fort", "Et ca dure !", "TSUNAMI !!!", "HOT", "Qui pourrait... ?", "Je n'ai jamais"};


    private ArrayList<String[]> categories = new ArrayList<String[]>();
    private App app = new App();


    static final int[] TRAINING = {0, 50, 20, 30, 40, 50, 0, 0, 0, 0, 70, 0, 0, 0};
    static final int[] TRAINING_PART = {1, 2, 3, 4, 5, 10};
    static final int[] TSUNAMI = {0, 50, 20, 30, 40, 50, 0, 50, 0, 0, 50, 0, 30, 0};
    static final int[] TSUNAMI_PART = {1, 2, 3, 4, 5, 7, 9, 11};
    static final int[] HOT = {0, 50, 20, 30, 40, 50, 0, 0, 0, 0, 10, 60, 0, 50};
    static final int[] HOT_PART = {1, 2, 3, 4, 5, 9, 10, 12};

    private int[] mode;
    private int[] mode_part;


    abstract void initialisationStrings();

    protected void setMode(int[] mode) {

        this.mode = mode;

        System.out.println(this.mode.length + " cat loaded.");

    }

    protected void setModePart(int[] modep) {


        this.mode_part = modep;

        System.out.println(this.mode_part.length);


    }

    protected void add(int index, int pm) {

        if (pm != 0) {
            p_m.add(index, pm);
            nbCategorie += 1;
        }

    }

    protected int getCatFor(int j) {


        return mode_part[j];

    }

    protected int getAddPmFor(int j) {

        int pm = 0;

        for (int i = 0; i <= j; ++i) {

            pm += mode[mode_part[i]];
        }

        return pm;

    }

    protected int getSumPM() {

        int pm = 0;

        for (int i = 0; i < mode_part.length; ++i)
            pm += mode[mode_part[i]];

        return pm;
    }

    protected int getNbCategorie() {
        return mode_part.length;
    }

    protected int getPM(int i) {
        return p_m.get(i);
    }

    protected int sizeOfPhrases(int cat) {
        return categories.get(cat).length;
    }

    protected String getNameCat(int cat) {
        return nameSlide[cat];
    }

    protected String getTexte(int i, int j) {
        return categories.get(i)[j];
    }

    protected int getSequenceSize() {
        return categories.get(Categorie.SEQUENCE_).length;
    }

}
