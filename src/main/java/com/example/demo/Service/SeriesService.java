package com.example.demo.Service;

import com.example.demo.Entity.Notification;
import com.example.demo.Entity.Series;
import com.example.demo.Repository.NotificationRepository;
import com.example.demo.Repository.EpisodesRepository;
import com.example.demo.Repository.SeriesRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeriesService {

    private final NotificationRepository notificationRepository;
    private final EpisodesRepository episodesRepository;
    private final SeriesRepository seriesRepository;

    public SeriesService(NotificationRepository notificationRepository, EpisodesRepository episodesRepository, SeriesRepository seriesRepository) {
        this.notificationRepository = notificationRepository;
        this.episodesRepository = episodesRepository;
        this.seriesRepository = seriesRepository;
    }

    public List<Series> getAll() {
        return seriesRepository.findAllByIdIsAfterOrderByRatingDesc(0);
    }

    public List<Series> getBySearch(String search) {
        return seriesRepository.findAllByNameIsLike("%" + search + "%");
    }

    public Series getById(Integer id) {
        return seriesRepository.findSeriesById(id);
    }

    public List<Series> getMy(String email) {
        List<Notification> notifications = notificationRepository.findAllByEmail(email);
        List<Series> series = new ArrayList<>();
        for (Notification notification : notifications) {
            series.add(notification.getSeries());
        }
        Collections.sort(series);
        Collections.reverse(series);
        return series;
    }
}
