<template>
  <div class="container text-center">
    <div>
      <h3 mt-3>Routto Search</h3>

      <div class="search_input">
        <input
          type="email"
          class="form-control"
          id="exampleFormControlInput1"
          placeholder="search"
        />
        <img
          class="search_underbar"
          src="@/assets/images/search_underbar2.png"
        />

        <router-link to="#"
          ><img class="search" src="@/assets/images/search.png" />
        </router-link>
      </div>

      <!-- 검색결과 이미지 -->
      <div class="search_box"></div>
    </div>
  </div>

</template>
<script>
export default {};
</script>
<style>
.container{
  height: 1300px;
}

/* h3 {
  margin-top: 300px;
} */


/* input box */
.search_input{
    padding: 0;
    margin: 0 auto;
}



/* 검색결과 이미지 */
.search_box {
  width: 1320px;
  height: 800px;
  background-color: #342a2646;
  margin-top: 80px;
}

/* input 박스 */
.form-control {
  border: none;
  border-radius: 0; /* input 박스 테두리 제거 */
  width: 500px; /* input 박스 가로 설정 */
  margin-right: 10px; /* 검색 아이콘과 간격 조정 */
  transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
}
  
.form-control:focus {
  border-color: #342a26; /* 클릭 시 테두리 색상 변경 */
  outline: 0; /* 클릭 시 포커스 효과 제거 */
  outline: none; /* 클릭 시 기본 파랑색 테두리 제거 */
  box-shadow: 0 0 0 0.2rem #342a263e; /* 클릭 시 파랑색 테두리 추가 */
}

#exampleFormControlInput1 {
  margin-left: 300px;
  margin-top: 80px
}
</style>