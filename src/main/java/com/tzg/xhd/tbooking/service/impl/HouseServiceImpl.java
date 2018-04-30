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
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service("HouseService")
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
    public List<HotelRecordVO> selectByUser(User user) {
        House house = new House();
        house.setUserId(user.getId());
        List<House> houses = houseMapper.select(house);
        List<HotelRecordVO> hotelRecordVOS = new ArrayList<>();
        for(House house1 : houses){
            HotelRecordVO hotelRecordVO = createVO(house1);
            hotelRecordVOS.add(hotelRecordVO);
        }
        return hotelRecordVOS;
    }

    private HotelRecordVO createVO(House house) {
        Hotel hotel = hotelService.selectById(house.getHouseId());
        HotelRecordVO hotelRecordVO = new HotelRecordVO();
        BeanUtils.copyProperties(house,hotelRecordVO);
        hotelRecordVO.setHotelName(hotel.getName());
        return hotelRecordVO;
    }

}
