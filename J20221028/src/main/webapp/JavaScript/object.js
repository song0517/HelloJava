//object.js

//object만들기, 무조건 public속성
let obj = {
    user_id: "hong",
    user_name: "Hongkildong",
    user_age: 20,
    hobbies: ['독서', '낮잠', '자전거'],
    //메소드 설정 -> obj가 가지고 있는 필드는 this를 붙여준다..
    show_info: function() {
        return 'id: ' + this.user_id + ", name: " + this.user_name + ", age: " + this.user_age;
    }
}

console.log('id: ' + obj.user_id);
console.log('name: ' + obj["user_name"]);

let field = "user_age";
console.log('age: ' + obj[field]);
console.log('첫번째 취미: ' + obj.hobbies[0]);

// 메소드 실행
console.log('홍의 정보: ' + obj.show_info());


// 객체 생성.
// 함수
function Person(name, age) {
    //this는 오브젝트 자신을 가리킴
    this.name = name;
    this.age = age;

    this.showInfo = function() {
        return '이름은 ' + this.name + ', 나이는 ' + this.age;
    }
}

//인스턴스 생성, 만들어진 값의 주소가 p1에 저장.
let p1 = new Person('홍길동', 20);
let p2 = new Person('김유신', 21);
let p3 = new Person('박명수', 22);


const persons = [p1, p2, p3];
for(let i=0; i<persons.length; i++){
    console.log(persons[i].showInfo());
}

function person(name) {
    //최상위 윈도우 객체
    this.name = name;
}

//윈도우 객체에 김민수를 담겠다.
person('김민수')
console.log(this);

//this : 함수, 전역영역에서 this를 사용하면 window 객체를 가리킨다.
//       object(new로 생성)에서 this를 사용하면 객체 자신을 가리킨다.