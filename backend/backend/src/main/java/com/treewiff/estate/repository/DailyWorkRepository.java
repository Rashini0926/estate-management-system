package com.treewiff.estate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.treewiff.estate.model.DailyWork;
import java.time.LocalDate;
import java.util.List;

public interface DailyWorkRepository extends JpaRepository<DailyWork, Long> {
    List<DailyWork> findByDateBetween(LocalDate start, LocalDate end);
}
