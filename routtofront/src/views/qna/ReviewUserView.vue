<!-- review -> writerId -->
<template>
  <div class="text-center">
    <h4 class="mb-5 main_text" style="text-align: left">내가 쓴 리뷰</h4>
        <!-- 5. 테이블 시작-->
        <!-- <table class="table table-bordered" style="border: 1px solid #342a26"> -->
        <table
          class="table"
          :style="{ 'vertical-align': 'middle', 'text-align': 'center' }"
        >
          <!-- 테이블 제목 행 -->
          <thead>
            <tr class="text-center">
              <th scope="col">아이디</th>
              <th scope="col">별점</th>
              <th scope="col">내용</th>
              <th scope="col">사진</th>
            </tr>
          </thead>
          <tbody>
            <!-- 1행 -->
            <tr
              class="text-center"
              v-for="(data, index) in reviewList"
              :key="index"
            >
              <!-- 아이디 -->
              <td>
                <div>
                  <p>{{ data.userId }}</p>
                </div>
              </td>
              <!-- 별점 -->
              <td>
                <div>
                  <p>{{ data.point }}</p>
                </div>
              </td>
              <!-- 내용-->
              <td>
                <div>
                  <p>{{ data.reviewContent }}</p>
                </div>
              </td>
              <!-- 리뷰 사진 -->
              <td>
                <img
                  :src="data.reviewImgUrl"
                  style="width: 150px; height: 100px"
                />
              </td>
            </tr>
          </tbody>
        </table>

    <!-- 페이징 -->
    <!-- {/* paging 시작 */} -->
    <!-- TODO: 1페이지당 화면에 보일 개수 조정(select태그) -->
    <div class="row justify-content-center mt-4">
      <div class="col-auto">
        <b-pagination
          class="col-12 mb-3"
          v-model="page"
          :total-rows="count"
          :per-page="pageSize"
          @click="retrieveReviewUserId"
        ></b-pagination>
      </div>
    </div>
  </div>
</template>

<script>
import ReviewService from '@/services/product/ReviewService';

export default {
  data() {
    return {
      reviewList: [],
      userId: this.$store.state.user.userId,
      // 공통 속성(현재페이지, 전체데이터개수,1페이지당개수)
      page: 1, // 현재페이지번호
      count: 0, // 전체데이터개수
      pageSize: 10, // 1페이지당개수(select태그)
    };
  },
  methods: {
    // 전체조회 함수
    async retrieveReviewUserId() {
      try {
        // TODO: 1) 공통 전체조회 함수 실행
        let response = await ReviewService.getAllReviewUserId(
          this.userId, // 검색어
          this.page - 1, // 현재페이지번호-1
          this.pageSize // 1페이지당개수(size)
        );
        // TODO: 복습 : 2) 객체분할 할당
        const { reviewList, totalItems } = response.data; // 부서배열(벡엔드 전송)
        // TODO: 3) 바인딩변수(속성)에 저장
        this.reviewList = reviewList; // 부서배열(벡엔드 전송)
        this.count = totalItems; // 전체페이지수(벡엔드 전송)
        // TODO: 4) 프론트 로깅 : console.log
        console.log(response.data);
      } catch (e) {
        console.log(e);
      }
    },
  },
  mounted() {
    this.retrieveReviewUserId();
    window.scrollTo(0, 0);
  },
};
</script>

<style>
@import "@/assets/css/Button.css";
</style>
