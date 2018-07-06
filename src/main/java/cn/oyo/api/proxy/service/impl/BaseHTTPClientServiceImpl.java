package cn.oyo.api.proxy.service.impl;

import cn.oyo.api.proxy.service.BaseHTTPClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Service
public class BaseHTTPClientServiceImpl implements BaseHTTPClientService {

    //TODO: Use Utils instead of extending client every time

    @Autowired
    private RestTemplate restTemplate;

    private HttpHeaders headers;

    BaseHTTPClientServiceImpl() {
        headers = new HttpHeaders();
    }

    @Override
    public HttpEntity<String> get(String url) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, entity, String.class);
    }

    @Override
    public HttpEntity<String> get(String url, Map<String, Object> params) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        for (String key : params.keySet()) {
            builder.queryParam(key, params.get(key));
        }
        System.out.println(builder.build().encode().toUri());
        HttpEntity<?> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, entity, String.class);
    }


    public HttpEntity<String> put(String url, Map<String,Object> body){
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        HttpEntity<?> entity = new HttpEntity<>(body,headers);
        return restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.PUT,entity,String.class);
    }

    public HttpEntity<String> post(String url, Map<String,Object> body){
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        HttpEntity<?> entity = new HttpEntity<>(body,headers);
        return restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.POST,entity,String.class);
    }

    public void setHeaders(String headerName, String headerValue) {
        this.headers.set(headerName, headerValue);
    }

    public HttpHeaders getHeaders() {
        return this.headers;
    }


}
