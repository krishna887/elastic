package com.example.task2_api_elastic.repository;
import com.example.task2_api_elastic.model.SampleData;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SampleRepository extends ElasticsearchRepository<SampleData, String>{
}
