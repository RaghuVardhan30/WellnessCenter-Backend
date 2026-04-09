package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.entity.WellnessData;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.WellnessRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class WellnessService {

    private final WellnessRepository wellnessRepository;
    private final UserRepository userRepository;

    public WellnessService(WellnessRepository wellnessRepository, UserRepository userRepository) {
        this.wellnessRepository = wellnessRepository;
        this.userRepository = userRepository;
    }

    public List<WellnessData> getUserData(Long userId) {
        return wellnessRepository.findByUser_Id(userId);
    }

    public WellnessData saveOrUpdateData(WellnessData data) {
        Long userId = data.getUser().getId();
        LocalDate date = data.getDate();

        WellnessData existing = wellnessRepository.findByUser_IdAndDate(userId, date).orElse(null);

        if (existing != null) {
            existing.setScore(data.getScore());
            existing.setSleepHours(data.getSleepHours());
            existing.setHydration(data.getHydration());
            existing.setEnergy(data.getEnergy());
            existing.setActivity(data.getActivity());
            return wellnessRepository.save(existing);
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        data.setUser(user);
        return wellnessRepository.save(data);
    }
}