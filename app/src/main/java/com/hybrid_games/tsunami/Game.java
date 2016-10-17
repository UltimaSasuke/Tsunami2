package com.hybrid_games.tsunami;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Diego on 14/06/2016.
 */
public class Game {

    private Categorie categorie = new Categorie();
    private Mode mode;
    private ArrayList<String> joueurs = new ArrayList<String>();
    private ArrayList<Slide> slides = new ArrayList<Slide>();
    private int nbSlide;
    private Random rand;
    private int texte;

    private ArrayList<Slide> slideTaken = new ArrayList<Slide>();
    private ArrayList<String> listPouvoir = new ArrayList<String>();
    private ArrayList<Integer> tempsPouvoir = new ArrayList<Integer>();
    private ArrayList<Integer> textDure = new ArrayList<Integer>();
    private String[] teamName;
    private Slide current_slide;
    private int current_pos = 0;
    App app = null;

    public Game(ArrayList<String> joueurs, Mode mode) {



        app = new App();
        this.mode = mode;
        this.joueurs = joueurs;
        rand = new Random(System.currentTimeMillis());
        setNbSlide();
        this.mode.initialisationStrings();

        setCategories();





    }



    private void setNbSlide() {
        nbSlide = joueurs.size()* 5;
    }

    private void setCategories() {
        Slide slide;

        float random;

        for(int i = 0; i < nbSlide; ++i) {
            random = rand.nextInt(mode.getSumPM());

            int t = 0;
            while (t++ < mode.getNbCategorie()) {
                if (random < mode.getAddPmFor(t)) {
                    categorie.setCat(mode.getCatFor(t));
                    break;
                }

            }

            if (t == mode.getNbCategorie()) categorie.setCat(mode.getCatFor(mode.getNbCategorie()-1));


            texte = rand.nextInt(categorie.sizeOfCat());

            while (categorie.next()) {


                System.out.println("cat = " + categorie.getCat() + " - N°Texte = " + texte);
                System.out.println("Texte = " + categorie.getMessage(texte));
                slide = new Slide(categorie.getTitle(), translateMessage(categorie.getMessage(texte)), categorie.getColor());
                /*while (isAlreadyTook(slide)) {
                    texte = rand.nextInt(categorie.sizeOfCat());
                    slide = new Slide(categorie.getTitle(), translateMessage(categorie.getMessage(texte)), categorie.getColor());
                }*/
                if (categorie.getCat() == categorie.CADUREDEBUT_) {

                    textDure.add(texte);
                }


                slides.add(slide);
                slideTaken.add(slide);
            }

            for (int j = 0; j < tempsPouvoir.size(); ++j) {
            System.out.println(tempsPouvoir.size());
                if (tempsPouvoir.get(j) == 0) {
                    categorie.setCat(categorie.CADUREFIN_);

                    System.out.println(categorie.getTitle() + " ~~ " + textDure.get(j));
                    slide = new Slide(categorie.getTitle(), translateSpecialMessage(categorie.getMessage(textDure.get(j)), listPouvoir.get(j)), categorie.getColor());
                    slides.add(slide);

                    tempsPouvoir.remove(j);
                    textDure.remove(j);
                    listPouvoir.remove(j);

                } else {

                    tempsPouvoir.set(j, tempsPouvoir.get(j)-1);


                }


            }

            //++current_pos;
        }
            /*
                if (cat == 0) { //si

                    texte = rand.nextInt(si.length);

                    questActual = new Slide(typeSlide[cat], translateMessage(si[texte]), app.context().getResources().getColor(R.color.si));
                    while (isAlreadyTook(questActual)) {
                        texte = rand.nextInt(si.length);
                        questActual = new Slide(typeSlide[cat], translateMessage(si[texte]), app.context().getResources().getColor(R.color.si));

                    }
                    categories.add(questActual);
                    questionTaken.add(questActual);

                } else if (cat == 1) { // defi
                    texte = rand.nextInt(defi.length);
                    questActual = new Slide(typeSlide[cat], translateMessage(defi[texte]), app.context().getResources().getColor(R.color.defi));
                    while (isAlreadyTook(questActual)) {
                        texte = rand.nextInt(defi.length);
                        questActual = new Slide(typeSlide[cat], translateMessage(defi[texte]), app.context().getResources().getColor(R.color.defi));

                    }
                    categories.add(questActual);
                    questionTaken.add(questActual);

                } else if (cat == 2) { //mime
                    texte = rand.nextInt(mime.length);
                    questActual = new Slide(typeSlide[cat], translateMessage(PHRASEMIME), app.context().getResources().getColor(R.color.mime));
                    while (isAlreadyTook(questActual)) {
                        texte = rand.nextInt(mime.length);

                        questActual = new Slide(typeSlide[cat], translateMessage(PHRASEMIME), app.context().getResources().getColor(R.color.mime));

                    }

                    categories.add(questActual);
                    questionTaken.add(questActual);
                    questActual = new Slide(typeSlide[cat], mime[texte], app.context().getResources().getColor(R.color.mime));
                    while (isAlreadyTook(questActual)) {
                        questActual = new Slide(typeSlide[cat], mime[texte], app.context().getResources().getColor(R.color.mime));

                    }
                    categories.add(questActual);
                    questionTaken.add(questActual);


                } else if (cat == 3) { //leplysfort
                    texte = rand.nextInt(lePlusFort.length);
                    questActual = new Slide(typeSlide[cat], translateMessage(lePlusFort[texte]), app.context().getResources().getColor(R.color.lemeilleur));
                    while (isAlreadyTook(questActual)) {
                        texte = rand.nextInt(lePlusFort.length);

                        questActual = new Slide(typeSlide[cat], translateMessage(lePlusFort[texte]), app.context().getResources().getColor(R.color.lemeilleur));

                    }

                    categories.add(questActual);
                    questionTaken.add(questActual);

                } else if (cat == 4) { //cadure
                    texte = rand.nextInt(caDureDebut.length);


                    textDure.add(texte);
                    questActual = new Slide(typeSlide[cat], translateMessage(caDureDebut[texte]), app.context().getResources().getColor(R.color.dure));
                    while (isAlreadyTook(questActual)) {
                        texte = rand.nextInt(caDureDebut.length);

                        questActual = new Slide(typeSlide[cat], translateMessage(caDureDebut[texte]), app.context().getResources().getColor(R.color.dure));
                    }

                    categories.add(questActual);
                    questionTaken.add(questActual);

                } else if (cat == 5) { //Tsunami
                    texte = rand.nextInt(tsunami.length);

                    questActual = new Slide(typeSlide[cat], translateMessage(PHRASETSUNAMI), app.context().getResources().getColor(R.color.tsunami));
                    while (isAlreadyTook(questActual)) {
                        questActual = new Slide(typeSlide[cat], translateMessage(PHRASETSUNAMI), app.context().getResources().getColor(R.color.tsunami));
                    }
                    categories.add(questActual);
                    questionTaken.add(questActual);

                    questActual = new Slide(typeSlide[cat], translateMessage(tsunami[texte]), app.context().getResources().getColor(R.color.tsunami));
                    while (isAlreadyTook(questActual)) {
                        texte = rand.nextInt(tsunami.length);

                        questActual = new Slide(typeSlide[cat], translateMessage(tsunami[texte]), app.context().getResources().getColor(R.color.tsunami));
                    }
                    categories.add(questActual);
                    questionTaken.add(questActual);

                    questActual = new Slide(typeSlide[cat], translateMessage(reponse[texte]), app.context().getResources().getColor(R.color.tsunami));
                    while (isAlreadyTook(questActual)) {
                        questActual = new Slide(typeSlide[cat], translateMessage(reponse[texte]), app.context().getResources().getColor(R.color.tsunami));
                    }
                    texte = rand.nextInt(sequence.length);

                    categories.add(questActual);
                    questionTaken.add(questActual);

                    questActual = new Slide(typeSlide[cat], translateMessage(sequence[texte]), app.context().getResources().getColor(R.color.tsunami));
                    while (isAlreadyTook(questActual)) {
                        texte = rand.nextInt(sequence.length);

                        questActual = new Slide(typeSlide[cat], translateMessage(sequence[texte]), app.context().getResources().getColor(R.color.tsunami));
                    }
                    categories.add(questActual);
                    questionTaken.add(questActual);

                }else if(cat == 9) { //normal

                    texte = rand.nextInt(normal.length);
                    while (isAlreadyTook(questActual = new Slide("", translateMessage(normal[texte]), app.context().getResources().getColor(R.color.normal)))) {
                    }
                    categories.add(questActual);
                    questionTaken.add(categories.get(categories.size() - 1));


                } else if(cat == 6) { // hot

                    texte = rand.nextInt(hot.length);
                    questActual = new Slide(typeSlide[cat], translateMessage(hot[texte]),app.context().getResources().getColor(R.color.hot));
                    while (isAlreadyTook(questActual)) {
                        questActual = new Slide(typeSlide[cat], translateMessage(hot[texte]),app.context().getResources().getColor(R.color.hot));
                    }
                    categories.add(questActual);
                    questionTaken.add(questActual);
                } else if(cat == 7) { // qui pourrait

                    questActual = new Slide(typeSlide[cat], translateMessage(PHRASEPOURRAIT),app.context().getResources().getColor(R.color.pourrait));
                    categories.add(questActual);


                    texte = rand.nextInt(quiPourrait.length);
                    questActual = new Slide(typeSlide[cat], translateMessage(quiPourrait[texte]),app.context().getResources().getColor(R.color.pourrait));
                    while (isAlreadyTook(questActual)) {
                        questActual = new Slide(typeSlide[cat], translateMessage(quiPourrait[texte]),app.context().getResources().getColor(R.color.pourrait));
                    }
                    categories.add(questActual);
                    questionTaken.add(questActual);
                }else if(cat == 8) { // jamais

                    texte = rand.nextInt(quiPourrait.length);
                    questActual = new Slide(typeSlide[cat], translateMessage(jamais[texte] + PHRASEJAMAIS), app.context().getResources().getColor(R.color.jamais));
                    while (isAlreadyTook(questActual)) {
                        questActual = new Slide(typeSlide[cat], translateMessage(jamais[texte] + PHRASEJAMAIS), app.context().getResources().getColor(R.color.jamais));
                    }
                    categories.add(questActual);
                    questionTaken.add(questActual);

                }*/






    }

