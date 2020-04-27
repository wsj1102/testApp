package com.bank.demo.controller;


import javax.servlet.http.HttpServletRequest;

import com.bank.demo.entity.Result;
import com.bank.demo.entity.TestEntity;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * MainController
 */

@Controller
@RequestMapping(value = { "/index" })
public class MainController {

    @RequestMapping(value = { "/index" }, method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
        
        request.setAttribute("map", "main");
        request.setAttribute("data", "data");

        return new String("/index/index");
    }

    @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
    @ResponseBody
    public String requestMethodName(HttpServletRequest request) {

        Gson gson = new Gson();
        TestEntity entity = new TestEntity();

        entity.setMap("main");
        entity.setMain("data");
        TestEntity entity1 = new TestEntity();

        entity1.setMap("main");
        entity1.setMain("data");

        entity.setEntity(entity1);

        return gson.toJson(entity);
    }

    @RequestMapping(value = { "/doLogin" }, method = RequestMethod.GET)
    @ResponseBody
    public String doLogin(HttpServletRequest request) {

        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("map", "main");
        jsonObject.addProperty("data", "data");

        return gson.toJson(jsonObject);
    }

    @RequestMapping(value = { "/doLogin" }, method = RequestMethod.POST)
    @ResponseBody
    public Result doSomething(HttpServletRequest request) {

        Result result = new Result();
        TestEntity entity = new TestEntity();

        entity.setMap("main");
        entity.setMain("data");

        result.setCode(0);
        result.setMsg("success");
        result.setData(entity);

        return result;
    }

    @RequestMapping(value = { "/doLogout" }, method = RequestMethod.POST)
    @ResponseBody
    public Result doElsething(HttpServletRequest request) {

        Result result = new Result();
        TestEntity entity = new TestEntity();

        entity.setMap("main");
        entity.setMain("data");

        result.setCode(0);
        result.setMsg("success");
        result.setData(entity);

        return result;
    }

}