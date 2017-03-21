package com.example.demo.service;

import com.example.demo.bean.Hotel;
import com.example.demo.mapper.HotelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lin on 2017/3/21.
 */
@Service
public class HotelService {

    @Autowired
    private HotelMapper hotelMapper;

    public Hotel findHotel() {
        return hotelMapper.findHotel();
    }
}
