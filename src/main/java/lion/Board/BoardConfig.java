package lion.Board;

import lion.Board.repository.BoardRepository;
import lion.Board.repository.JpaBoardRepository;
import lion.Board.service.BoardService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class BoardConfig {

    private final DataSource dataSource;
    private final EntityManager em;

    public BoardConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }
    //스프링 빈으로 등록
    @Bean
    public BoardService boardService () {
        return new BoardService(boardRepository());
    }

    //스프링 빈으로 등록
    @Bean
    public BoardRepository boardRepository() {
        return new JpaBoardRepository(em);
    }


}
