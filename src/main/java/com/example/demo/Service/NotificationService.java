package com.example.demo.Service;

import com.example.demo.Entity.Notification;
import com.example.demo.Entity.Series;
import com.example.demo.Repository.NotificationRepository;
import com.example.demo.Repository.EpisodesRepository;
import com.example.demo.Repository.SeriesRepository;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final EpisodesRepository episodesRepository;
    private final SeriesRepository seriesRepository;

    public NotificationService(NotificationRepository notificationRepository, EpisodesRepository episodesRepository, SeriesRepository seriesRepository) {
        this.notificationRepository = notificationRepository;
        this.episodesRepository = episodesRepository;
        this.seriesRepository = seriesRepository;
    }

    public Boolean add(Integer id, String email){
        Series series = seriesRepository.findById(id).get();
        Notification notification = new Notification();
        notification.setEmail(email);
        notification.setSeries(series);
        notificationRepository.save(notification);

        return true;
    }

    public Boolean remove(Integer id, String email){
        Series series = seriesRepository.findById(id).get();
        notificationRepository.delete(notificationRepository.findByEmailAndSeries(email, series));

        return true;
    }

    public Boolean isIn(Integer id, String email){
        Series series = seriesRepository.findById(id).get();
        Notification notification = notificationRepository.findByEmailAndSeries(email, series);

        if (notification != null)
            return true;
        return false;
    }
}
