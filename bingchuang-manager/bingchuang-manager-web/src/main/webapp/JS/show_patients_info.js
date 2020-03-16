//show_patient_info.js

var patients=[
    {"id":"001","name":"张三","address":"惠城区","date":"2019.04.02"},
    {"id":"002","name":"李木子","address":"惠城区","date":"2019.04.02"},
    {"id":"003","name":"陈耳朵","address":"惠城区","date":"2019.04.02"},
    {"id":"004","name":"张长功","address":"惠城区","date":"2019.04.02"},
    {"id":"005","name":"杨木","address":"惠城区","date":"2019.04.02"},
    {"id":"006","name":"辜小小","address":"惠城区","date":"2019.04.02"},
    {"id":"007","name":"林木木","address":"惠城区","date":"2019.04.02"},
    {"id":"008","name":"陈可儿","address":"惠城区","date":"2019.04.02"},
    {"id":"009","name":"王晓","address":"惠城区","date":"2019.04.02"},
    {"id":"010","name":"傅华敏","address":"惠城区","date":"2019.04.02"},
    {"id":"011","name":"曾馨","address":"惠城区","date":"2019.04.02"},
    {"id":"012","name":"杨过","address":"惠城区","date":"2019.04.02"},
    {"id":"013","name":"江欣","address":"惠城区","date":"2019.04.02"},
    {"id":"014","name":"林梓","address":"惠城区","date":"2019.04.02"},
    {"id":"015","name":"陈磊","address":"惠城区","date":"2019.04.02"},
    {"id":"016","name":"陈三","address":"惠城区","date":"2019.04.02"}
];
function ShowPatient(){
    var tbody=document.getElementsByTagName("tbody");
    var str="";
    for(var i = 0 ; i < 10 ; i++){
        str += "<tr><td><input type=\"checkbox\"/></td><td>"
            +patients[0].id+"</td><td>"+patients[0].name+"</td><td>"
            +patients[0].address+"</td><td>"+patients[0].data +
            "</td><td class=\"final\"><label class=\"update\">" +
            "<img  src=\"images/update.png\" alt=\"\"/>" +
            "<input type=\"button\" value=\"修改\"/>" +
            "</label><label class=\"delete\"><img  src=\"images/delete.png\" alt=\"\"/>" +
            "<input type=\"button\" value=\"删除\"/></label></td></tr>";
    }
    tbody.innerHTML = str;
    tbody.innerHTML(str);
}
function show_patient(){
    //轮询
    var xhr = new XMLHttpRequest;
    xhr.open("get","FindPostByUserId.action");
    xhr.send("patientId=32501");
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            var Json = JSON.parse(xhr.response);
            var result = document.getElementById('qq');
            result.value = Json[1].attentionAmount;

        }
    };
    console.log
}


