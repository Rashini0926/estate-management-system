package com.treewiff.estate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.treewiff.estate.model.Rate;

public interface RateRepository extends JpaRepository<Rate, Long> {
    Optional<Rate> findByMonth(String month);
}
