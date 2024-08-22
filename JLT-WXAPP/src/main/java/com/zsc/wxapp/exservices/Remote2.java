package com.zsc.wxapp.exservices;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zsc.wxapp.clients.RemotePriceInfoClient;
import com.zsc.wxapp.entity.external.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class Remote2 {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RemotePriceInfoClient remotePriceInfoClient;
    private static final String URL = "http://localhost:8082/api/pricetags/getPriceTagsByNamesss";

    public List<Product> getPriceByNames(List<String> names) {
        try {
            String requestJson = new ObjectMapper().writeValueAsString(names);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> requestEntity = new HttpEntity<>(requestJson, headers);
            ResponseEntity<Product[]> responseEntity = restTemplate.exchange(
                    URL,
                    HttpMethod.POST,
                    requestEntity,
                    Product[].class
            );
            Product[] response = responseEntity.getBody();
            return Arrays.asList(response);
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
    private static final String URL_getPriceOverview = "http://localhost:8082/api/pricetags/getPriceOverview";
    public List<PriceOverview> getPriceOverview() {
//        return  remotePriceInfoClient.getPriceOverview();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<?> requestEntity = new HttpEntity<>(headers);

        // 设置请求头，例如设置内容类型为application/json
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 发送POST请求并接收响应
        ResponseEntity<PriceOverview[]> responseEntity = restTemplate.exchange(
                URL_getPriceOverview,
                HttpMethod.GET, // 使用HTTP POST方法
                requestEntity,
                PriceOverview[].class   // 期望的响应体类型
        );

        // 打印响应状态码
        System.out.println("Response Status Code: " + responseEntity.getStatusCode());

        // 检查响应状态码是否表示成功
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            // 处理成功的响应，例如打印响应体
            PriceOverview[] priceOverviewArrays  = responseEntity.getBody();
//            for (priceOverview priceOverviewArray  : priceOverviewArrays ) {
//                System.out.println(priceOverviewArray ); // 假设Product类有toString方法
//            }
            return Arrays.asList(priceOverviewArrays);
        } else {
            // 处理错误响应
            System.out.println("Failed to get response, status code: " + responseEntity.getStatusCode());
            return null;
        }
    }

    public CustomerInfo getCustomerByCustUuid(String custUuid) {
        try {
            String URL = "http://localhost:8082/api/customers/getByCustUuid";

            String requestJson = new ObjectMapper().writeValueAsString(custUuid);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> requestEntity = new HttpEntity<>(requestJson, headers);
            ResponseEntity<CustomerInfo> responseEntity = restTemplate.exchange(
                    URL,
                    HttpMethod.POST,
                    requestEntity,
                    CustomerInfo.class
            );
            CustomerInfo response = responseEntity.getBody();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public CustomerInfo_2 getCustomerByCustUuid_2(String custUuid) {
        try {
            String URL = "http://localhost:8082/api/customers/getByCustUuid_2";

            String requestJson = new ObjectMapper().writeValueAsString(custUuid);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> requestEntity = new HttpEntity<>(requestJson, headers);
            ResponseEntity<CustomerInfo_2> responseEntity = restTemplate.exchange(
                    URL,
                    HttpMethod.POST,
                    requestEntity,
                    CustomerInfo_2.class
            );
            CustomerInfo_2 response = responseEntity.getBody();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<SalesSummary> getSalesSummaryByCustUuid(String custUuid) {
        try {
            String URL = "http://localhost:8082/api/customers/getOrderByCustUuid";

            String requestJson = new ObjectMapper().writeValueAsString(custUuid);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> requestEntity = new HttpEntity<>(requestJson, headers);
            ResponseEntity<SalesSummary[]> responseEntity = restTemplate.exchange(
                    URL,
                    HttpMethod.POST,
                    requestEntity,
                    SalesSummary[].class
            );
            SalesSummary[] response = responseEntity.getBody();
            return Arrays.asList(response);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public CustomerDetails getCustomerDetailsCustUuid(String custUuid) {
        try {
            String URL = "http://localhost:8082/api/customers/getCustomerDetailsCustUuid";

            String requestJson = new ObjectMapper().writeValueAsString(custUuid);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> requestEntity = new HttpEntity<>(requestJson, headers);
            ResponseEntity<CustomerDetails> responseEntity = restTemplate.exchange(
                    URL,
                    HttpMethod.POST,
                    requestEntity,
                    CustomerDetails.class
            );
            CustomerDetails response = responseEntity.getBody();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
