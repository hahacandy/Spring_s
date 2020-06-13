package com.jslhrd.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.jslhrd.domain.BoardVO;
import com.jslhrd.domain.PageVO;
import com.jslhrd.mapper.BoardMapper;
import com.jslhrd.util.ThubanCookie;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

	private BoardMapper mapper;
	
	//보드리스트 전체카운트
	@Override
	public int getBoardCount() {
		return mapper.getBoardCount();
	}
	//보드리스트 전체 리스트
	@Override
	public List<BoardVO> getBoardList(PageVO vo) {
		return mapper.getBoardList(vo);
	}
	
	//검색 보드리스트 갯수
	@Override
	public int getSearchBoardCount(PageVO vo) {
		return mapper.getSearchBoardCount(vo);
	}
	//검색 보드리스트 가져오기
	@Override
	public List<BoardVO> getSearchBoardList(PageVO vo) {
		return mapper.getSearchBoardList(vo);
	}
	
	//보드 쓰기
	@Override
	public int writeBoard(BoardVO vo) {
		return mapper.writeBoard(vo);
	}
	//한개의 보드 보기
	@Override
	public BoardVO getBoard(int idx) {
		return mapper.getBoard(idx);
	}
	//보드 조회수 1 추가하기
	@Override
	public int addReadCnt(int idx, HttpServletRequest request, HttpServletResponse response) {
		//해당 게시물에 대해 조회수1 올리고, 24시간이내의 조회수 증가 방지
		if(!ThubanCookie.isCookieSet(request, response, "boardCnt", "B"+idx, 60*60*24)) {
			return mapper.addReadCnt(idx);
		}
		return 0;
	}
	
	//보드 수정
	@Override
	public int modifyBoard(BoardVO vo) {
		return mapper.modifyBoard(vo);
	}
	
	//보드 삭제
	@Override
	public int deleteBoard(BoardVO vo) {
		return mapper.deleteBoard(vo);
	}

}
