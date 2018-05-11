package com.tzg.xhd.tbooking.service;

import com.tzg.xhd.tbooking.VO.HotelRecordVO;
import com.tzg.xhd.tbooking.common.BaseService;
import com.tzg.xhd.tbooking.entity.House;
import com.tzg.xhd.tbooking.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface HouseService extends BaseService<House> {

    /**
     * 调用东南向 的服务,把酒店订单数据同步到东南向的系统
     * @param house
     */
    void order(House house);

    /**
     * 获得该用户的所有酒店订单记录
     * @param userId
     * @param houseId
     * @return
     */
    List<HotelRecordVO> selectByUser(String userId,String houseId);

    /**
     * 获得该用户的所有酒店订单记录
     * @param userId
     * @param houseId
     * @return
     */
    Integer selectOrderCount(String userId,String houseId);
}
