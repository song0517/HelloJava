//array2.js
fetch('./MemberListServlet')
    .then(result => result.json())
    .then(userGroup)
    .catch(error => console.error(error));

function listShow(data = []) {
    //console.log(data);

    data.filter(row => row.resposibility == 'admin')
        .forEach(row => console.log(row));

    /*data.forEach(member => {
        if(member.resposibility == 'admin') {
            console.log(member);
        }
    })*/
}

function userGroup(data) {
    /*data.filter(row => row.resposibility == 'user')
        .map(data => {
            let user = {
                user_id: data.id,
                user_name: data.name,
                user_email: data.email
            }
            return user;
        })
        .forEach(data => console.log(data));*/

    let userGroup = [];
    //forEach사용
    data.forEach(member => {
        if(member.resposibility == 'user'){
            userGroup.push(member);
        }
    })
    //filter 사용
    userGroup = data.filter(member => member.resposibility == 'user');
}