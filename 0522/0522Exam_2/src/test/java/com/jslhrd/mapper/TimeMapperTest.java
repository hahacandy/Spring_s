package com.jslhrd.mapper;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

@Log4j
public class TimeMapperTest {
	@Inject
	private TimeMapper timeMapper;
	
	@Test
	public void testGetTime() {
		log.info("Test Time : " + timeMapper.getTime());
	}
	
	@Test
	public void testGetTime2() {
		log.info("Test Time2 : " + timeMapper.getTime2());
	}
}
