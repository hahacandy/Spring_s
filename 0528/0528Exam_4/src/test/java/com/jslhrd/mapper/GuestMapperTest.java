package com.jslhrd.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jslhrd.domain.GuestVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class GuestMapperTest {
	
	@Setter(onMethod_ = {@Autowired })
	private GuestMapper mapper;
	
	/*
	@Test
	public void testGuestCount() {
		log.info("guestCount: " + mapper.guestCount());
	}
	*/
	
	/*
	@Test
	public void testGetGuestList() {
		
		
		List<GuestVO> list = mapper.getGuestList();
		
		for(GuestVO vo : list) {
			log.info(vo);
		}

		for(int i=0; i<list.size(); i++) {
			log.info(list.get(i));
		}
		
		
		mapper.getGuestList().forEach(vo ->{
			log.info(vo);
		});
		 
	}
	*/
	
	/*
	@Test
	public void testInsertGuest() {
		GuestVO vo = new GuestVO();
		
		vo.setName("홍길동5");
		vo.setSubject("홍길동제목테스트5");
		vo.setContents("홍길동내용테스트5");
		
		log.info("testInsertGuest(): " + mapper.insertGuest(vo));
	}
	*/
	
	/*
	@Test
	public void testInsertGuestKey() {
		GuestVO vo = new GuestVO();
		
		vo.setName("홍길동6");
		vo.setSubject("홍길동제목테스트6");
		vo.setContents("홍길동내용테스트6");
		
		mapper.insertGuestKey(vo);
		
		log.info("여기:" + vo);
		
	}
	*/
	
	/*
	@Test
	public void testGetVO() {
		GuestVO vo = mapper.searchGuest(246);
		log.info(vo);
	}
	*/
	
	/*
	@Test
	public void testModifyGuest() {
		GuestVO vo = new GuestVO();
		
		vo.setIdx(246);
		vo.setName("정병찬");
		vo.setSubject("정병찬 제목2");
		vo.setContents("정병찬 내용2");
		
		int row = mapper.modifyGuest(vo);
		log.info("row: " + row);
	}
	*/
	
	@Test
	public void testDeleteGuest() {
		log.info("delete: " + mapper.deleteGuest(246));
	}
	
}
