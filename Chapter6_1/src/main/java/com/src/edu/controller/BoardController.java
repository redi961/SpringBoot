package com.src.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.src.edu.domain.Board;
import com.src.edu.domain.Member;
import com.src.edu.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	@RequestMapping("/getBoardList")
	public String getBoardList(Model model, Board board) {
		List<Board> boardList = boardService.getBoardList(board);

		model.addAttribute("boardList", boardList);
		return "getBoardList";
	}

	@GetMapping("insertBoard")
	public String insertBoardView() {
		return "insertBoard";
	}

	@PostMapping("insertBoard")
	public String insertBoard(Board board) {
		boardService.insertBoard(board);
		return "redirect:getBoardList";
	}

	@GetMapping("/getBoard")
	public String getBoard(Board board, Model model) {
		model.addAttribute("board", boardService.getBoard(board));
		return "getBoard";
	}

	@PostMapping("/updateBoard")
	public String updateBoard(Board board) {
		boardService.updateBoard(board);
		return "forward:getBoardList";
	}

	@GetMapping("/deleteBoard")
	public String deleteBoard(Board board) {
		boardService.deleteBoard(board);
		return "forward:getBoardList";
	}

	// spring.mvc.view.suffix=.jsp -> .jsp 를 자동으로 붙여줌
//	@GetMapping("/test1")
//	public String test1() {
//		return "test1";
//	}

	// @ResponseBody 문자열이 아닌 코드 그대로 반환
//	@GetMapping("/test1")
//	public @ResponseBody String test1() {
//		return "test1";
//	}

	// #spring.mvc.view.prefix=/WEB-INF/board/ -> 가 없는경우
//	@GetMapping("/test2")
//	public String test2() {
//		return "/WEB-INF/test2"; // 명시적으로 파일 위치 표현
//	}

	// #spring.mvc.view.prefix=/WEB-INF/board/ -> 가 있는경우

//	@GetMapping("/test3")// 이름이 같은 경우 생략 return 가능
//	public void test3() {
//	}

//	@RequestMapping("/getBoardList") // ResquestMapping = put,get,post 전부 가능
//	public String getBoardList(Model model) {
//		List<Board> boardList = new ArrayList<Board>();
//
//		for (int i = 1; i <= 10; i++) {
//			Board board = new Board();
//			board.setSeq(new Long(i));
//			board.setTitle("게시판 프로그램 테스트");
//			board.setWriter("도우너");
//			board.setContent("게시판 프로그램 테스트 입니다....");
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			boardList.add(board);
//		}
//		model.addAttribute("boardList", boardList);
//		return "getBoardList";
//	}

//	@RequestMapping("/getBoardList1") // ResquestMapping = put,get,post 전부 가능
//	public ModelAndView getBoardList1() {
//
//		ModelAndView mv = new ModelAndView();
//
//		List<Board> boardList = new ArrayList<Board>();
//
//		for (int i = 1; i <= 10; i++) {
//			Board board = new Board();
//			board.setSeq(new Long(i));
//			board.setTitle("게시판 프로그램 테스트");
//			board.setWriter("도우너");
//			board.setContent("게시판 프로그램 테스트 입니다....");
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			boardList.add(board);
//		}
//		mv.addObject("boardList", boardList);
//		mv.setViewName("getBoardList");
//		return mv;
//	}

}
