package com.lei.common.service.serviceImpl;

import com.lei.common.entity.LibSeat;
import com.lei.common.mapper.LibSeatMapper;
import com.lei.common.service.LibSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @Override
    public boolean selectSeat(Integer id, String user, String begin, String end) {
        return libSeatMapper.selectSeat(id, user, begin, end);
    }

    // 轮询释放座位
    @Scheduled(cron = "0 */5 * * * ?")
    public void releaseSeat() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("HH:mm:ss");
        String nowTime = format.format(date);
        libSeatMapper.releaseSeat(nowTime);
    }

}
