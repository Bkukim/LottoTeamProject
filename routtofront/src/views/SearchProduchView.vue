<template>
    <div class="container text-center">
      <div>
        <h3 mt-3>Routto Search</h3>
  
        <div class="container text-center">
          <!-- Stack the columns on mobile by making one full-width and the other half-width -->
          <div class="row">
            <div class="col-md-4">
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


  </style>
  