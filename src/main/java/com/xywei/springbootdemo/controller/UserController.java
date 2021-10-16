package com.xywei.springbootdemo.controller;

import com.xywei.springbootdemo.domain.Address;
import com.xywei.springbootdemo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @Author future
 * @DateTime 2021/10/7 18:10
 * @Description
 */
@Validated
@RestController
public class UserController {

    @Lazy
    @Autowired
    private Address address;

    @Autowired
    private HttpServletRequest request;

    @GetMapping("/test")
    public String test(@NotBlank(message = "test的id不能是空的啊！！") String id, @NotBlank(message = "username不能空") String username) {

        return "id:" + id;
    }

    @PostMapping("/test2")
    public String test2(@NotBlank(message = "test2的id不能是空的啊！！post") String id) {

        return "id:" + id;
    }

    @PostMapping("/getUser")
    public String getUser(@Valid @RequestBody List<User> user) {
        System.out.println("user: "+user);
        System.out.println(user.get(0).getCountry());
        System.out.println(user.get(0).getCountry()== User.Country.CN);
        address.test();
        return "user:" + user;
    }

    @PostMapping("/getUser2")
    public String getUser2(@Validated User user) {

        return "user:" + user;
    }

    @GetMapping("/h1")
    public String testHeader1(@RequestParam String h1) {
        return h1;
    }

    @GetMapping("/h2")
    public String testHeader1() {
        return request.getHeader("h2");
    }

}
