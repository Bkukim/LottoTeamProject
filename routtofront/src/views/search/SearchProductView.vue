<template>

  <div class="container text-center">
    <div>
      <h3 class="search_title mt-5">Routto Search</h3>

      <div class="container text-center">
        <!-- Stack the columns on mobile by making one full-width and the other half-width -->
        <div class="row">
          <div class="col-md-4">
            <h5>SEARCH</h5>
            <P>키워드를 입력하여 원하시는 상품을 찾아보세요.</P>
            <div class="search_input">
              <input
                type="text"
                class="form-control"
                id="prodName"
                placeholder="prodName"
                name="prodName"
              />

              <router-link to="/">
                <img class="search" src="@/assets/images/search.png" />
              </router-link>
            </div>
          </div>

          <div class="col-md-8">
            <div class="row">
              <div class="col-md-4 mr-4">
                <div class="serch_box">상품목록</div>
              </div>
              <div class="col-md-4 mr-4">
                <div class="serch_box">상품목록</div>
              </div>
              <div class="col-md-4">
                <div class="serch_box">상품목록</div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
  <script>
export default {};
</script>
  <style>
.container {
  height: 1000px;
  /* margin-top: 250px; */
}
.search {
  position: absolute;
  top: -40.7202%; /* 헤더 높이에 따른 위치 조정 */
  left: 13vw;
}
h3 {
  /* margin-top: 10px; */
  margin-bottom: 80px;
}
h5{
  position: absolute;
  top: 50.7202%; /* 헤더 높이에 따른 위치 조정 */
  left: 16vw;
}
p{
  position: absolute;
  top: 54.7202%; /* 헤더 높이에 따른 위치 조정 */
  left: 16vw;
}
.search_input {
  width: 250px;
  position: absolute;
  top: 60.7202%; /* 헤더 높이에 따른 위치 조정 */
  left: 16vw;
}


.serch_box {
  background-color: #342a26;
  width: 300px;
  height: 500px;
  color: #ffffff;
}

.col-md-4 {
  margin-right: 50px;
}

.row {
  --bs-gutter-x: 1.5rem;
  --bs-gutter-y: 0;
  display: flex;
  flex-wrap: nowrap;
  margin-top: calc(-1 * var(--bs-gutter-y));
  margin-right: calc(-0.5 * var(--bs-gutter-x));
  margin-left: calc(-0.5 * var(--bs-gutter-x));
  align-items: center;
  justify-content: space-around;
}
</style>
  