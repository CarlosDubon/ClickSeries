package com.example.carlos.clickseries;

public class Serie {
    private String name;
    private String description;
    private String caps;
    private boolean isFavorite = false;
    private int image;

    public Serie() {
    }

    public Serie(String name, String description, String caps,int image, boolean isFavorite) {
        this.name = name;
        this.description = description;
        this.caps = caps;
        this.isFavorite = isFavorite;
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCaps(String caps) {
        this.caps = caps;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCaps() {
        return caps;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public int getImage(){
        return image;
    }
}
