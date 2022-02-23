function getBuyList(userId){

    $.ajax({
        type:"get",
        url: `/api/user/${userId}/buy`,
        dataType: "json"
    }).done(res=>{
        console.log(res);

        let buyItemList;
        res.forEach((i)=>{
            buyItemList += getBuyItem(i);
        })
        $('.content').html(buyItemList);

    }).fail(error=>{
        alert("실패")
    });
}
function getBuyItem(i){

    let buyItem = `<div class="buy-item">
                        <span class="place-name">${i.place.name}</span>
                        <span class="item-name">${i.content}</span>
                        price : <span class="price">${i.total}</span>
                        <span class="date">${i.regdate}</span>
                    </div>`
    return buyItem;
}


function getReviewList(userId){

    $.ajax({
            type:"get",
            url: `/api/user/${userId}/review`,
            dataType: "json"
        }).done(res=>{
            console.log(res);

            let reviewItemList;
            res.forEach((i)=>{
                reviewItemList += getReviewItem(i);
            })
            $('.content').html(reviewItemList);

        }).fail(error=>{
            alert("실패")
        });
}
function getReviewItem(i){

    let reviewItem = `<div class="review-item">
                        <span class="review-place-name">${i.place.name}</span>
                        <span class="review-content">${i.content}</span>
                        <span class="review-image">${i.image}</span>
                        <span class="review-date">${i.regdate}</span>
                    </div>`
    return reviewItem;
}


function getPickList(userId){

    $.ajax({
            type:"get",
            url: `/api/user/${userId}/pick`,
            dataType: "json"
        }).done(res=>{
            console.log(res);

            let pickItemList;
            res.forEach((i)=>{
                pickItemList += getPickItem(i);
            })
            $('.content').html(pickItemList);

        }).fail(error=>{
            alert("실패")
        });
}
function getPickItem(i){

    let pickItem = `<div class="pick-item">
                        <span class="pick-place-thumbnail">${i.place.thumbnail}</span>
                        <span class="pick-place-region">${i.place.region}</span>
                        <span class="pick-place-name">${i.place.name}</span>
                        <span class="pick-place-content">${i.place.content}</span>
                    </div>`
    return pickItem;
}