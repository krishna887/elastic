package com.example.task2_api_elastic.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilders;
import com.example.task2_api_elastic.model.SampleData;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.elasticsearch.search.sort.SortBuilders.fieldSort;
@Repository
@RequiredArgsConstructor

public class FindTopTenRepoImpl implements FindTopTenRepo{

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<SampleData> findTop10BybCTOrderByNegRDesc() {
        SearchRequest searchRequest = new SearchRequest("sample");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.termQuery("bCT.keyword", "CPT"));
        sourceBuilder.sort(fieldSort("negR").order(org.elasticsearch.search.sort.SortOrder.DESC));
        sourceBuilder.size(10);

        searchRequest.source(sourceBuilder);

        SearchResponse searchResponse = null;
        try {
            searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<SampleData> result = new ArrayList<>();
        for (org.elasticsearch.search.SearchHit hit : searchResponse.getHits().getHits()) {
            SampleData myEntity = null;
            try {
                myEntity = objectMapper.readValue(hit.getSourceAsString(), SampleData.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            result.add(myEntity);
        }

        return result;
    }
}