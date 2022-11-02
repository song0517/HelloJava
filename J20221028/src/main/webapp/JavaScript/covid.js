//covid.js

window.onload = function () {
    //requst url.
    let url =
        'https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&returnType=JSON&serviceKey=GJnxJjlj8xutAiFLYfnPjYQTX3NgvY%2BlAClNUnPyjFj%2BcwQ1cfpWt3GtwUlhxIf4hjc0MsPdY48W7qY5utqE7w%3D%3D';

    fetch(url)
        .then(result => result.json()) // json -> object 변환
        .then(showList)
        .catch(error => console.log(error));

    document.querySelector('#findBtn').addEventListener('click', findCenterList);
}

//object 선언
let titles = {
    id: '센터아이디',
    centerName: '센터명',
    phoneNumber: '연락처',
    lat: '위도',
    lng: '경도'
};

//전역변수
let data;

//순번 전역변수
let count = 0;

//처음 실행
function showList(result) {
    //타이틀 생성 함수
    makeHead();

    // body 영역. 데이터 초기화.
    console.log(result);
    data = result.data;

    // 옵션태그 생성
    makeOption(data);

    let selectedCity = data.filter(center => center.sido == '서울특별시');
    makeList(selectedCity);

} // end of showList(result)

function makeOption(ary = []) {
    // select태그 생성
    let sidoAry = [];
    ary.forEach(center => {
        // data에 있는 센터정보와 sidoAry에 있는 센터정보를 비교
        // sidoAry에 값이 있으면 no, sidoAry에 값이 없으면 yes
        if (sidoAry.indexOf(center.sido) == -1) {
            sidoAry.push(center.sido);
        }
    });

    //option태그, value, text값 지정, city에 append
    let cityList = document.getElementById('city');
    sidoAry.forEach(sido => {
        let option = document.createElement('option');
        option.value = sido;
        option.textContent = sido;
        cityList.append(option);
    });
} //end of akeOption(ary = [])

// 찾기 버튼을 눌렀을 경우
function findCenterList() {
    let searchKey = document.querySelector('#city').value;
    let searchAry = data.filter(center => center.sido == searchKey);

    makeList(searchAry);

} //end of findCenterList()

// 전체데이터
function makeList(ary = []) {
    //화면에 tr이 있으면 tr 삭제
    document.querySelectorAll('#list>tr').forEach(tr => tr.remove());
    let list = document.getElementById('list')
    ary.forEach(center => {
        list.append(makeTr(center));
    });

    // 순번 생성
    document.querySelectorAll('#list>tr').forEach((tr, idx) => {
        let td = document.createElement('td');
        td.textContent = idx + 1;
        tr.prepend(td);
    });
} // end of makeList(ary = [])

// thead에 tr, th 생성
function makeHead() {
    // 타이틀
    let tr = document.createElement('tr');
    let th = document.createElement('th');
    th.textContent = '순번';
    tr.appendChild(th);

    for (let title in titles) {
        let th = document.createElement('th');
        let txt = document.createTextNode(titles[title]);

        th.appendChild(txt);
        tr.appendChild(th);
    }

    document.getElementById('title').append(tr);
} // end of makeHead()

function makeTr(row = {}) {
    let tr = document.createElement('tr');
    tr.setAttribute('lng', row.lng);
    tr.setAttribute('lat', row.lat);
    tr.setAttribute('facilityName', row.facilityName);
    tr.addEventListener('click', openInfoWindow);

    // td 생성
    for (let field in titles) {
        let td = document.createElement('td');
        let txt = document.createTextNode(row[field]);

        td.appendChild(txt);
        tr.appendChild(td);
    }

    return tr;
} // end of makeTr(row = {})

function openInfoWindow(e) {
    console.log(e.target.parentElement); // tr lng, lat 찾기
    let lng = e.target.parentElement.getAttribute('lng');
    let lat = e.target.parentElement.getAttribute('lat');
    let facilityName = e.target.parentElement.getAttribute('facilityName');
    console.log(facilityName);

    window.location.href = 'infoWindow.html?x=' + lng + '&y=' + lat + '&faName=' + facilityName;
} // end of openInfoWindow()