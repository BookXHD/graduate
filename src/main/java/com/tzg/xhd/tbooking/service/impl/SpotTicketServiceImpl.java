package com.tzg.xhd.tbooking.service.impl;

import com.tzg.xhd.tbooking.common.AbstractService;
import com.tzg.xhd.tbooking.entity.SpotTicket;
import com.tzg.xhd.tbooking.mapper.SpotTicketMapper;
import com.tzg.xhd.tbooking.service.SpotTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("spotTicketService")
@Transactional
public class SpotTicketServiceImpl extends AbstractService<SpotTicket> implements SpotTicketService {
    @Autowired
    private SpotTicketMapper spotTicketMapper;
}
