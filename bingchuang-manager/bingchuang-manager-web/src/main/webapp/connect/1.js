var xhr = new XMLHttpRequest;
// xhr.open("get","FindPostByUserId.action");
xhr.open("get","../bingchuang-manager-web/findpatientbypatientId.action");
xhr.send("patientId=32501");
// xhr.onreadystatechange = function () {
//     if(xhr.readyState == 4 && xhr.status == 200){
//         var Json = JSON.parse(xhr.response);
//         alert(Json[1].attentionAmount);
//     }
// };
xhr.onreadystatechange = function(){
    if(xhr.readyState == 4 && xhr.status == 200){
        var Json = JSON.parse(xhr.response);
        var result = document.getElementById('xx');
        // result.value = Json[1].attentionAmount;
        result.value = Json.patientId;

    }
};
