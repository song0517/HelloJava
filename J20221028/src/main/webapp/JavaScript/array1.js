// array1.js
fetch('data/MOCK_DATA.json')
    // 자바스크립트에서 사용하기 편하도록 오브젝트타입으로 변환
    .then(result => result.json())
    // result.json() 값 넘겨온다.
    .then(composeFnc)
    .catch(error => console.log(error));

function composeFnc(result) {
    // 급여 5000넘는 사람들만 filter한 후에 새로운 모임 생성
    result.filter(row => row.salary > 5000)
        .map(row => {
            let team = {
                t_id: row.id,
                t_name: row.first_name + '/' + row.last_name
            }
            team.t_mail = row.email;
            team['t_dept'] = 'Account';

            return team;
        })
        .forEach(team => console.log(team));
}

// Array.map() => A형태의 데이터를 받아 A'새로운 형태로 바꾸어주는 역할, 원하는 정보만 추려 새로운 배열 생성
function mappingFnc(result) {
    let newAry = result.map(row => {
        let newObj = {}; // let newObj = new Object();도 가능
        newObj.user_id = row.id;
        newObj.user_name = row.first_name + '-' + row.last_name;
        newObj.info = row.email;

        return newObj;
    });

    newAry.forEach(obj => console.log(obj));
}

function filterFnc(result = []) { // result = [] : 초기값 설정, 값이 없으면 []처리
    //Array.filter : 매개함수의 반환값(조건)이 true인 요소들만 모아서 새로운 배열 생성
    // result.filter((row, idx) => {
    //     return row.salary > 5000;
    // }).forEach( row => console.log(row) );

    result.filter((row, idx) => row.salary > 5000)
        .forEach(row => console.log(row));

    // 새로운 배열 반복 실행
    //oddAry.forEach(row => console.log(row));
}

function showMain(result) {
    console.log(result);
    //Array.forEach : 반환값은 없고 최종처리하는 기능 구현
    result.forEach((row, idx) => {
        //if(row.gender == 'Female'){
        if (idx % 2 == 0) {
            console.log(row.id, row.first_name, row.last_name);
        }
    });
}

function listShow(result){
    result.forEach( row => console.log(row));
}

// 변수 초기값 설정 : 값이 들어가지 않을 경우 초기값이 들어간다.
function sum(a = 0, b = 0){
    return a+b;
}
console.log(sum(10));