    public int size() {

        return slides.size();


    }

    private String translateMessage(String message) {


        String messageTranslated = message;

        String joueurUn = joueurs.get(rand.nextInt(joueurs.size()));
        String joueurDeux = joueurUn;
        int nbGorgée = rand.nextInt(5)+1;

        while(joueurUn.equals(joueurDeux))
            joueurDeux = joueurs.get(rand.nextInt(joueurs.size()));


        if (messageTranslated != null) {
            messageTranslated = messageTranslated.replace("@", joueurUn);
            messageTranslated = messageTranslated.replace("$", joueurDeux);

            if (messageTranslated.length() > messageTranslated.indexOf("*")) {
                messageTranslated = messageTranslated.replace("*", Integer.toString(nbGorgée));

                if (nbGorgée == 1)
                    messageTranslated = messageTranslated.replace("gorgées", "gorgée");
            }
            if (categorie.getCat() == categorie.CADUREDEBUT_) {
                listPouvoir.add(joueurUn);
                tempsPouvoir.add(rand.nextInt(6) + 2);
            }
        }
        return messageTranslated;
    }


    private String translateSpecialMessage(String message, String pseudo) {
        String messageTranslated = message;

        messageTranslated = messageTranslated.replace("@", pseudo);
        return messageTranslated;


    }

    public int getPos() {

        return current_pos;

    }

    public Slide getNextSlide() {

        //if(current_pos < slides.size())
            return getCurrentSlide();
        //return null;

    }

    public Slide getCurrentSlide() {

        return slides.get(current_pos++);


    }


    private boolean isAlreadyTook(Slide quest) {

        for(int i = 0; i < slideTaken.size(); ++i)
            if (quest == slideTaken.get(i))
                return true;
        return false;
    }


    public int getNbSlideSlide() {


        return slides.size();
    }

}
