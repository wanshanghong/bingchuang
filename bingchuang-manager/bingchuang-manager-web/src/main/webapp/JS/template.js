window.onload = function(){
};
//菜单列表
function Menu(tid){
    var id=tid.id;
    var img2=document.getElementsByClassName("img2");
    if(id==="patient_management"){
        var inner_box=document.getElementById("inner_box1");

        if(inner_box.style.display==='none'){
            inner_box.style.display='block';
            img2[0].src="images/icon2.png";
        }else{
            inner_box.style.display='none';
            img2[0].src="images/icon1.png";
        }
    }
    else if(id==="account_management"){
        var inner_box=document.getElementById("inner_box2");
        if(inner_box.style.display==='none'){
            inner_box.style.display='block';
            img2[1].src="images/icon2.png";
        }else{
            inner_box.style.display='none';
            img2[1].src="images/icon1.png";
        }
    }
    else if(id==="help_center"){
        var inner_box=document.getElementById("inner_box3");
        if(inner_box.style.display==='none'){
            inner_box.style.display='block';
            img2[2].src="images/icon2.png";
        }else{
            inner_box.style.display='none';
            img2[2].src="images/icon1.png";
        }
    }
}
//在功能转换时，清除add_patient_info里面的信息
function clear_add(){
    var add_ID = document.getElementById("add_ID");
    var add_sex = document.getElementById("add_sex");
    var add_dis = document.getElementById("add_dis");
    var  add_name = document.getElementById("add_name");
    var add_address = document.getElementById("add_address");
    var add_connect = document.getElementById("add_connect");
    add_address.value = "";
    add_sex.value = "";
    add_ID.value = "";
    add_name.value = "";
    add_dis.value = "";
    add_connect.value = "";
}


//功能转换
function change_function(obj){
    var show_patient_info__main1 = document.getElementById("show_patient_info__main1");
    var add_patient_info_main1 = document.getElementById("add_patient_info_main1");
    var show_patient_list_main1 = document.getElementById("show_patient_list_main1");
    var aside_show_patient_info_main2 = document.getElementById("show_patient_info_main2");
    var aside_add_patient_info_main2 = document.getElementById("add_patient_info_main2");
    if(obj.id==="show_patient_info") {
        add_patient_info_main1.style.display = "none";
        show_patient_list_main1.style.display = "none";
        show_patient_info__main1.style.display = "block";
        aside_add_patient_info_main2.style.display = "none";
        aside_show_patient_info_main2.style.display="block";
        clear_add();
    }
    else if(obj.id==="add_patient_info"){
        show_patient_info__main1.style.display = "none";
        show_patient_list_main1.style.display = "none";
        add_patient_info_main1.style.display = "block";
        aside_show_patient_info_main2.style.display="none";
        aside_add_patient_info_main2.style.display = "block";
    }
    else if(obj.id==="index_html"){
        show_patient_info__main1.style.display = "none";
        add_patient_info_main1.style.display = "none";
        show_patient_list_main1.style.display = "block";
        aside_show_patient_info_main2.style.display="none";
        aside_add_patient_info_main2.style.display = "block";
        clear_add();
    }
}

//全选中
function is_selected(){
    var sel = document.getElementById("all_check_btn");
    var check_btn = document.getElementsByClassName("patient_input");
    if(sel.checked == true){
        for(var i = 0 ; i < check_btn.length ; i++){
            check_btn[i].checked = true;
        }
    }
    else if(sel.checked ==  false){
        for(var j = 0 ; j < check_btn.length ; j++){
            check_btn[j].checked = false;
        }
    }
}

