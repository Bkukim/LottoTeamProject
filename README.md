<div align="center">


![ROUTTO_logo_wh](https://github.com/Bkukim/LottoTeamProject/assets/153472858/a9bb5f19-83ad-4f38-bc90-cf06d36fc4f8)
</div>

<br>

#  이커머스 프로젝트
Spring boot와 Vue.js를 활용한 화장품 이커머스 서비스 입니다.

<br>


## 💻 프로젝트 소개
#### 1. LOTTO BOARD는 사원들이 소통하고 정보를 공유할 수 있는 사내 게시판 서비스 입니다.
#### 2. 관리자 페이지로 별도의 코딩없이 게시판을 관리 할 수 있습니다.
#### 3. 동아리 모집 게시판으로 사원들이 동아리 활동을 할때 동아리원을 쉽게 모집할 수 있습니다.
#### 4. 부서별 게시판으로 부서원들끼리 소통이 가능합니다.
#### 5. 이벤트가 발생할 경우 실시간 알림으로 사용자에게 쉽게 이벤트를 알릴수 있습니다.

<br>

## 📌주요 기능
#### 1. 게시판별 글 작성/수정/삭제 기능 및 댓글기능
- 게시판별 CRUD 기능이 있으며 댓글을 추가 하고 조회할 수 있습니다.
#### 2. 전체 게시판 검색 기능
- 한번의 검색어 입력으로 모든 게시판의 게시글을 검색할 수 있습니다.
#### 3. 좋아요 및 신고 기능
- 게시글에 좋아요를 표시할 수 있습니다.
- 부적절한 게시글을 관리자에게 신고가 가능하며 관리자는 이를 관리자 페이지에서 쉽게 처리할 수 있습니다.
#### 4. HOT 게시판 기능
 - 좋아요수가 높은 글은 HOT 게시판 글로 자동으로 이동하게 됩니다.
#### 5. 동아리원 모집기능
- 날씨 api와 지도 api, 주소api, 날짜api 를 이용하여 사원들의 동아리 활동 장소와 날짜등을 쉽게 확인할 수 있습니다.
- 신청 및 승인 기능으로 쉽게 동아리원을 모집할 수 있습니다.
#### 6. 부서게시판
- 해당 부서에 속한 유저만 접근을 할수 있습니다.
- 부서가 추가되면 자동으로 해당 부서의 게시판이 추가됩니다. 
#### 7. 일반 로그인 및 소셜 로그인
- Spring Security 와 JWT를 이용하여 로그인 및 권한관리를 가능하게 하였습니다.
- OAuth2.0을 이용하여 간편한 소셜로그인을 할 수 있습니다. 
#### 8. 알림 기능
 - Redis와 SSE를 이용하여 다중서버에서도 실시간 알림을 이용할 수 있습니다.
#### 9. 관리자 기능
 - 관리자 페이지를 통한 게시판 관리 및 회원 관리, 신고 관리를 할 수 있습니다.

<br>

## 📌개발 기간
2024.05.20(월) ~ 2024.06.24(월)

<br>

## 📌개발 환경
- Version : Java 17
- IDE : IntelliJ
- Framework : SpringBoot 3.1.11
- ORM : JPA

<br>

## 📌 역할 분담

### 👦김의현
* DB 설계
* Backend
  + 소셜 로그인, 실시간 알림기능, 부서게시판, 게시글 신고기능
 
### 👻하유정
* 
 +
 

### 😎공민식
* DB 설계
* 와이어 프레임
* 요구사항 정의서 작성
* Frontend, Backend
 + 토스 간편결제 api를 통한 상품 결제 기능, 주문 상품 환불 기능, 관리자 환불 관리 기능

### 🐬김동주
* 요구사항 정의서 작성
* Frontend, Backend
 + 공지사항 CRUD
 + 서비스 문의 CRUD
 + 장바구니

 +

### 🐬김지영
* 
 +


<br>

## 📌기술 스택
<img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white"/> <img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white"/> <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"/> <img src="https://img.shields.io/badge/vue.js-4FC08D?style=for-the-badge&logo=vue.js&logoColor=white"/> <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"/> 
<img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"/> <img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white"/> <img src="https://img.shields.io/badge/oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white"> <img src="https://img.shields.io/badge/bootstrap-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white"> <img src="https://img.shields.io/badge/amazonaws-232F3E?style=for-the-badge&logo=amazonaws&logoColor=white"> <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=OpenJDK&logoColor=white"> <img src="https://img.shields.io/badge/Redis-DC382D?style=for-the-badge&logo=Redis&logoColor=white"> <img src="https://img.shields.io/badge/nginx-%23009639.svg?style=for-the-badge&logo=nginx&logoColor=white">



# LottoTeamProject
Spring boot와 Vue.js를 활용한 웹 쇼핑몰 프로젝트입니다.

<br>

## 📌주요 기능
#### 1. 카테고리별 상품 검색 및 정렬 기능
 - 검색창을 활용한 상품 검색
 - 카테고리별 상품 정렬
#### 2. 장바구니 기능
 - 원하는 상품 장바구니 담기
#### 3. 주소 검색 기능
 - 회원가입 시 회원 주소 입력
#### 4. 결제 API
 - TOSS API를 연동하여 상품 결제
#### 5. 소셜 로그인
 - Kakao 소셜 로그인으로 회원가입 및 로그인 
#### 7. 상품/주문내역 등 쇼핑몰 관리 기능
 - 관리자 페이지를 통한 상품 등록, 조회  수정
 - 주문 환불 관리

<br>

## 📌개발 기간
2024.04.17(수) ~ 2024.05.17(금)

<br>

## 📌개발 환경
- Version : Java 17
- IDE : IntelliJ
- Framework : SpringBoot 3.1.11
- ORM : JPA

<br>

## 📌기술 스택
<img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white"/> <img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white"/> <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"/> <img src="https://img.shields.io/badge/vue.js-4FC08D?style=for-the-badge&logo=vue.js&logoColor=white"/> <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"/> 
<img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"/> <img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white"/> <img src="https://img.shields.io/badge/oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white"> <img src="https://img.shields.io/badge/bootstrap-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white"> <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=OpenJDK&logoColor=white">
