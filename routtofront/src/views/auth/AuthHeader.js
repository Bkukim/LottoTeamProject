// 웹토큰을 헤더에 넣어 spring 으로 보내기 위한 헤더를 정의해주는 곳

export default function AuthHeader(){
    // 쿠키대신 로컬 스토리지(html 5버전) 약간 쿠키확장판 느낌으로 쿠키보다 더 많은 정보를 저장가능하다. 그리고 인터넷이 끊켜도 웹브라우저에 정보가 남는다.
    let user = JSON.parse(localStorage.getItem('user')); // 사용법 : localStorage.getItem('키'); => 키를 문자열로 가져오는 것이다.
    if (user && user.accessToken) {// 로컬 스토리지에서 웹 토큰을 가진 유저가 있으면
      return { Authorization: 'Bearer ' + user.accessToken }; // 헤더에 들어가는 것으로 이것을 스프링으로 보내버린다.
    } else {
      return {}; // 웹토큰이 없으면 아무것도 안 보냄
    }
}


