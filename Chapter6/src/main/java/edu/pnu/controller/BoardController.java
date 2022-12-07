package edu.pnu.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.pnu.domain.Board;
import edu.pnu.service.BoardService;

@Controller
public class BoardController {
	Random rd = new Random();

	@Autowired
	private BoardService boardService;

	// Model 객체는 컨트롤러에서 데이터를 생성해 이를 JSP 즉 View에 전달하는 역할을 합니다. ****HashMap**** 형태를 갖고 있고, 키(key)와, 밸류(value) 값을 저장합니다.  Servelt의 request.setAttribute()과 비슷한 역할을 한다고 알려져 있습니다.
	// 브라우저상으로 getBoardList 요청이 들어오면 실행되는 메소드
	@RequestMapping("/getBoardList")
	public String getBoardList(Model model, Board board) {
		List<Board> boardList = boardService.getBoardList(board);
		model.addAttribute("boardList", boardList);
		return "getBoardList";
	}

	@GetMapping("/insertBoard")
	public String InsertBoardView(Board board) {
		return "insertBoard";
	}

	// 요청에 의하여 DB에 변동이 있을때 사용
	@PostMapping("/insertBoard")
	public String InsertBoard(Board board) {
		boardService.insertBoard(board);
		return "redirect:getBoardList";
	}
	
	@GetMapping("/getBoard")
	public String getBoard(Board board, Model model) {
		model.addAttribute("board", boardService.getBoard(board));
		return "getBoard";
	}
	
	//특정 URL에 대하여 외부에 공개하지 않아야될 정보가 있을경우 사용됨
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
}
