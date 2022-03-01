var IMP = window.IMP;

//결제 모달창 열기
function paymentModalOpen(itemId){
    $.ajax({
        type:"get",
        url: `/api/payment/${itemId}`,
        dataType: "json"
    }).done(res=>{

        console.log(res);
        $('.pay-item-name').text(res.name);
        $('.pay-item-price').text("결제 금액 : " + res.price);

    }).fail(error=>{
        alert("결제 api통신 실패")
    });

    $(".modal-payment").css("display", "flex");
}

//결제 모달창 닫기
function paymentModalClose() {
    $(".modal-payment").css("display", "none");
}

//결제 진행
function requestPay() {
  IMP.init("imp37422895");
  IMP.request_pay({ // param
      pg: "html5_inicis",
      pay_method: "card",
      merchant_uid: "ORD20180131-0000012",
      name: "노르웨이 회전 의자",
      amount: 100,
      buyer_email: "gildong@gmail.com",
      buyer_name: "홍길동",
      buyer_tel: "010-4242-4242",
      buyer_addr: "서울특별시 강남구 신사동",
      buyer_postcode: "01181"
  }, function (rsp) { // callback
      if (rsp.success) {
          /*jQuery.ajax({
                      url: "{서버의 결제 정보를 받는 endpoint}",
                      method: "POST",
                      headers: { "Content-Type": "application/json" },
                      data: {
                          imp_uid: rsp.imp_uid,
                          merchant_uid: rsp.merchant_uid
                      }
                  }).done(function (data) {
                    // 가맹점 서버 결제 API 성공시 로직
                  })*/
          alert("결제 성공~~~~~~~~~");
          $(".modal-payment").css("display", "none");

      } else {
          alert("결제에 실패하였습니다. 에러 내용: " +  rsp.error_msg);
      }
  });
}



/*function getSubscribeModalItem(s) {
    let item = `
    <div class="item">
        <div class="imgDiv">
            <img class="profile2" src="/profile/${s.profileImageUrl}">
        </div>
        <span class="username" onclick="location.href='/blog/${s.id}'">${s.username}</span>
        <button class="btn">구독취소</button>
    </div>
    <hr class="line">`
    return item;
}

// 구독하기, 구독취소
function toggleSubscribe(toUserId,obj) {
    if ($(obj).text() === "구독취소") {
        $.ajax({
            type:"delete",
            url: "/api/subscribe/"+toUserId,
            dataType:"json"
        }).done(res=>{
            $(obj).text("구독하기");
            $(obj).toggleClass("red");
        }).fail(error=>{
            console.log("구독취소 실패",error);
        });
    } else {
        $.ajax({
            type:"post",
            url: "/api/subscribe/"+toUserId,
            dataType:"json"
        }).done(res=>{
            $(obj).text("구독취소");
            $(obj).toggleClass("red");
        }).fail(error=>{
            console.log("구독하기 실패",error);
        });
    }
}*/