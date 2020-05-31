package com.jslhrd.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jslhrd.controller.HomeController;
import com.jslhrd.domain.GuestVO;
import com.jslhrd.mapper.GuestMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Service
@AllArgsConstructor
public class GuestServiceImpl implements GuestService{
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Setter(onMethod_=@Autowired)
	private GuestMapper mapper;
	
	@Override
	public List<GuestVO> getGuestList() {
		// TODO Auto-generated method stub
		return mapper.getGuestList();
	}
	@Override
	public int deleteGuest(int idx) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int guestCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int insertGuest(GuestVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int insertGuestKey(GuestVO vo) {
		// TODO Auto-generated method stub
		return mapper.insertGuestKey(vo);
	}
	@Override
	public int modifyGuest(GuestVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public GuestVO searchGuest(int idx) {
		// TODO Auto-generated method stub
		return null;
	}
}
