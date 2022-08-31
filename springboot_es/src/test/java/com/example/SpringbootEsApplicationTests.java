package com.example;

import com.example.mapper.TUserMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.client.*;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;


@SpringBootTest
class SpringbootEsApplicationTests {
//    @Autowired
//    private ElasticsearchRestTemplate ert;

//    高版本的客户端不能Autowired，只能自己编码
    private RestHighLevelClient client;
    @Test
    public void testES() throws IOException {
        HttpHost host=HttpHost.create("http://localhost:9200");
        RestClientBuilder builder= RestClient.builder(host);
        client=new RestHighLevelClient(builder);
        //创建索引
        CreateIndexRequest request=new CreateIndexRequest("books");
        client.indices().create(request, RequestOptions.DEFAULT);


        //必须关闭
        client.close();
    }


}
