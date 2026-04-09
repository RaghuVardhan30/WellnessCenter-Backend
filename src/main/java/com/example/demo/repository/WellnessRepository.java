package com.example.demo.repository;

import com.example.demo.entity.WellnessData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface WellnessRepository extends JpaRepository<WellnessData, Long> {

    List<WellnessData> findByUser_Id(Long userId);

    Optional<WellnessData> findByUser_IdAndDate(Long userId, LocalDate date);

    Optional<WellnessData> findTopByUser_IdOrderByIdDesc(Long userId);

	
}