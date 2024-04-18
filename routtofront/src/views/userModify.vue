<template>
    <div>
        <div>
            회원정보수정
        </div>
        <div>
            기본정보
            <div>
                <div class="m-1">
                    아이디 <input type="text">
                </div>
                <div class="m-1">
                    비밀번호 <input type="text">
                </div>
                <div class="m-1">
                    비밀번호 확인 <input type="text">
                </div>
                <div class="m-1">
                    이름 <input type="text">
                </div>
                <div class="m-1">
                    <input type="text" v-model="postcode" placeholder="우편번호">
                    <input type="button" @click="execDaumPostcode()" value="우편번호 찾기"><br>
                    <input type="text" size="30" v-model="address" id="address" placeholder="주소"><br>
                    <input type="text" id="detailAddress" placeholder="상세주소">
                </div>
                <div class="m-1">
                    일반전화 드롭박스+<input type="text" size="1"><input type="text" size="1">
                </div>
                <div class="m-1">
                    휴대전화 드롭박스+<input type="text" size="1"><input type="text" size="1">
                    <div>
                        SMS 수신여부 : 단추 (수신함, 수신안함)
                    </div>
                </div>
                <div class="m-1">
                    이메일 : 박스
                    <div>
                        이메일 수신여부 : 단추 (수신함, 수신안함)
                    </div>                 
                </div>
                <div>
                    추가정보
                </div>
                <div>
                    <div class="btn-group" role="group" aria-label="성별 선택">
                        <input type="radio" class="btn-check" name="gender" id="option1" autocomplete="off">
                        <label class="btn btn-outline-primary" for="option1">남성</label>
                        <input type="radio" class="btn-check" name="gender" id="option2" autocomplete="off">
                        <label class="btn btn-outline-danger" for="option2">여성</label>
                    </div>

                </div>
                <div>
                    <div class="btn-group mt-3" role="group" aria-label="양/음력 선택">
                        <input type="radio" class="btn-check" name="options" id="option3" autocomplete="off">
                        <label class="btn btn-outline-light" for="option3">양력</label>
                        <input type="radio" class="btn-check" name="options" id="option4" autocomplete="off">
                        <label class="btn btn-outline-dark" for="option4">음력</label>
                    </div>
                </div>
            </div>
        </div>
    </div>

</template>
<script>
export default {
    data() {
        return {
            postcode: "",
            address: "",
            extraAddress: "",
        };
    },
    methods: {
        execDaumPostcode() {
            new window.daum.Postcode({
                oncomplete: (data) => {
                    if (this.extraAddress !== "") {
                        this.extraAddress = "";
                    }
                    if (data.userSelectedType === "R") {
                        // 사용자가 도로명 주소를 선택했을 경우
                        this.address = data.roadAddress;
                    } else {
                        // 사용자가 지번 주소를 선택했을 경우(J)
                        this.address = data.jibunAddress;
                    }

                    // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                    if (data.userSelectedType === "R") {
                        // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                        // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                        if (data.bname !== "" && /[동|로|가]$/g.test(data.bname)) {
                            this.extraAddress += data.bname;
                        }
                        // 건물명이 있고, 공동주택일 경우 추가한다.
                        if (data.buildingName !== "" && data.apartment === "Y") {
                            this.extraAddress +=
                                this.extraAddress !== ""
                                    ? `, ${data.buildingName}`
                                    : data.buildingName;
                        }
                        // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                        if (this.extraAddress !== "") {
                            this.extraAddress = `(${this.extraAddress})`;
                        }
                    } else {
                        this.extraAddress = "";
                    }
                    // 우편번호를 입력한다.
                    this.postcode = data.zonecode;
                },
            }).open();
        },
    },
};
</script>
<style>
.btn-outline-light{
    color:gray;
    border-color:gray;
}
</style>