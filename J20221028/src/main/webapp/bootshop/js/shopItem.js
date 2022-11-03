// shopItem.js

fetch('../ShopItemListServlet')
    .then(result => result.json())
    .then(itemListShow)
    .catch(err => console.err(err));

function itemListShow(result) {
    console.log(result);
    result.forEach(item => {
        makeItemDiv(item);
    });

}

function makeItemDiv(item = {}) {
    //템플릿 그대로 가져오기
    let template = document.querySelector('#template>div');
    let good = template.cloneNode(true);

    // 리스트 바꾸기
    good.querySelector('h5').textContent = item.itemName;
    good.querySelector('span.text-muted').textContent = item.originPrice;
    good.querySelector('img.card-img-top').src = '../images/' + item.image;
    //스판태그 그 다음 요소 : nextSibling
    good.querySelector('span.text-muted').nextSibling.textContent = ' ' + item.salePrice;

    //리뷰 별달기
    let review = item.likeIt; //4.5
    let a = Math.floor(review); // 4
    let b = review - a; // 0.5
    let c = Math.floor(5-a-b); // 빈별갯수구하기

    for (let i = 0; i < a; i++) {
        let div = document.createElement('div');
        div.className = 'bi-star-fill';
        //div.setAttribute('class', 'bi-star-fill');
        good.querySelector('div.d-flex').append(div);
    }
    if (b) {
        let div = document.createElement('div');
        div.className = 'bi-star-half';
        good.querySelector('div.d-flex').append(div);
    }
    for (let i = 0; i < c; i++) {
        let div = document.createElement('div');
        div.className = 'bi-star';
        good.querySelector('div.d-flex').append(div);
    }

    //버튼클릭
    good.querySelector('a.btn').addEventListener('click', countUp);

    //목록.
    let parent = document.querySelector('section.py-5>div>div');
    parent.append(good);

    console.log(good);
}

function countUp() {
    console.log('클릭');
    // 카트 수 증가
    let cart = document.querySelector('.d-flex>button');
    let count = cart.querySelector('span.badge').textContent;
    count ++;

    cart.querySelector('span.badge').textContent = count;

}