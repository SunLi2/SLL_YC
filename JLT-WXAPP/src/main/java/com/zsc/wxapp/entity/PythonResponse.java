package com.zsc.wxapp.entity;

import java.util.List;
//
//public class PythonResponse {
//    private List<Object> res;
//    private List<Object> res_lose_tag;
//
//    // Getters and Setters
//    public List<Object> getRes() {
//        return res;
//    }
//
//    public void setRes(List<Object> res) {
//        this.res = res;
//    }
//
//    public List<Object> getRes_lose_tag() {
//        return res_lose_tag;
//    }
//
//    public void setRes_lose_tag(List<Object> res_lose_tag) {
//        this.res_lose_tag = res_lose_tag;
//    }
//}


public class PythonResponse {
    private List<List<String>> res; // 应该是 List<List<String>>
    private List<String> res_lose_tag; // 应该是 List<String>

    // Getters and Setters
    public List<List<String>> getRes() {
        return res;
    }

    public void setRes(List<List<String>> res) {
        this.res = res;
    }

    public List<String> getRes_lose_tag() {
        return res_lose_tag;
    }

    public void setRes_lose_tag(List<String> res_lose_tag) {
        this.res_lose_tag = res_lose_tag;
    }
}
