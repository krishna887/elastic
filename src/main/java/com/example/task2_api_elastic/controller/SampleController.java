package com.example.task2_api_elastic.controller;

import com.example.task2_api_elastic.model.SampleData;
import com.example.task2_api_elastic.repository.FindTopTenRepo;
import com.example.task2_api_elastic.repository.SampleRepository;
import com.example.task2_api_elastic.service.SampleService;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.springframework.web.bind.annotation.PostMapping;
import com.opencsv.bean.CsvToBean;
@RestController
@RequestMapping("/api/sample")
public class SampleController {

private final SampleService sampleService;

    @Autowired
    public SampleController(SampleService sampleService) {

        this.sampleService = sampleService;
    }

    @GetMapping("/top10cpt")
    public List<SampleData> getTop10CPTByCost() {
        return sampleService.getTop10CPTByCost();
    }
}