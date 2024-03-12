package com.example.sonic.network.model;

import java.sql.Date;

public class ArtistDTO {
    private Integer artistID;
    private String name;
    private Date dateOfBirth;
    private String country;
    private String image;

    public ArtistDTO(Integer artistID, String name, Date dateOfBirth, String country, String image) {
        this.artistID = artistID;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
        this.image = image;
    }

    public ArtistDTO() {
    }

    public Integer getArtistID() {
        return artistID;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getCountry() {
        return country;
    }

    public String getImage() {
        return image;
    }

    public void setArtistID(Integer artistID) {
        this.artistID = artistID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ArtistDTO{" +
                "artistID=" + artistID +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", country='" + country + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
