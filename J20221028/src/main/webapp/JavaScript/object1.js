//object1.js

function Student(stdNo, stdName, mathScore) {
    this.stdNo = stdNo;
    this.stdName = stdName;
    this.mathScore = mathScore;
}

let std1 = new Student('1111', '김민수', 80);
let std2 = new Student('2222', '이수만', 85);
let std3 = new Student('3333', '홍수현', 90);

const students = [std1, std2, std3];

// <ul><li>학생1</li><li>학생2</li><li>학생3</li></ul>
// ul태그 생성
let ulTag = document.createElement('ul');
for(let i=0; i<students.length; i++) {
    let liTag = document.createElement('li');
    let txt = document.createTextNode(`학번: ${students[i].stdNo}, 이름: ${students[i].stdName}, 수학점수: ${students[i].mathScore}`);
    // <ul><li></li></ul> 생성
    ulTag.appendChild(liTag);
    // <ul><li>학번..</li></ul> 생성
    liTag.appendChild(txt);
}

document.getElementById('show').appendChild(ulTag);
