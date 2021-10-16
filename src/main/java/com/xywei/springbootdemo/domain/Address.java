package com.xywei.springbootdemo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

/**
 * @Author future
 * @DateTime 2021/10/7 21:21
 * @Description
 */
@Component
@Data
public class Address {

    @JsonProperty("json_province")
    @JsonValue
    @NotNull(message = "省份不能空！address")
    private String province;

    private String city;

    private String street;

    @Autowired
    private HttpServletRequest request;

    public void test(){
        System.out.println(request);
    }
}
