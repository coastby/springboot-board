package lion.Board.Domain;


//페이징 관련 버튼을 위한 클래스
public class PageMaker {

    private Criteria criteria;      //paging 세팅 정보
    private int totalCount;         //총 게시글 개수
    private int startPage;          //페이징버튼 마지막 번호
    private int endPage;            //페이지버튼 처음 번호
    private boolean prev;           //페이징 이전버튼 활성화 여부
    private boolean next;           //페이징 다음버튼 활성화 여부
    private int displayPageNum = 10;    //화면에 보이는 페이징버튼 수 : 10개


    //getter, setter
    public Criteria getCriteria() {
        return criteria;
    }

    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        calcDate();     //총 게시글수가 들어오면서 endPage, startPage, prev, next가 설정된다.
    }

    private void calcDate () {
        //5페이지에 있으면 페이징버튼 1-10 보여주기, 25페이지에 있으면 21-30 보여주기
        endPage = (int) (Math.ceil(criteria.getPage() / (double) displayPageNum) * displayPageNum);
        startPage = (endPage - displayPageNum) + 1;
        if(startPage <= 0) startPage = 1;

        //총 게시글수가 (한페이지에보이는게시글수(perPageNum) * 페이징버튼최대개수(displayPageNum)) 보다 작으면
        //필요한 만큼만 보여주기
        //예 : 현재 세팅에서 게시글이 100개보다 적으면 페이징버튼이 10까지 있을 필요가 없음
        int tempEndPage = (int) (Math.ceil(totalCount / (double) criteria.getPerPageNum()));
        if (tempEndPage < endPage) {
            endPage = tempEndPage;
        }

        //페이징버튼 시작이 1이면 이전버튼 없애기
        prev = startPage == 1 ? true : false;
        //(마지막 페이징버튼*한페이지당 게시글수)보다 전체 게시글이 적으면 다음버튼 없애기
        next = endPage* criteria.getPerPageNum() >= totalCount ? true : false;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public boolean isPrev() {
        return prev;
    }

    public void setPrev(boolean prev) {
        this.prev = prev;
    }

    public boolean isNext() {
        return next;
    }

    public void setNext(boolean next) {
        this.next = next;
    }

    public int getDisplayPageNum() {
        return displayPageNum;
    }

    public void setDisplayPageNum(int displayPageNum) {
        this.displayPageNum = displayPageNum;
    }




}
