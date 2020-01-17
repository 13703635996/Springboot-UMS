package com.lei.common.mapper;

import com.lei.common.entity.LibSeat;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "LibSeatMapper")
public interface LibSeatMapper {
    List<LibSeat> getAllSeat(Integer floor,Integer number);

    List<LibSeat> searchSeat(Integer floor, Integer parity, Integer number);
}
