package com.jslhrd.controller;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.resource.HttpResource;

import com.jslhrd.domain.BoardVO;
import com.jslhrd.domain.PageVO;
import com.jslhrd.service.BoardService;
import com.jslhrd.util.ThubanAutoPageButton;
import com.jslhrd.util.ThubanCookie;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("Board")
@AllArgsConstructor
public class BoardController {
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);

	private BoardService boardService;
	
	@GetMapping("board_list")
	public void boardList(Model model, PageVO vo) {
		
		String uri = "/Board/board_list";
		int allBoardCnt = boardService.getBoardCount();
		ThubanAutoPageButton autoPageButton = new ThubanAutoPageButton(uri, vo.getPage(), allBoardCnt, 10, 10, null, null);
		if(vo.getSearch() == null && vo.getKey() == null) {
			allBoardCnt = boardService.getBoardCount();
			autoPageButton = new ThubanAutoPageButton(uri, vo.getPage(), allBoardCnt, 10, 10, null, null);
		}else {
			allBoardCnt = boardService.getSearchBoardCount(vo);
			autoPageButton = new ThubanAutoPageButton(uri, vo.getPage(), allBoardCnt, 10, 10, vo.getSearch(), vo.getKey());
			model.addAttribute("search", vo.getSearch());
			model.addAttribute("key", vo.getKey());
		}

		vo.setEndPage(autoPageButton.getEndPost());
		vo.setStartPage(autoPageButton.getStartPost());
		
		if(vo.getSearch() == null && vo.getKey() == null) {
			model.addAttribute("list", boardService.getBoardList(vo));
		}else {
			model.addAttribute("list", boardService.getSearchBoardList(vo));
		}
		
		model.addAttribute("allCnt", allBoardCnt);
		model.addAttribute("currentCnt", autoPageButton.getCurrentPostCnt());
		model.addAttribute("allPage", autoPageButton.getAllPage());
		model.addAttribute("currentPage", autoPageButton.getCurrentPage());
		model.addAttribute("pageButton", autoPageButton.getPageButton());
		
		log.info("GET board_list()");
		
	}
	
	@GetMapping("board_write")
	public void boardWrite() {}
	
	@PostMapping("board_write")
	public String boardWritePro(BoardVO bVo) {
		log.info("글쓰기결과: " + boardService.writeBoard(bVo));
		return "redirect:board_list?page=1";
	}
	
	@GetMapping("board_view_hit")
	public String boardView(PageVO pVo, @RequestParam("idx") int idx, HttpServletRequest request, HttpServletResponse response) {
		
		//조회수 올림
		boardService.addReadCnt(idx, request, response);

		if(pVo.getSearch() == null || pVo.getKey() == null) {
			return "redirect:/Board/board_view?page="+pVo.getPage()+"&idx="+idx;
		}else {
			return "redirect:/Board/board_view?page="+pVo.getPage()+"&search="+pVo.getSearch()+"&key="+URLEncoder.encode(pVo.getKey())+"&idx="+idx;
		}
		
	}	
	@GetMapping("board_view")
	public void boardView(Model model, PageVO pVo, @RequestParam("idx") int idx) {
	
		model.addAttribute("vo", boardService.getBoard(idx));
		model.addAttribute("idx", idx);

	}
	
	@GetMapping("board_modify")
	public void boardModify(Model model, PageVO vo, @RequestParam("idx") int idx) {
		BoardVO board = boardService.getBoard(idx);
		board.setPass(""); //비밀번호가 보이지 않게 하기위함.
		model.addAttribute("board", board);
		model.addAttribute("idx", idx);
	}
	

	@PostMapping("board_modify")
	public String boardModifyPro(HttpServletRequest request, RedirectAttributes rttr, PageVO pVo, BoardVO bVo) {
		
		if(boardService.modifyBoard(bVo)>0) { //수정 성공
			
			if(pVo.getSearch() == null && pVo.getKey() == null) {//검색 안했을경우
				return "redirect:/Board/board_view?page="+pVo.getPage()+"&idx="+bVo.getIdx();
			}else {//검색해서 들어왔을 경우
				return "redirect:/Board/board_view?page="+pVo.getPage()+"&idx="+bVo.getIdx()+"&search="+pVo.getSearch()+"&key="+pVo.getKey();
			}
			
		}else { // 수정 실패
			rttr.addFlashAttribute("result", "false");
			return "redirect:"+request.getHeader("Referer");
		}

	}
	
	@GetMapping("board_delete")
	public void boardDelete(Model model, PageVO vo, @RequestParam("idx") int idx) {
		model.addAttribute("idx", idx);
	}
	@PostMapping("board_delete")
	public String boardDeletePro(HttpServletRequest request, RedirectAttributes rttr, PageVO pVo, BoardVO bVo) {

		//삭제 유무 true, false 반납함
		rttr.addFlashAttribute("result", boardService.deleteBoard(bVo)>0);
		return "redirect:"+request.getHeader("Referer");
	
	}

	
}
