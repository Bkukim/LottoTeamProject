<template>
  <div>
    <!-- 머리말 -->
    <HeaderCom/>
    <!-- 본문 -->
    <div class="container">
      <router-view />
    </div>
    <!-- 꼬리말 -->
    <FooterCom/>
  </div>
</template>
<script>
  import HeaderCom from '@/components/common/HeaderCom.vue'
  import FooterCom from '@/components/common/FooterCom.vue'
export default {
  components:{
    HeaderCom,
    FooterCom
  }
}
</script>
<style >
</style>