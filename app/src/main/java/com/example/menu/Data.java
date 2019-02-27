package com.example.menu;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Map;

public class Data {
//    @SerializedName("Date")
//    @Expose
//    private String date;
//    @SerializedName("PreviousDate")
//    @Expose
//    private String pDate;
//    @SerializedName("PreviousURL")
//    @Expose
//    private String pURL;
//    @SerializedName("Timestamp")
//    @Expose
//    private String timestamp;
    @SerializedName("Valute")
    @Expose
    private Map<String, Valute> valute = null;

//    public String getDate() {
//        return date;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }
//
//    public String getpDate() {
//        return pDate;
//    }
//
//    public void setpDate(String pDate) {
//        this.pDate = pDate;
//    }
//
//    public String getpURL() {
//        return pURL;
//    }
//
//    public void setpURL(String pURL) {
//        this.pURL = pURL;
//    }
//
//    public String getTimestamp() {
//        return timestamp;
//    }
//
//    public void setTimestamp(String timestamp) {
//        this.timestamp = timestamp;
//    }

    public Map<String, Valute> getValute() {
        return valute;
    }

    public void setValute(Map<String, Valute> valute) {
        this.valute = valute;
    }
}
