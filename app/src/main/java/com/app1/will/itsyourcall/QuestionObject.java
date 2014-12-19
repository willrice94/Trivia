package com.app1.will.itsyourcall;

/**
 * Created by Will on 12/18/2014.
 */
public enum QuestionObject {

    Q1("Which has better Lattes?","Dunkin' Donuts","Starbucks",1,1);

    private final String question;
    private final String option1;
    private final String option2;

    private final int category;
    private final int index;

    QuestionObject(String question, String option1, String option2, int category, int index) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;

        this.category = category;
        this.index = index;
    }

    public String theCategory(int value){
        if(value == 1){
            return "Politics";
        }
        if(value == 2) {
            return "Sports";
        }
        if(value == 3){
            return "Food";
        }
        if(value == 4) {
            return "Movies/Pop Culture";
        }
        return "Random";
    }

    public String getQuestion(){
        return question;
}
    public String getOption1(){
        return option1;
    }
    public String getOption2(){
        return option2;
    }
    public int getCategory(){
        return category;
    }
    public int getIndex(){
        return index;
    }

}