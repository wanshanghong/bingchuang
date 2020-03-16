//add_patient_info

// /
// //filereader的方法
// function changepic() {  //
//     var reads= new FileReader();
//     f=document.getElementById('file').files[0];
//     reads.readAsDataURL(f);
//     reads.onload=function (e) {
//         document.getElementById('show').src=this.result;
//     };
// }

    //createObjectURL的方法
    function changepic(obj) {
        //console.log(obj.files[0]);//这里可以获取上传文件的name
        var newsrc=getObjectURL(obj.files[0]);
        document.getElementById('show').src=newsrc;
    }
    //建立一個可存取到該file的url
    function getObjectURL(file) {
        var url = null ;
        // 下面函数执行的效果是一样的，只是需要针对不同的浏览器执行不同的 js 函数而已
        if (window.createObjectURL!=undefined) { // basic
            url = window.createObjectURL(file) ;
        } else if (window.URL!=undefined) { // mozilla(firefox)
            url = window.URL.createObjectURL(file) ;
        } else if (window.webkitURL!=undefined) { // webkit or chrome
            url = window.webkitURL.createObjectURL(file);
        }
        console.log(url);
        return url ;
    }