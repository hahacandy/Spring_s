package com.jslhrd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.jslhrd.domain.GuestVO;

public interface GuestMapper {

	/*
	@Select("SELECT COUNT(*) FROM tbl_guest")
	public int guestCount();
	*/
	
	//게시물 총 개수
	public int guestCount();
	
	
	//전체 게시물을 검색(LIST)
	public List<GuestVO> getGuestList();
	

	// 등록
	public int insertGuest(GuestVO vo);
	public int insertGuestKey(GuestVO vo);
	
	
	// 특정 게시물 검색(view)
	public GuestVO searchGuest(int idx);
	
	
	//수정
	public int modifyGuest(GuestVO vo);
	
	
	//삭제
	public int deleteGuest(int idx);
}
