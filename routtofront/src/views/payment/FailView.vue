<template>
    <div id="info" class="box_section" style="width: 600px">
      <img style="width: 100px" src="https://static.toss.im/lotties/error-spot-no-loop-space-apng.png" />
      <h2>결제를 실패했어요</h2>
  
      <div class="p-grid typography--p" style="margin-top: 50px">
        <div class="p-grid-col text--left"><b>에러메시지</b></div>
        <div class="p-grid-col text--right" id="message">{{ this.$route.query.message }}</div>
      </div>
      <div class="p-grid typography--p" style="margin-top: 10px">
        <div class="p-grid-col text--left"><b>에러코드</b></div>
        <div class="p-grid-col text--right" id="code">{{ this.$route.query.code }}</div>
      </div>
      <div class="p-grid">
        <button class="button p-grid-col5" onclick="location.href='https://docs.tosspayments.com/guides/payment/integration';">연동 문서</button>
        <button class="button p-grid-col5" onclick="location.href='https://discord.gg/A4fRFXQhRu';" style="background-color: #e8f3ff; color: #1b64da">실시간 문의</button>
      </div>
    </div>
  </template>
  <script></script>
  <style>
  body, html {
    height: 100%;
    margin: 0;
    display: flex;
    justify-content: center; /* 수평 중앙 정렬 */
    align-items: center; /* 수직 중앙 정렬 */
    flex-direction: column; /* 자식 요소들을 수직 방향으로 정렬 */
  }

  /* .box_section 스타일 */
  .box_section {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    width: 600px; /* 너비 설정 */
    text-align: center; /* 텍스트 중앙 정렬 */
  }

  .p-grid {
    width: 100%;
    display: flex;
    justify-content: space-around; /* 버튼 사이의 공간을 동일하게 설정 */
  }

  .p-grid-col5 {
    flex: 1; /* 버튼이 공간을 균등하게 차지하도록 설정 */
  }
</style>