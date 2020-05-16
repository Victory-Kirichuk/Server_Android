package com.example.demo.Repository;

import com.example.demo.Entity.Episodes;
import com.example.demo.Entity.Timetable;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface EpisodesRepository extends CrudRepository<Episodes, Integer> {
  /*  Timetable findTimeTableById (Integer episodeId);*/
    List<Episodes> findAllBySeriesIdAndDateAfter(Integer id, Date date);
    List<Episodes> findAllBySeriesIdAndDateAfterAndDateBefore(Integer id, Date date,Date date2);
}
