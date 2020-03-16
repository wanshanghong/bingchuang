window.onload = function(){
    show_patients_list();
    timer();
    Patient();
    get_wendu();
    get_yali();
    get_niaochuang();
    get_medicine();
    is_normal();
    showIsnormal();
};


function show_patients_list() {  //患者信息显示
    var xhr = new XMLHttpRequest;
    xhr.open("get", "http://47.103.6.223:8080/bingchuang-manager-web/   findpatientallpatient.action");
    xhr.send();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            var tbo = document.getElementById("patients");
            tbo.innerHTML = "";
            var Json = JSON.parse(xhr.response);
            for (var i = 0; i < Json.length; i++) {
                var tbody = document.getElementById("patients");
                var tr = document.createElement("tr");
                tr.setAttribute("class", "patient");

                var td = document.createElement("td");
                var input = document.createElement("input");
                input.setAttribute("class", "patient_input");
                input.setAttribute("type", "checkbox");
                td.appendChild(input);
                tr.appendChild(td);

                var tdid = document.createElement("td");
                tdid.innerHTML = Json[i].patientId;
                tr.appendChild(tdid);
                var tdname = document.createElement("td");
                tdname.innerHTML = Json[i].patientName;
                tr.appendChild(tdname);
                var tdaddress = document.createElement("td");
                tdaddress.innerHTML = Json[i].patientAddress;
                tr.appendChild(tdaddress);

                var tdtime = document.createElement("td");
                var date = new Date(Json[i].admissionTime.time);
                tdtime.innerHTML = date.getFullYear() + '/' + (date.getMonth() + 1) + '/' + date.getDate();
                tr.appendChild(tdtime);

                var tdfinal = document.createElement("td");
                tdfinal.setAttribute("class", "final");
                var label1 = document.createElement("label");
                label1.setAttribute("class", "update");
                var img1 = document.createElement("img");
                img1.setAttribute("src", "images/update.png");
                label1.appendChild(img1);
                var button1 = document.createElement("input");
                button1.setAttribute("type", "button");
                button1.setAttribute("value", "修改");
                label1.appendChild(button1);
                tdfinal.appendChild(label1);

                var label2 = document.createElement("label");
                label2.setAttribute("class", "delete");
                var img2 = document.createElement("img");
                img2.setAttribute("src", "images/delete.png");
                label2.appendChild(img2);
                var button2 = document.createElement("input");
                button2.setAttribute("type", "button");
                button2.setAttribute("value", "删除");
                var delectfunction = "delectPatient(" + Json[i].patientId + ")";
                button2.setAttribute("onclick", delectfunction);
                label2.appendChild(button2);
                tdfinal.appendChild(label2);
                tr.appendChild(tdfinal);
                tbody.appendChild(tr);
            }
        }
    };
}
function Patient(){  //获取患者信息并在查看患者界面显示
    var xhr = new XMLHttpRequest;
    xhr.open("get","http://47.103.6.223:8080/bingchuang-manager-web/findpatientbypatientId.action");
    xhr.send("patientId=32501");
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            var Json = JSON.parse(xhr.response);
            var patientId = document.getElementById('patientId');
            var patientIdcard = document.getElementById('patientIdcard');
            var patientName = document.getElementById('patientName');
            var patientAddress = document.getElementById('patientAddress');
            var diseaseInformation = document.getElementById('diseaseInformation');
            var admissionTime= document.getElementById('admissionTime');
            var patientPhoto = document.getElementById("patientPhoto");
            patientPhoto.style.backgroundImage = "url('" + Json.patientPhoto + "')" ;
            patientId.innerHTML = Json.patientId;
            patientIdcard.innerHTML = Json.patientIdcard;
            patientName.innerHTML = Json.patientName;
            patientAddress.innerHTML = Json.patientAddress;
            diseaseInformation.innerHTML = Json.diseaseInformation;
            var date = new Date(Json.admissionTime.time);
            admissionTime.innerHTML = date.getFullYear() + '/' + (date.getMonth()+1 )+ '/' + date.getDate();
            console.log(Json);
        }
    };


}
function add_patient(){  //添加病人信息
    var fd = new FormData(form1);
    console.log(fd);
    var xhr = new XMLHttpRequest();
    xhr.open("post","http://47.103.6.223:8080/bingchuang-manager-web/addpatient.action");
    xhr.send(fd);
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            alert("病人信息添加成功");
        }
    };
}
function delectPatient(obj){
    var xhr = new XMLHttpRequest;
    var str = "patientId="+obj;
    xhr.open("get","http://47.103.6.223:8080/bingchuang-manager-web/deletepatientbypatientId.action?"+str);
    xhr.send();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            show_patients_list();
            alert("删除成功");
        }
    };
}

