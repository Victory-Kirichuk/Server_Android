package com.example.demo.Controller;

import com.example.demo.Entity.Episodes;
import com.example.demo.Entity.Timetable;
import com.example.demo.Repository.EpisodesRepository;
import com.example.demo.Service.Converter;
import com.example.demo.Service.EpisodesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/episodes/*")
public class EpisodesController {

    private final EpisodesService episodesService;


   @Autowired
    public EpisodesController(EpisodesService episodesService) {
        this.episodesService = episodesService;

    }

    @RequestMapping("getEpById/{episodeId}")
    public Timetable getEpById(@PathVariable("episodeId")Integer episodeId){
        return episodesService.getTimeTableByEpisodeId(episodeId);
    }

    @RequestMapping("get/{seriesName}")
    public List<Episodes> get(@PathVariable("seriesName")String name){
        return episodesService.get(name);
    }

    @RequestMapping("timeTable/{email}")
    public List<Timetable> getTimeTable(@PathVariable("email")String email){
        return episodesService.getTimeTable(email);
    }

    @RequestMapping("timeTableToday/{email}")
    public List<Timetable> getTimeTableToday(@PathVariable("email")String email){
        return episodesService.getTimeTableToday(email);
    }
}
