package cn.oyo.api.proxy.service;

import org.springframework.http.HttpEntity;

import java.util.Map;

public interface BaseHTTPClientService {
    HttpEntity<String> get(String url);

    HttpEntity<String> get(String url, Map<String, Object> params);


}
