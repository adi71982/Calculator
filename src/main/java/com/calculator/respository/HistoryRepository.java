package com.calculator.respository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.calculator.entity.History;

@Repository
public interface HistoryRepository extends CrudRepository<History, Long>{
    List<History> findAll();
}
