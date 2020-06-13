package com.jslhrd.mapper;

import java.util.List;


import com.jslhrd.domain.BoardVO;
import com.jslhrd.domain.PageVO;

public interface BoardMapper {
	
	//보드리스트 전체카운트
	public int getBoardCount();
	//보드리스트 전체 리스트
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
	public int addReadCnt(int idx);
	
	//보드 수정
	public int modifyBoard(BoardVO vo);
	
	//보드 삭제
	public int deleteBoard(BoardVO vo);
	
}
