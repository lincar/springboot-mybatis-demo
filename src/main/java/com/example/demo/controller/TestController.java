package com.example.demo.controller;

import com.example.demo.bean.Hotel;
import com.example.demo.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lin on 2017/3/21.
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private HotelService hotelService;

    @RequestMapping(value = "/hotel")
    public Object hotel() {
        System.out.println("in");
        return hotelService.findHotel();
    }

    @RequestMapping(value = "/jsp")
    public ModelAndView testJsp() {
        System.out.println("test jsp");
        return new ModelAndView("test");
    }
}
