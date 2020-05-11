package com.example.demo.Repository;

import com.example.demo.Entity.Notification;
import com.example.demo.Entity.Series;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NotificationRepository extends CrudRepository<Notification, Integer> {

    Notification findByEmailAndSeries(String email, Series series);
    List<Notification> findAllByEmail(String email);
}

