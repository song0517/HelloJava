<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>index.jsp</title>
    <script src="object.js"></script>
</head>
<body>
    <!--on이 붙으면 이벤트가 발생-->
    <form action="index.html" onsubmit="submitFunc()">
        id: <input type="text" id="uid" value="user1"><br>
        pw: <input type="password" id="upw" value="1234"><br>
        <input type="submit" value="로그인">
    </form>

    <div id="show"></div>

    <script>
        //document.write('<p>Hello, World</p>');
        //DOM 요소 생성.
        function saveFnc() {
        let pTag = document.createElement('p'); //<p></p>태그 생성 자식요소/부모요소
        let txt = document.createTextNode('Hello, World');
        pTag.appendChild(txt); //<p>Hello, World</p>
        console.log(pTag);

        let show = document.getElementById('show');
        show.appendChild(pTag);
        console.log(show);
        }

        function submitFunc() {
            event.preventDefault(); //form이 가지고 있는 기본 기능을 차단. -> 이동하지 않고 콘솔 나타남..
            console.log('submitFunc() call.')
            
            // 엘리먼트 선택하는데 id속성으로 엘리먼트를 선택.
            let id = document.getElementById('uid').value;
            let pw = document.getElementById('upw').value;

            //요소를 만들 경우에는 createElement
            let pTag = document.createElement('p');
            let txt = document.createTextNode('id는 ' + id + ', 비밀번호는 ' + pw);
            //부모자식관계 생성
            pTag.appendChild(txt);

            pTag.onclick = function() {
                //this -> 제일 상위 계층
                console.log(this.remove());
            }

            document.getElementById('show').appendChild(pTag);
        }
    </script>
</body>
</html>