package com.jslhrd.domain;

import lombok.Data;

@Data
public class PageVO {

	private String search;
	private String key;
	
	private int startPage;
	private int endPage;
	
	private int page;
}
