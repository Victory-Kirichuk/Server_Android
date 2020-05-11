package com.example.demo.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "episodes")
public class Episodes implements Comparable<Episodes> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "series_id")
    private Integer seriesId;

    @Column(name = "name")
    private String name;

    @Column(name = "number")
    private Integer number;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "season")
    private Integer season;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Integer seriesId) {
        this.seriesId = seriesId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public int compareTo(Episodes episodes){
        return date.compareTo(episodes.date);
    }
}
