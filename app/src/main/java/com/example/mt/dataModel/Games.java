package com.example.mt.dataModel;

public class Games {

    private String gameName;
    private String gameRate;
    private String gamePrice;

    public Games(){

    }

    public Games(String Name, String Rate, String Price) {
        this.gameName = Name;
        this.gameRate = Rate;
        this.gamePrice = Price;
    }

    public String getGameName() {
        return gameName;
    }


    public String getGameRate() {
        return gameRate;
    }

    public String getGamePrice() {
        return gamePrice;
    }

    public void setGameName(String Name) {
        this.gameName = Name;
    }

    public void setGameRate(String Rate) {
        this.gameRate = Rate;
    }

    public void setGamePrice(String Price) {
        this.gamePrice = Price;
    }
}
