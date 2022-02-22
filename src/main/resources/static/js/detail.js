// 결제 모달창 띄우기
function paymentModalOpen(placeId) {
    $(".modal-payment").css("display", "flex");

    /*$.ajax({
        type:"get",
        url: `/api/payment/${placeId}`,
        dataType: "json"
    }).done(res=>{
        console.log(res.data);

        *//*res.data.forEach((s)=>{
            let item = getSubscribeModalItem(s);
            $(".subscribeList-container").append(item);*//*
        })
    }).fail(error=>{
        alert("실패")
    });*/
}

/*
function getSubscribeModalItem(s) {
    let item = `
    <div class="item">
        <div class="imgDiv">
            <img class="profile2" src="/profile/${s.profileImageUrl}">
        </div>
        <span class="username" onclick="location.href='/blog/${s.id}'">${s.username}</span>
<!--        <button class="btn">구독취소</button>-->
    </div>
    <hr class="line">`


    return item;
}
*/

// 구독블로그 모달창 닫기
function paymentModalClose() {
    $(".modal-payment").css("display", "none");
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
}