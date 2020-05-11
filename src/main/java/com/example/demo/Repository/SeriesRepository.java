package com.example.demo.Repository;

import com.example.demo.Entity.Series;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SeriesRepository extends CrudRepository<Series, Integer> {

    List<Series> findAllByIdIsAfterOrderByRatingDesc(Integer id);
    List<Series> findAllByNameIsLike(String name);
    Series findByNameOrderByDateAsc(String name);
}