var wendu = true;
var is_wendu = true;
var yali = true;
var is_yali = true;
var niaochuang = true;
var is_niaochuang = true;
var sum = 0 ;
function get_wendu(){  //获取患者的温度
    var xhr = new XMLHttpRequest;
    xhr.open("get","http://47.103.6.223:8080/bingchuang-manager-web/SelectTemperatureById.action");
    xhr.send("patientId=32501");
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            var Json = JSON.parse(xhr.response);
            var result = document.getElementById('temp');
            result.innerHTML = Json.temp+"℃";
            if(Json.temp>38||Json.temp<37){//异常情况
                wendu = false;
                if(is_wendu==true){
                    var ul = document.getElementById("patient_warn");
                    var li = ul.childNodes;
                    if(li.length>7){
                        ul.removeChild(ul.firstChild);
                    }
                    addElementLi1("patient_warn");

                    sum++;
                    is_wendu=false;
                }
            }else{//恢复正常
                wendu=true;
                is_wendu = true;
            }
        }
    };
    setTimeout('get_wendu()',500);//定时500毫秒执行一次
}
function get_yali(){ //获取液位信息
    var xhr = new XMLHttpRequest;
    xhr.open("get","http://47.103.6.223:8080/bingchuang-manager-web/FindLiquidById.action");
    xhr.send("patientId=32501");
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            var Json = JSON.parse(xhr.response);
            var result = document.getElementById('lData');
            if(Json.lData===6666){
                result.innerHTML = "异常";
            }
            else{
                result.innerHTML = "正常";
            }
            if(Json.lData===6666){ //异常情况
                yali = false;
                if(is_yali==true){
                    var ul = document.getElementById("patient_warn");
                    var li = ul.childNodes;
                    if(li.length>7){
                        ul.removeChild(ul.firstChild);
                    }
                    addElementLi2("patient_warn");

                    sum++;
                    is_yali = false;
                }
            }
            else{ //恢复正常
                yali = true;
                is_yali = true;
            }
        }
    };
    setTimeout('get_yali()',500);//定时500毫秒执行一次
}
function get_niaochuang(){ //获取是否尿床
    var xhr = new XMLHttpRequest;
    xhr.open("get","http://47.103.6.223:8080/bingchuang-manager-web/SelectUrineById.action");
    xhr.send("patientId=32501");
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            var Json = JSON.parse(xhr.response);
            var result = document.getElementById('uData');
            if(Json.uData===6666){
                result.innerHTML = "异常";
            }
            else{
                result.innerHTML = "正常";
            }
            if(Json.uData===6666){  //异常情况
                niaochuang = false;
                if(is_niaochuang == true){

                    var ul = document.getElementById("patient_warn");
                    var li = ul.childNodes;
                    if(li.length>7){
                        ul.removeChild(ul.firstChild);
                    }
                    addElementLi3("patient_warn");
                    sum++;
                    is_niaochuang = false;
                }
            }
            else{//恢复正常
                niaochuang = true;
                is_niaochuang = true;
            }
        }
    };
    setTimeout('get_niaochuang()',500);//定时500毫秒执行一次
}
function get_medicine(){ //获取患者的用药时间和用药准则
    var xhr = new XMLHttpRequest;
    xhr.open("get","http://47.103.6.223:8080/bingchuang-manager-web/selectallprescriptionbypatientid.action");
    xhr.send("patientId=32501");
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            var Json = JSON.parse(xhr.response);
            var result = document.getElementById('prescriptionSrc');
            result.innerHTML = Json[0].prescriptionSrc;
            var resultTime = document.getElementById("prescriptionDate");
            var date = new Date(Json[0].prescriptionDate.time);
            resultTime.innerHTML = date.getFullYear() + '/' + (date.getMonth()+1 )+ '/' + date.getDate();
        }
    };
}
function sendMessage() { //发送信息
    var message = document.getElementById("message");
    var sendMessage = message.value;
    // var receiveID = "1";
    // var sendID = "10001";
    var xhr = new XMLHttpRequest;
    //http://localhost:8088/bingchuang-manager-web/sendmassage.action?senderId=10001&sendMessage=123&receiverId=1
    var URL = "http://47.103.6.223:8080/bingchuang-manager-web/sendmassage.action" + "?senderId=10001&sendMessage="+sendMessage+"&receiverId=1"
    xhr.open("get", URL);
    xhr.send();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            var send = JSON.parse(xhr.response);
            console.log(send);
            alert("消息发送成功："+sendMessage);
        }
    };
    message.value = "";
}
function showIsnormal(){
    var zhuangtai = document.getElementById("zhuangtai");
    if(wendu && is_wendu && yali && is_yali && niaochuang && is_niaochuang){
        zhuangtai.innerText = "正常";
        console.log("正常")
    }
    else{
        zhuangtai.innerText="异常";
        console.log("异常")
    }
    setTimeout("showIsnormal()",500);
}

