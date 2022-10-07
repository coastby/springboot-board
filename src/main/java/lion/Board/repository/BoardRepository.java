package lion.Board.repository;

import lion.Board.Domain.Board;
import lion.Board.Domain.Criteria;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {

    Board save(Board board);
    List<Board> findAll();
    List<Board> pagingFindAll(Criteria criteria);
    int boardListCnt();
}
