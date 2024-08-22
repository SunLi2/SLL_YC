package com.zsc.wxapp.exservices;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

import static com.zsc.wxapp.exservices.ApiHeader.sha256;

@Service
public class Process {
    String token = "3f140ab21cca4ae99d6a04a1b74d8c4f";
    String paasid = "ap24113BJU7B";

    String Cigarette_ServiceCode = "sv24130Y783I";    // 卷烟信息采集表服务编码
    String Circulation_Pricing_ServiceCode = "sv24130Y783I";

    @Autowired
    RestTemplate restTemplate;
    String Testing_Data_IP = "https://10.76.236.155:8443/GatewayMsg/http/api/proxy/invoke";
    String Production_Data_IP = "https://10.76.241.22:8443/GatewayMsg/http/api/proxy/invoke";


    @Data
    class DsmResponseBody {
        private Integer errcode;
        private String errmsg;
        private DataList data;
    }

    @Data
    class DataList {
        private JSONArray data;
        private JSONObject metadata;

    }

    public void executeRequest() throws Exception {

//        String paasid = "paasid"; //网关用户 paasid
//        String token = "token"; //网关用户 token
        String serviceId = "serviceId";//接口唯一标识
        serviceId = Cigarette_ServiceCode;
        String nonce = UUID.randomUUID().toString().replace("-", "");
        String timestamp =
                String.valueOf(System.currentTimeMillis() / 1000);
        String authorization = timestamp + token + nonce + timestamp;
        String signature = sha256(authorization);
        //组装请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-dsp-paasid", paasid);
        headers.set("x-dsp-timestamp", timestamp);
        headers.set("x-dsp-nonce", nonce);
        headers.set("x-dsp-signature", signature);
        headers.set("x-dsp-serviceId", serviceId);
        //组装 serviceId 接口请求

        String content = "{\n"
                + "  \"system_id\": \"10\",\n"
                + "  \"vender_id\": \"10\",\n"
                + "  \"department_id\": \"10\",\n"
                + "  \"query_timestamp\": \"12345678\",\n"
                + "  \"UID\": \"AWSDEQJSJOAJD\",\n"
                + "  \"query\": {\n"
                + "    \"xxx\": \"xxx\"\n"
                + "  },\n"
                + "  \"audit_info\": {\n"
                + "    \"operator_id\": \"xx\",\n"
                + "    \"operator_name\": \"1\",\n"
                + "    \"query_object_id\": \"xx\",\n"
                + "    \"query_object_id_type\": \"01\",\n"
                + "    \"item_id\": \"2\",\n"
                + "    \"item_code\": \"2\",\n"
                + "    \"item_sequence\": \"3\",\n"
                + "    \"terminal_info\": \"1\",\n"
                + "    \"query_timestamp\": \"1\"\n"
                + "  },\n"
                + "  \"metadata\": {}\n"
                + "}";

        HttpEntity<String> request = new HttpEntity<>(content, headers);

        ResponseEntity<DsmResponseBody> result;

        try {//发出 post 请求

            result = restTemplate.postForEntity(Testing_Data_IP, request, DsmResponseBody.class);
        } catch (ResourceAccessException e) {
            throw new Exception("接口超时");
        }
        System.out.println(result.getStatusCode()); //打印 http 返回码
        System.out.println(result.getBody()); //打印响应体 }

    }
}

