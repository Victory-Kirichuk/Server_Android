package com.example.demo.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "series")
public class Series implements Comparable<Series>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "genre")
    private String genre;

    @Column(name = "seasons")
    private String seasons;

    @Column(name = "producers")
    private String producers;

    @Column(name = "actors")
    private String actors;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "image")
    private String image;

    @Column(name = "date")
    private String date;

    @OneToMany
    @JoinColumn(name = "series_id")
    private List<Episodes> episodes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSeasons() {
        return seasons;
    }

    public void setSeasons(String seasons) {
        this.seasons = seasons;
    }

    public String getProducers() {
        return producers;
    }

    public void setProducers(String producers) {
        this.producers = producers;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Episodes> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episodes> episodes) {
        this.episodes = episodes;
    }

    @Override
    public int compareTo(Series series) {
       return rating.compareTo(series.rating);
    }
}
