package com.lei.common.service;

import com.lei.common.entity.LibSeat;

import java.util.List;

public interface LibSeatService {
    List<LibSeat> getAllSeat(Integer floor,Integer number);

    List<LibSeat> searchSeat(Integer floor, Integer parity, Integer number);

    boolean selectSeat(Integer id, String user, String begin, String end);
}
