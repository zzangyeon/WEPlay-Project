function getBuyList(userId){

    $.ajax({
        type:"get",
        url: `/api/user/${userId}/buy`,
        dataType: "json"
    }).done(res=>{
        console.log(res);
           /*res.data.forEach((s)=>{
                let item = getSubscribeModalItem(s);
                $(".subscribeList-container").append(item);*//**//*
            })*/
            res.forEach((i)=>{
                let buyItem = getBuyItem(i);
                $('.content').append(buyItem);
            })
    }).fail(error=>{
        alert("실패")
    });

}
function getBuyItem(i){

    let buyItem = ` <div class="buy-item">
                        <span class="place-name">${i.place.name}</span>
                        <span class="item-name">${i.content}</span>
                        price : <span class="price">${i.total}</span>
                        <span class="date">${i.regdate}</span>
                    </div>`

    return buyItem;

}