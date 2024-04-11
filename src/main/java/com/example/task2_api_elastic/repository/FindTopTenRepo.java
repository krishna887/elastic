package com.example.task2_api_elastic.repository;

import com.example.task2_api_elastic.model.SampleData;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FindTopTenRepo {
    List<SampleData> findTop10BybCTOrderByNegRDesc();
}
