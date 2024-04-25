<template>
    <div class="header">
      <div class="logo">
        <!-- 로고 이미지 또는 텍스트 -->
      </div>
      <div class="search-icon" @click="toggleSearch">
        <!-- 검색 아이콘 이미지 또는 아이콘 폰트 -->
      </div>
      <div class="search-box" v-show="isSearchOpen">
        <!-- 검색 창 -->
        <input type="text" placeholder="검색어를 입력하세요" />
        <button @click="closeSearch">닫기</button>
      </div>
      <!-- 나머지 헤더 내용 -->
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        isSearchOpen: false // 검색창이 열려 있는지 여부를 나타내는 변수
      };
    },
    methods: {
      toggleSearch() {
        this.isSearchOpen = !this.isSearchOpen; // 검색창 토글
      },
      closeSearch() {
        this.isSearchOpen = false; // 검색창 닫기
      }
    }
  };
  </script>
  
  <style scoped>
  .header {
    /* 헤더 스타일 */
  }
  
  .search-icon {
    /* 검색 아이콘 스타일 */
  }
  
  .search-box {
    /* 검색창 스타일 */
    display: none; /* 초기에는 숨김 */
  }
  </style>
  