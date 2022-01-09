package com.item.common.rpc;

import com.item.common.utils.SpringContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

/**
 * 功能描述:
 *
 * @Auth: zhangXiaoKang
 * @Date: 2021-09-13
 */

@Slf4j
public class RestClient {
    /**
     *
     * @param url url
     * @param httpEntity httpEntity
     * @param clazz clazz
     * @param <T> T
     * @return T
     */
    public static <T> T postRequest(String url, HttpEntity<Object> httpEntity, Class<T> clazz) {
        RestTemplate restTemplate = SpringContextHolder.getBean(RestTemplate.class);
        try {
            return restTemplate.postForObject(url, httpEntity, clazz);
        } catch (Exception e) {
            log.error("post request error.msg:{}", e.getMessage());
            if (e instanceof RestClientResponseException) {
                RestClientResponseException responseException = (RestClientResponseException) e;
                int rawStatusCode = responseException.getRawStatusCode();
                String bodyAsString = responseException.getResponseBodyAsString();
                log.error("RPC response code is {}, body is {}", rawStatusCode, bodyAsString);
            }
            throw e;
        }
    }

    /**
     *
     * @param url url
     * @param object object
     * @param clazz clazz
     * @param <T> T
     * @return T
     */
    public static <T> T postForObject(String url, Object object, Class<T> clazz) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> httpEntity = new HttpEntity<>(object, httpHeaders);
        return postRequest(url,httpEntity,clazz);
    }
}
