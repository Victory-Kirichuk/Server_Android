package com.example.demo.Entity;

import java.util.Date;

public class Timetable {

    private Integer episodeId;
    private Integer seriesId;
    private String seriesName;
    private Integer episodesNumber;
    private Integer episodesSeason;
    private Date episodesDate;
    private String episodeName;
    private String image;

    public Integer getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(Integer episodeId) {
        this.episodeId = episodeId;
    }

    public Integer getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Integer seriesId) {
        this.seriesId = seriesId;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public Integer getEpisodesNumber() {
        return episodesNumber;
    }

    public void setEpisodesNumber(Integer episodesNumber) {
        this.episodesNumber = episodesNumber;
    }

    public Integer getEpisodesSeason() {
        return episodesSeason;
    }

    public void setEpisodesSeason(Integer episodesSeason) {
        this.episodesSeason = episodesSeason;
    }

    public Date getEpisodesDate() {
        return episodesDate;
    }

    public void setEpisodesDate(Date episodesDate) {
        this.episodesDate = episodesDate;
    }

    public String getEpisodeName() {
        return episodeName;
    }

    public void setEpisodeName(String episodeName) {
        this.episodeName = episodeName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
