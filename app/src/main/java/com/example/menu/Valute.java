package com.example.menu;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Valute {

//    @SerializedName("ID")
//    @Expose
//    private String ID;
//
//    @SerializedName("NumCode")
//    @Expose
//    private String NumCode;

    @SerializedName("CharCode")
    @Expose
    private String CharCode; //

    @SerializedName("Nominal")
    @Expose
    private int Nominal;

//    @SerializedName("Name")
//    @Expose
//    private String Name;

    @SerializedName("Value")
    @Expose
    private double Value; //

//    @SerializedName("Previous")
//    @Expose
//    private double Previous;

//    public String getID() {
//        return ID;
//    }
//
//    public void setID(String ID) {
//        this.ID = ID;
//    }
//
//    public String getNumCode() {
//        return NumCode;
//    }
//
//    public void setNumCode(String numCode) {
//        NumCode = numCode;
//    }

    public String getCharCode() {
        return CharCode;
    }

    public void setCharCode(String charCode) {
        CharCode = charCode;
    }

    public int getNominal() {
        return Nominal;
    }

    public void setNominal(int nominal) {
        Nominal = nominal;
    }
//
//    public String getName() {
//        return Name;
//    }
//
//    public void setName(String name) {
//        Name = name;
//    }

    public double getValue() {
        return Value;
    }

    public void setValue(double value) {
        Value = value;
    }
//
//    public double getPrevious() {
//        return Previous;
//    }
//
//    public void setPrevious(double previous) {
//        Previous = previous;
//    }
}
