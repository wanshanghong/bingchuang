function check(){
    var x = document.getElementById("username");
    var y = document.getElementById("password");
    if(x.value===""){
        var warn1 = document.getElementById("warn");
        warn1.innerHTML="<span></span><p>用户名为空！</p></span>";
    }
    else if(y.value===""){
        var warn2 = document.getElementById("warn");
        warn2.innerHTML="<span></span><p>密码为空</p></span>";
    }
    else if(!validateCode()){
        var warn3 = document.getElementById("warn");
        warn3.innerHTML="<span></span><p>验证码错误！</p></span>";
        // alert("验证码错误!");
        createCode(4);
    }
    else if(x.value==="张三"&&y.value==="123456"){
        window.location.href="all_index.html";
    }
    else{
        var warn4 = document.getElementById("warn");
        warn4.innerHTML="<span></span><p>用户名和密码错误！</p></span>";
        // alert("用户名和密码错误");
        createCode(4);
    }
}