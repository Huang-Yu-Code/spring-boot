package com.example.elasticsearch.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

/**
 * 项目: Elasticsearch
 * 时间: 2022/5/7 11:41
 *
 * @author 黄宇
 * @version 1.0.0
 * @since JDK1.8
 */
@Configuration
public class ElasticsearchConfig extends AbstractElasticsearchConfiguration {
    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {
        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo("server:9200")
                .build();
        return RestClients.create(clientConfiguration).rest();
    }
}
