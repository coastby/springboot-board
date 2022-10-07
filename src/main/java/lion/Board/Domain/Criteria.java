package lion.Board.Domain;


//최초로 게시판 목록에 들어왔을 때를 기본 세팅
//데이터 가져올 게시글을 특정하기 위해서 현재 페이지 번호와 페이지당 게시글 수가 필요한데, 기본 생성자를 통해 기본 값을 세팅한다.
public class Criteria {

    private int page;       //현재 페이지 번호
    private int perPageNum; //한 페이지당 보여줄 게시글 갯수


    //constructor
    public Criteria () {
        this.page = 1;
        this.perPageNum = 10;
    }


    //getter, setter
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        //음수 또는 0이 되지 않게 설정
        if(page <= 0) {
            this.page = 1;
        } else {
            this.page = page;
        }
    }

    public int getPerPageNum() {
        return perPageNum;
    }

    public void setPerPageNum(int pageCount) {
        //페이지 넘버가 바뀌지 않게 설정
        int cnt = this.perPageNum;
        if (pageCount != cnt) {
            this.perPageNum = cnt;
        } else {
            this.perPageNum = pageCount;
        }
    }
}
