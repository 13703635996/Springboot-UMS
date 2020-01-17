package com.lei.common.service.serviceImpl;

import com.lei.common.entity.LibSeat;
import com.lei.common.mapper.LibSeatMapper;
import com.lei.common.service.LibSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibSeatServiceImpl implements LibSeatService {
    @Autowired
    private LibSeatMapper libSeatMapper;

    @Override
    public List<LibSeat> getAllSeat(Integer floor, Integer number) {
        return libSeatMapper.getAllSeat(floor, number);
    }

    @Override
    public List<LibSeat> searchSeat(Integer floor, Integer parity, Integer number) {
        return libSeatMapper.searchSeat(floor, parity, number);
    }
}