function is_normal(){ //判断有几条异常消息
    if (sum === 0) {
        console.log("无异常情况");
    } else {
        console.log(sum);
        var Src = "static/music/"+sum+".mp3";
        setTimeout("musicPlay('"+Src+"')",100);
        sum = 0;
    }
    setTimeout("is_normal()",1000);
}

function musicPlay(Src) {
    var  audio = new Audio(Src);
     audio.play();
}

function addElementLi1(obj) {  //显示通知消息
    var cur_time = get_time();
    var ul = document.getElementById(obj);
    var li = document.createElement("li");
    li.setAttribute("class", "show_li");
    var span = document.createElement("span");
    span.setAttribute("class","sign");
    li.innerHTML = "[" + cur_time + "]";
    var p = document.createElement("p");
    p.innerHTML = "&nbsp;&nbsp;&nbsp;#32501的病人李华的体温异常";
    li.appendChild(span);
    li.appendChild(p);
    ul.appendChild(li);
}
function addElementLi2(obj) {  //显示通知消息
    var cur_time = get_time();
    var ul = document.getElementById(obj);
    var li = document.createElement("li");
    li.setAttribute("class", "show_li");
    var span = document.createElement("span");
    span.setAttribute("class","sign");
    li.innerHTML = "[" + cur_time + "]";
    var p = document.createElement("p");
    p.innerHTML = "&nbsp;&nbsp;&nbsp;#32501的病人李华的输液即将结束";
    li.appendChild(span);
    li.appendChild(p);
    ul.appendChild(li);
}
function addElementLi3(obj) {  //显示通知消息
    var cur_time = get_time();
    var ul = document.getElementById(obj);
    var li = document.createElement("li");
    li.setAttribute("class", "show_li");
    var span = document.createElement("span");
    span.setAttribute("class","sign");
    li.innerHTML = "[" + cur_time + "]";
    var p = document.createElement("p");
    p.innerHTML = "&nbsp;&nbsp;&nbsp;#32501的病人李华尿床";
    li.appendChild(span);
    li.appendChild(p);
    ul.appendChild(li);
}

function get_time() {
    var now = new Date();
    var year = now.getFullYear();
    var month = now.getMonth();
    var day = now.getDate();
    var h = now.getHours();
    var m = now.getMinutes();
    var s = now.getSeconds();
    month = checkTime(month);
    day = checkTime(day);
    h = checkTime(h);
    m = checkTime(m);
    return year + "/" + month + "/" + day + "/" + h + ":" + m;
}


