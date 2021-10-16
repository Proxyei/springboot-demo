package com.xywei.springbootdemo.http;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author future
 * @DateTime 2021/10/7 23:06
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseResult<T> {
    private int status;
    private String message;
    private T data;
}
