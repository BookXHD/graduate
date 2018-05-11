package com.tzg.xhd.tbooking.service.impl;

import com.tzg.xhd.eastnan.entity.Hotel;
import com.tzg.xhd.eastnan.entity.HotelRecord;
import com.tzg.xhd.eastnan.service.HotelRecordService;
import com.tzg.xhd.eastnan.service.HotelService;
import com.tzg.xhd.tbooking.VO.HotelRecordVO;
import com.tzg.xhd.tbooking.common.AbstractService;
import com.tzg.xhd.tbooking.entity.House;
import com.tzg.xhd.tbooking.entity.User;
import com.tzg.xhd.tbooking.mapper.HouseMapper;
import com.tzg.xhd.tbooking.service.HouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("HouseService")
@Slf4j
@Transactional
public class HouseServiceImpl extends AbstractService<House> implements HouseService {
    @Autowired
    private HouseMapper houseMapper;

    @Autowired
    private HotelRecordService hotelRecordService;

    @Autowired
    private HotelService hotelService;

    @Override
    public void order(House house) {
        HotelRecord hotelRecord = new HotelRecord();
        BeanUtils.copyProperties(house,hotelRecord);
        hotelRecordService.insert(hotelRecord);
    }

    @Override
    public List<HotelRecordVO> selectByUser(String userId,String houseId) {
        House house = new House();
        house.setUserId(Integer.parseInt(userId));
        Map<String, Object> map = new HashMap<>();
        List<HotelRecordVO> hotelRecordVOS = new ArrayList<>();
        try {
            map.put("userId", userId);
            map.put("houseId", houseId);
            List<House> houses = houseMapper.selectOrder(map);
            for (House house1 : houses) {
                HotelRecordVO hotelRecordVO = createVO(house1);
                hotelRecordVOS.add(hotelRecordVO);
            }
        }catch (Exception e) {
            log.error("HouseServiceImpl selectByUser");
        }
        return hotelRecordVOS;
    }

    @Override
    public Integer selectOrderCount(String userId,String houseId) {
        Map<String, Object> map = new HashMap<>();
        Integer count = 0;
        try {
            map.put("userId", userId);
            map.put("houseId", houseId);
            count = houseMapper.selectOrderCount(map);
        }catch (Exception e) {
            log.error("HouseServiceImpl selectByUser");
        }
        return count;
    }

    private HotelRecordVO createVO(House house) {
        Hotel hotel = hotelService.selectById(house.getHouseId());
        HotelRecordVO hotelRecordVO = new HotelRecordVO();
        BeanUtils.copyProperties(house,hotelRecordVO);
        hotelRecordVO.setHotelName(hotel.getName());
        return hotelRecordVO;
    }

}
