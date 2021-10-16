package com.xywei.springbootdemo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NonNull;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @Author future
 * @DateTime 2021/10/7 18:09
 * @Description
 */
@Data
public class User {

    @JsonProperty("json_id")
    @NotNull(message = "id不能空")
    private String id;

    @JsonProperty("json_username")
    private String username;

    @JsonProperty("json_password")
    private String password;

    @Valid
    @NotNull(message = "地址不能空:user")
    @JsonProperty("json_address")
    private Address address;

    @NotNull(message = "国家不能空")
    @JsonProperty("json_country")
    private Country country;

    public enum Country{
        CN("小康社会"),
        USA("水深火热之国");
        private String value;
        Country(String value){
            this.value = value;
        }

        @Override
        public String toString() {
            return "Country{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }
}

