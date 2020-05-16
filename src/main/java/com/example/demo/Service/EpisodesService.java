package com.example.demo.Service;

import com.example.demo.Entity.Notification;
import com.example.demo.Entity.Episodes;
import com.example.demo.Entity.Series;
import com.example.demo.Entity.Timetable;
import com.example.demo.Repository.NotificationRepository;
import com.example.demo.Repository.EpisodesRepository;
import com.example.demo.Repository.SeriesRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EpisodesService {

    private final NotificationRepository notificationRepository;
    private final EpisodesRepository episodesRepository;
    private final SeriesRepository seriesRepository;
    /* public Series getById(Integer id) {
         return seriesRepository.findById(id).get();
     }*/


    public EpisodesService(NotificationRepository notificationRepository, EpisodesRepository episodesRepository, SeriesRepository seriesRepository) {
        this.notificationRepository = notificationRepository;
        this.episodesRepository = episodesRepository;
        this.seriesRepository = seriesRepository;
    }


    public List<Episodes> get(String name) {
        return seriesRepository.findByNameOrderByDateAsc(name).getEpisodes();
    }

  /*  public Episodes getEpisodeByEpisodeId(Integer episodeId) {

        return episodesRepository.findById(episodeId).get();


    }*/

    public Timetable getTimeTableByEpisodeId(Integer episodeId) {
        Timetable timetable = new Timetable();
        Episodes episode = episodesRepository.findById(episodeId).get();
        timetable.setSeriesId(episode.getSeriesId());
        timetable.setSeriesName(seriesRepository.findById(episode.getSeriesId()).get().getName());
        timetable.setEpisodesNumber(episode.getNumber());
        timetable.setEpisodesSeason(episode.getSeason());
        timetable.setEpisodesDate(episode.getDate());
        timetable.setEpisodeId(episode.getId());
        timetable.setEpisodeName(episode.getName());
        timetable.setImage(seriesRepository.findById(episode.getSeriesId()).get().getImage());
        return timetable;

    }

    public List<Timetable> getTimeTable(String email) {
        List<Timetable> timetables = new ArrayList<>();
        List<Episodes> episodes = new ArrayList<>();
        List<Notification> notifications = notificationRepository.findAllByEmail(email);
        Timestamp date = new Timestamp(System.currentTimeMillis() - 2 * 24 * 60 * 60 * 1000);
//Timestamp date2 = new Timestamp(System.currentTimeMillis()+24*60*60*1000);


        for (Notification notification : notifications) {
            episodes.addAll(episodesRepository.findAllBySeriesIdAndDateAfter(notification.getSeries().getId(), date));
        }
        return getTimetables(timetables, episodes);
    }

    public List<Timetable> getTimeTableToday(String email) {
        List<Timetable> timetables = new ArrayList<>();
        List<Episodes> episodes = new ArrayList<>();
        List<Notification> notifications = notificationRepository.findAllByEmail(email);
        Timestamp date = new Timestamp(System.currentTimeMillis() - 2 * 24 * 60 * 60 * 1000);
        Timestamp date2 = new Timestamp(System.currentTimeMillis() + 24 * 60 * 60 * 1000);


        for (Notification notification : notifications) {
            episodes.addAll(episodesRepository.findAllBySeriesIdAndDateAfterAndDateBefore(notification.getSeries().getId(), date, date2));
        }
        return getTimetables(timetables, episodes);
    }

    public List<Timetable> getTimetables(List<Timetable> timetables, List<Episodes> episodes) {
        Collections.sort(episodes);
        for (Episodes s : episodes) {
            Timetable timetable = new Timetable();
            timetable.setSeriesId(s.getSeriesId());
            timetable.setSeriesName(seriesRepository.findById(s.getSeriesId()).get().getName());
            timetable.setEpisodesNumber(s.getNumber());
            timetable.setEpisodesSeason(s.getSeason());
            timetable.setEpisodesDate(s.getDate());
            timetable.setEpisodeId(s.getId());
            timetable.setEpisodeName(s.getName());
            timetable.setImage(seriesRepository.findById(s.getSeriesId()).get().getImage());
            timetables.add(timetable);
        }

        return timetables;
    }


}
