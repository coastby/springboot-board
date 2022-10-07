## 📋 게시판 목록 구현 with SpringBoot

### ○ 구현 기능
- 페이징처리
  - http://localhost:8282/board/pagingList 접속 시 게시판 목록 및 페이징처리 구  
  -  http://localhost:8282/board/pagingList?pageNum=1 (GET 방식)
### ○ 프로젝트 선택
- Project : gradle project
- Spring Boot 2.7.3
- Java 11

### ○ Dependencies
- Thymeleaf
- Spring Web

### ○ DB
- H2
- 게시판 데이터 설계

<img src="https://velog.velcdn.com/images/coastby/post/d742ffe5-3bf0-4dc2-9c33-0aa3a08af3ab/image.png" style="width:300px">

- 댓글 데이터 설계

<img src="https://velog.velcdn.com/images/coastby/post/84500d06-ffee-4db8-a993-859a2516ade2/image.png" style="width:300px">

### ○ JPA (Hibernate)

<img src="https://velog.velcdn.com/images/coastby/post/91eb8a6b-c66b-46e8-a800-4d6222e27a1c/image.png">

### ○ 구현 화면
<img src="https://velog.velcdn.com/images/coastby/post/a300ae1b-37f4-4cd5-82e7-fed3c2c68f19/image.png" style="width:400px">

<img src="https://velog.velcdn.com/images/coastby/post/9e3a3d40-a2d1-411f-8cc5-adfe8131df43/image.png" style="width:400px">