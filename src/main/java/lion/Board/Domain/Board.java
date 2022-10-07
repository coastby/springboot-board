package lion.Board.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Board {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;   //DB에서 자동 생성
    private String title;
    private String contents;
    private String writer;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Date created; //DB에서 자동 생성
    private int likes;
    private int views;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
