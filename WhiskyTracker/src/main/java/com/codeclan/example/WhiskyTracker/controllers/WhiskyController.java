package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/year/{year}")
    public List<Whisky> findAllWhiskyFromYear(@PathVariable int year){
        return whiskyRepository.findAllWhiskyFromYear(year);
    }

    @GetMapping(value = "/region/{region}")
    public List<Whisky> findAllWhiskyFromRegion(@PathVariable String region){
        return whiskyRepository.findAllWhiskyFromRegion(region);
    }

    @GetMapping(value = "/distillery/{distilleryName}/age/{age}")
    public List<Whisky> findAllWhiskyFromDistilleryOfAge(@PathVariable String distilleryName, @PathVariable int age){
        return whiskyRepository.findAllWhiskyFromDistilleryOfAge(distilleryName, age);
    }
}