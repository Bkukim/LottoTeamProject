<template>
    <br />
    <br />
    <br />
    <div class="container mt-5">
        <div class="row">
            <div class="col"></div>
            <div class="col-10">
                <!-- 회원탈퇴 제목 시작 -->
                <table class="table">
                    <thead>
                        <tr>
                            
                            <h1 scope="col">회원탈퇴</h1>                         
                        </tr>
                    </thead>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <tbody>
                        <tr>
                            <th scope="row">
                                <label for="id" class="insert-id">회원아이디</label>
                                {값}
                            </th>
                            <th scope="row">
                                <label for="id" class="insert-id">회원 이름</label>
                                {값}
                            </th>
                            <th scope="row">
                                <label for="id" class="insert-id">보유 포인트</label>
                                {값}
                            </th>
                            
                        </tr>
                    </tbody>
                </table>
         






            </div>
        </div>
        <div>회원아이디 {값} 및 회원 이름 {값}</div>
        <div>현재 보유 포인트 {값}</div>
        <div>회원 탈퇴 안내문</div>
        <div>정말로 회원을 탈퇴 하시겠습니까</div>
        <div>회원탈퇴(버튼) + 아니오(버튼) </div>
    </div>
</template>
<script>
export default {

}
</script>
<style></style>