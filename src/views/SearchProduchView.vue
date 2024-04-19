<template>
    <div class="container text-center">
      <div>
        <h3 mt-3>Routto Search</h3>
  
        <div class="container text-center">
          <!-- Stack the columns on mobile by making one full-width and the other half-width -->
          <div class="row">
            <div class="col-md-4">
              <h3> SEARCH</h3>
              <P>키워드를 입력하여 원하시는 상품을 찾아보세요.</P>
              <div class="search_input">
                <input
                  type="email"
                  class="form-control"
                  id="exampleFormControlInput1"
                  placeholder="search"
                />
  
                <router-link to="#">
                  <img class="search" src="../../src/assets/images/search.png" />
                </router-link>
              </div>
            </div>
  
            <div class="col-md-8">
              <div class="row">
                <div class="col-md-4 mr-4">
                  <div class="serch_box">
                    상품목록
                  </div>
                </div>
                <div class="col-md-4 mr-4">
                  <div class="serch_box">
                    상품목록
                  </div>
                </div>
                <div class="col-md-4">
                  <div class="serch_box">
                    상품목록
                  </div>
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
  h3 {
    margin-top: 100px;
    margin-bottom: 100px;
  }

  .search_input{
    width: 250px;
  }
  
  .serch_box {
    background-color: #342a26;
    width: 300px;
    height: 500px;
    color: #ffffff;
  }

  .col-md-4{
    margin-right: 50px;
  }

  .row {
    --bs-gutter-x: 1.5rem;
    --bs-gutter-y: 0;
    display: flex;
    flex-wrap: nowrap;
    margin-top: calc(-1* var(--bs-gutter-y));
    margin-right: calc(-.5* var(--bs-gutter-x));
    margin-left: calc(-.5* var(--bs-gutter-x));
    align-items: center;
    justify-content: space-around;
}
  </style>
  