package com.example.demo.Controller;

import com.example.demo.Service.NotificationService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification/*")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @RequestMapping("add/{id}/{email}")
    public Boolean add(@PathVariable("id")Integer id, @PathVariable("email")String email){
        return notificationService.add(id, email);
    }

    @RequestMapping("remove/{id}/{email}")
    public Boolean remove(@PathVariable("id")Integer id, @PathVariable("email")String email){
        return notificationService.remove(id, email);
    }

    @RequestMapping("isIn/{id}/{email}")
    public Boolean isIn(@PathVariable("id")Integer id, @PathVariable("email")String email){
        return notificationService.isIn(id, email);
    }
}
