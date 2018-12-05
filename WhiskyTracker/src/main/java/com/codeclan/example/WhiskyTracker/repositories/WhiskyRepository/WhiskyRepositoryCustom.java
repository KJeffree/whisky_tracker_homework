package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;

import java.util.List;

public interface WhiskyRepositoryCustom {

    List<Whisky> findAllWhiskyFromYear(int year);

    List<Whisky> findAllWhiskyFromRegion(String region);

    List<Whisky> findAllWhiskyFromDistilleryOfAge(String distillaryName, int age);
}
