package com.example.demo.Repository;

import com.example.demo.Entity.Episodes;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface EpisodesRepository extends CrudRepository<Episodes, Integer> {

   /* List<Episodes> findAllBySeriesIdAndDateAfter(Integer id, Date date);*/
    List<Episodes> findAllBySeriesIdAndDateAfterAndDateBefore(Integer id, Date date,Date date2);
}
