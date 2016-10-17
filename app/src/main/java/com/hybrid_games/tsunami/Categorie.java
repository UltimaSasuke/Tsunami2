package com.hybrid_games.tsunami;

import java.util.Random;

/**
 * Created by Diego on 15/10/2016.
 */
public class Categorie {

    private Mode mode;

    private static final int NBCATEGORIES = 14;
    static final int TEAMNAME_ = 0;
    static final int NORMAL_ = 10;
    static final int HOT_ = 11;
    static final int SI_ = 1;
    static final int DEFI_ = 2;
    static final int MIME_ = 3;
    static final int LEPLUSFORT_ = 4;
    static final int CADUREDEBUT_ = 5;
    static final int CADUREFIN_ = 6;
    static final int TSUNAMI_ = 7;
    static final int REPONSE_ = 8;
    static final int SEQUENCE_ = 9;
    static final int QUIPOURRAIT_ = 12;
    static final int JAMAIS_ = 13;

    private int SEQUENCE_SIZE;
    private final static String[] PHRASEPLUS = {"",
                                                "",
                                                "",
                                                "@ prepare toi, le moment du mime est arrivé ! Tu auras 30s pour réussir à faire deviner le mot. Celui qui devinera distribura 5 gorgées, si personne ne devine le mot, alors tu devras boire les 5 gorgées.",
                                                "",
                                                "",
                                                "",
                                                "C'est l'heure du Tsunami, serez-vous assez fou pour alimenter la vague ? Chacun votre tour, en commençant par @ allez parier sur une reponse. Mais attention, à la fin du Tsunami vous verrez les concéquences du carnage, des fois il vaut mieux ne pas s'y risquer. Allez-vous réussir à vous échapper ?",
                                                "",
                                                "",
                                                "",
                                                "",
                                                "On compte jusqu’à trois, puis tout le monde pointe en même temps du doigt la personne qui, selon eux, serait la plus susceptible de faire la chose qui sera mentionnée. Vous devez boire autant de fois qu’il y a des personnes qui vous désignent (donc si 7 personnes vous désignent , vous devez boire 7 fois). C'est partie pour le \"Qui pourrait ?\" ",
                                                " * gorgées pour ceux qui l'ont fais."};

    private String[] nameSlide = {"VS", "Si tu as deja", "Defi", "Mime", "C'est moi le plus fort", "Et ca dure !", "Et c'est fini...", "TSUNAMI !!!", "", "", "NORMAL", "HOT","Qui pourrait... ?", "Je n'ai jamais"};


    private int cat;
    private int where;
    private int num = 0;
    private String nameCat;
    private String messageCat;
    private int color;
    private App app = new App();
    private Random rand = new Random();
    private int number;

    private String[][] categories = new String[NBCATEGORIES][];


    Categorie() {

        initalization();


    }


    public void setCat(int cat) {

        number = rand.nextInt(categories[cat].length);
        this.cat = cat;
        this.nameCat = nameSlide[cat];
        this.messageCat = categories[cat][number];
        num = 0;
        setParam();

    }

    private void initalization() {



        categories[0] = app.context().getResources().getStringArray(R.array.team_name);
        categories[1] = app.context().getResources().getStringArray(R.array.title_si);
        categories[2]= app.context().getResources().getStringArray(R.array.title_defi);
        categories[3] = app.context().getResources().getStringArray(R.array.title_mime);
        categories[4] = app.context().getResources().getStringArray(R.array.title_lemeilleur);
        categories[5] = app.context().getResources().getStringArray(R.array.title_dure_debut);
        categories[6] = app.context().getResources().getStringArray(R.array.title_dure_fin);
        categories[7] = app.context().getResources().getStringArray(R.array.title_tsunami_question);
        categories[8] = app.context().getResources().getStringArray(R.array.title_tsunami_reponse);
        categories[9] = app.context().getResources().getStringArray(R.array.title_tsunami_sequence);
        categories[10] = app.context().getResources().getStringArray(R.array.title_normal);
        categories[11] = app.context().getResources().getStringArray(R.array.title_hot);
        categories[12] = app.context().getResources().getStringArray(R.array.title_qui_pourrait);
        categories[13] = app.context().getResources().getStringArray(R.array.title_jamais);


    }


    void setParam() {

        if (cat == 1 || cat == 2 || cat == 4 || cat == 5 || cat == 10 || cat == 11 || cat == 13) {

            where = 2;

        }
        else if(cat == 3  || cat == 12) {

            where = 3;

        }
        else if (cat == 7) {

            where = 5;
        }



        switch(cat) {


            case DEFI_  :
                color = app.context().getResources().getColor(R.color.defi);
            case MIME_ :
                color = app.context().getResources().getColor(R.color.mime);
            case LEPLUSFORT_ :
                color = app.context().getResources().getColor(R.color.lemeilleur);
            case SI_ :
                color = app.context().getResources().getColor(R.color.si);
            case CADUREDEBUT_ :
                color = app.context().getResources().getColor(R.color.dure);
            case CADUREFIN_ :
                color = app.context().getResources().getColor(R.color.dure);
            case TSUNAMI_ :
                color = app.context().getResources().getColor(R.color.tsunami);
            case REPONSE_ :
                color = app.context().getResources().getColor(R.color.tsunami);
            case SEQUENCE_ :
                color = app.context().getResources().getColor(R.color.tsunami);
            case HOT_ :
                color = app.context().getResources().getColor(R.color.hot);
            case QUIPOURRAIT_ :
                color = app.context().getResources().getColor(R.color.pourrait);
            case JAMAIS_ :
                color = app.context().getResources().getColor(R.color.jamais);
            case NORMAL_ :
                color = app.context().getResources().getColor(R.color.normal);


        }



    }

    boolean next() {

        ++num;

        return num != where;


    }





    String getTitle() {

        return nameCat;

    }


    int sizeOfCat() {

        return categories[cat].length;

    }

    String getMessage(int texte) {

    int seq = new Random().nextInt(categories[SEQUENCE_].length);


        if (num == 0 && (cat == 3 || cat == 7 || cat == 12)) return PHRASEPLUS[cat];
        else if (num == 0 && cat == 13) return categories[cat][texte] + PHRASEPLUS[cat];
        else if(num == 0) return categories[cat][texte];
        else if (num == 1) return categories[cat][texte];
        else if (num == 2) return categories[REPONSE_][texte];
        else if (num == 3) return categories[SEQUENCE_][seq];
        else  return null;
    }

    int getColor() {

        return color;

    }

    int getCat() { return cat; }


}
