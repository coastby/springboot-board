package lion.Board.repository;

import lion.Board.Domain.Board;
import lion.Board.Domain.Criteria;

import javax.persistence.EntityManager;
import java.util.List;

public class JpaBoardRepository implements BoardRepository{

    private final EntityManager em;

    public JpaBoardRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Board save(Board board) {
        em.persist(board);
        return board;
    }

    @Override
    public List<Board> findAll() {
        //전체 게시글 데이터를 역순으로 받아온다
        return em.createQuery("select b from Board b order by b.id desc", Board.class)
                .getResultList();
    }

    @Override
    //전체 board 데이터 개수
    public int boardListCnt() {
        return this.findAll().size();
    }

    @Override
    //페이지값에 따라 데이터를 역순으로 받아온다.
    public List<Board> pagingFindAll(Criteria criteria) {
        //한 페이지 당 게시글 수
        int pageRow = criteria.getPerPageNum();
        //현재 페이지 번호
        int pageNum = criteria.getPage();

        String sql_string =
                        "select * from board order by id desc " +               //id의 역순으로 정렬해서 가져온다
                        "offset (" + pageNum + "-1)*" + pageRow + " rows " +    //앞의 페이지 수 만큼 빼고 게시글 데이터를 가져온다.
                        "fetch next " + pageRow + " rows only";                 //한 페이지의 게시글 수만큼 가져온다.
        return em.createNativeQuery(sql_string, Board.class)
                .getResultList();
    }
}
