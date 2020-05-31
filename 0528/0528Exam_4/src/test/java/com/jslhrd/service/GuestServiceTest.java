package com.jslhrd.service;

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
public class GuestServiceTest {
	@Setter(onMethod_=@Autowired)
	private GuestService service;
	
	
	/*
	@Test
	public void testService() {
		log.info("서비스 테스트: " + service);
		
		GuestVO vo = new GuestVO();
		
		vo.setName("정병");
		vo.setSubject("제목");
		vo.setContents("내용");
		service.insertGuestKey(vo);
		
		log.info("생성된 게시물의 번호: " + vo.getIdx());;
	}
	*/
	
	@Test
	public void testGetList() {
		service.getGuestList().forEach(vo -> log.info(vo));
	}
}
