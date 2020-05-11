package com.example.demo.Controller;

import com.example.demo.Entity.Series;
import com.example.demo.Service.SeriesService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series/*")
public class SeriesController {

    private final SeriesService seriesService;

    public SeriesController(SeriesService seriesService) {
        this.seriesService = seriesService;
    }

    @RequestMapping("getAll")
    public List<Series> getAll(){
        return seriesService.getAll();
    }

    @RequestMapping("getBySearch/{search}")
    public List<Series> getBySearch(@PathVariable("search")String search){
        return seriesService.getBySearch(search);
    }

    @RequestMapping("getById/{id}")
    public Series getById(@PathVariable("id")Integer id){
        return seriesService.getById(id);
    }

    @RequestMapping("getMy/{email}")
    public List<Series> getMy(@PathVariable("email")String email){
        return seriesService.getMy(email);
    }
}
