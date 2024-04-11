package com.example.task2_api_elastic.service;

import com.example.task2_api_elastic.controller.SampleController;
import com.example.task2_api_elastic.model.SampleData;
import com.example.task2_api_elastic.repository.FindTopTenRepo;
import com.example.task2_api_elastic.repository.SampleRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
public class SampleService {

private final SampleRepository sampleRepository;
    private final FindTopTenRepo findTopTenRepo;
    @Autowired
    public SampleService(SampleRepository sampleRepository, FindTopTenRepo findTopTenRepo) {
        this.sampleRepository = sampleRepository;
        this.findTopTenRepo = findTopTenRepo;

    }

    public List<SampleData> getTop10CPTByCost() {
        return findTopTenRepo.findTop10BybCTOrderByNegRDesc();
    }

    public void uploadFile() throws IOException {
        File file = new File("/home/zakipoint/IdeaProjects/task2_api_elastic/src/main/java/com/example/task2_api_elastic/output/merged.csv");
        FileInputStream fis = new FileInputStream(file);
        Reader reader = new InputStreamReader(fis);

        CsvToBean<SampleData> csvToBean = new CsvToBeanBuilder<SampleData>(reader)
                .withType(SampleData.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        List<SampleData> samples = csvToBean.parse();

        int chunkSize = 100000; // Adjust this value based on your needs
        for (int i = 0; i < samples.size(); i += chunkSize) {
            List<SampleData> chunk = samples.subList(i, Math.min(samples.size(), i + chunkSize));
            sampleRepository.saveAll(chunk);
        }
    }
}
