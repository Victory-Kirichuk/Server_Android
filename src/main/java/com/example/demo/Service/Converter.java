package com.example.demo.Service;

import com.example.demo.Entity.Episodes;
import com.example.demo.Entity.Timetable;
import com.example.demo.Repository.SeriesRepository;

public class Converter {
  private static   EpisodesService episodesService;
  private static SeriesRepository seriesRepository;
    private static Timetable convert(Episodes episode) {

        Timetable timetable = new Timetable();

        timetable.setSeriesId(episode.getSeriesId());

        timetable.setSeriesName(seriesRepository.findById(episode.getSeriesId()).get().getName());
        timetable.setEpisodesNumber(episode.getNumber());
        timetable.setEpisodesSeason(episode.getSeason());
        timetable.setEpisodesDate(episode.getDate());
        timetable.setEpisodeId(episode.getId());
        timetable.setEpisodeName(episode.getName());
        timetable.setImage(seriesRepository.findById(episode.getSeriesId()).get().getImage());

    return timetable;}
   }
