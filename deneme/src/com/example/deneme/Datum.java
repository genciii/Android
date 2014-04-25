package com.example.deneme;

public class Datum {
    
    int id;
    String title,pen;

    public Datum(int id, String title, String pen) {
        this.id = id;
        this.title = title;
    }
    
    public String toString() {
        return title;
    }

    public int getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }

}
