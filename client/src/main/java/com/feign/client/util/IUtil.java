package com.feign.client.util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "feignClient", url = "http://localhost:8080/api")
public interface IUtil {

    @GetMapping(value = "/getAll-users")
    String getAllUsers();

}
