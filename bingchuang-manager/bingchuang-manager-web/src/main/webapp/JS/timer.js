// timer.js

function checkTime(i){  //补位处理
    if(i<10){
        i = "0" + i;
    }
    return i;
}
function timer(){
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
    s = checkTime(s);

    var weekday = new Array(7);
    weekday[0] = "星期日";
    weekday[1] = "星期一";
    weekday[2] = "星期二";
    weekday[3] = "星期三";
    weekday[4] = "星期四";
    weekday[5] = "星期五";
    weekday[6] = "星期六";
    var wd = now.getDay();
    document.getElementById('timer').innerHTML='系统时间：'+year+'年'+month+'月'+day+'日 '+weekday[wd]+' ' +h+':'+m+':'+s;
    setTimeout('timer()',500);//定时500毫秒执行一次
}
