//RandPassword 随机验证码

//页面加载时，生成随机验证码
window.onload = function(){
    createCode(4);
};

//生成验证码的方法
function createCode(length){
    var code = "" ;
    var codeLength = parseInt(length);
    var checkCode = document.getElementById("checkCode");
    //所有候选组成验证码的字符，当然也可以用中文的
    var codeChars = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
        'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
    //循环组成验证码的字符串
    for( var i = 0 ; i < codeLength ; i++){
        //随机获取指定字符验证码
        var charNum = Math.floor(Math.random()*62);
        console.log(charNum);
        //组成指定字符验证码
        code += codeChars[charNum];
        console.log(codeChars[charNum]);
    }
    if(checkCode){
        //为验证区域添加样式名
        checkCode.className = "code";
        //将生成的验证码赋值到显示区
        checkCode.innerHTML = code;
    }
}

//检验验证码是否正确
function validateCode(){
    //获取显示区生成的验证码
    var checkCode = document.getElementById("checkCode").innerHTML;
    //获取输入的验证码
    var inputCode = document.getElementById("inputCode").value;
    if(inputCode.length<=0){
        // alert("请输入验证码！");
        return false;
    }
    else if(inputCode.toUpperCase()!==checkCode.toUpperCase()){
        // alert("验证码输入有误");
        return false;
    }
    else {
        // alert("验证码正确");
        return true;
    }

}


