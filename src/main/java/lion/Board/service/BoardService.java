package lion.Board.service;

import lion.Board.Domain.Board;
import lion.Board.Domain.Criteria;
import lion.Board.repository.BoardRepository;
import lion.Board.repository.JpaBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class BoardService {
    //DI 생성자주입
    private  final BoardRepository boardRepository;
    @Autowired //생략가능
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    //전체 게시판 리스트 반환
    public List<Board> findBoards() {
        return boardRepository.findAll();
    }

    //페이징 게시판 게시글리스트 반환
    public List<Board> findPageBoards(Criteria criteria) {
        return boardRepository.pagingFindAll(criteria);
    }

    //전체 게시글 수 반환
    public int boardListCnt() throws Exception {
        return boardRepository.boardListCnt();
    }

}
