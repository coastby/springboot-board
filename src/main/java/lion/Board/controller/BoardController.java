package lion.Board.controller;

import lion.Board.Domain.Board;
import lion.Board.Domain.Criteria;
import lion.Board.Domain.PageMaker;
import lion.Board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BoardController {


    //DI 생성자 주입
    private final BoardService boardService;
    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    //문제5-3.게시판 구현 코딩
    @GetMapping(value = "/board/list")
    public String list(Model model) {
        List<Board> boards = boardService.findBoards();
        model.addAttribute("boards", boards);
        return "boardList";
    }

    //문제5-4.게시판 목록 및 페이징 구현
    @GetMapping(value = "/board/pagingList")
    public String pageList (@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum, Model model) throws Exception {
        model.addAttribute("pageNum", pageNum);

        //전체 게시글 수
        int boardListCnt = boardService.boardListCnt();

        Criteria criteria = new Criteria();     //criteria 인스턴스 생성
        criteria.setPage(pageNum);              //get으로 받은 페이지넘버 현재페이지로 세팅

        //criteria에 맞는 게시글 목록 받아오기
        List<Board> boards = boardService.findPageBoards(criteria);
        model.addAttribute("boards", boards);   //모델에 저장

        PageMaker pageMaker = new PageMaker();  //페이징버튼 정보 객체 생성
        pageMaker.setCriteria(criteria);        //criteria 인스턴스 인수로 넣어준다
        pageMaker.setTotalCount(boardListCnt);  //전체 게시슬 수 세팅
        model.addAttribute("pageMaker", pageMaker); //모델에 저장

        return "pagingBoardList";
    }

}

