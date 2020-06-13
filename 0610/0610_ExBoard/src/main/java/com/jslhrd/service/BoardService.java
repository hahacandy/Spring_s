package com.jslhrd.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.domain.BoardVO;
import com.jslhrd.domain.PageVO;

public interface BoardService {
	
	//일반 보드리스트 갯수
	public int getBoardCount();
	//일반 보드리스트 가져오기
	public List<BoardVO> getBoardList(PageVO vo);
	
	//검색 보드리스트 갯수
	public int getSearchBoardCount(PageVO vo);
	//검색 보드리스트 가져오기
	public List<BoardVO> getSearchBoardList(PageVO vo);
	
	//보드 쓰기
	public int writeBoard(BoardVO vo);
	
	//한개의 보드 보기
	public BoardVO getBoard(int idx);
	//보드 조회수 1 추가하기
	public int addReadCnt(int idx, HttpServletRequest request, HttpServletResponse response);
	
	//보드 수정
	public int modifyBoard(BoardVO vo);
	
	//보드 삭제
	public int deleteBoard(BoardVO vo);
	
}
