/**
 * Created by PC on 2017/5/14.
 */
/*
var current_fs, next_fs, previous_fs; //fieldsets
var left, opacity, scale; //fieldset properties which we will animate
var animating; //flag to prevent quick multi-click glitches
$(document).ready(function () {
    $(".next").click(function(){

        if(animating) return false;
        animating = true;

        current_fs = $(this).parent();
        next_fs = $(this).parent().next();
        //activate next step on progressbar using the index of next_fs
        $("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");

        //show the next fieldset
        next_fs.show();
        //hide the current fieldset with style
        current_fs.animate({opacity: 0}, {
            step: function(now, mx) {
                //as the opacity of current_fs reduces to 0 - stored in "now"
                //1. scale current_fs down to 80%
                scale = 1 - (1 - now) * 0.2;
                //2. bring next_fs from the right(50%)
                left = (now * 50)+"%";
                //3. increase opacity of next_fs to 1 as it moves in
                opacity = 1 - now;
                current_fs.css({'transform': 'scale('+scale+')'});
                next_fs.css({'left': left, 'opacity': opacity});
            },
            duration: 800,
            complete: function(){
                current_fs.hide();
                animating = false;
            },
            //this comes from the custom easing plugin
            easing: 'easeInOutBack'
        });
    });
});



$(".previous").click(function(){
    if(animating) return false;
    animating = true;

    current_fs = $(this).parent();
    previous_fs = $(this).parent().prev();

    //de-activate current step on progressbar
    $("#progressbar li").eq($("fieldset").index(current_fs)).removeClass("active");

    //show the previous fieldset
    previous_fs.show();
    //hide the current fieldset with style
    current_fs.animate({opacity: 0}, {
        step: function(now, mx) {
            //as the opacity of current_fs reduces to 0 - stored in "now"
            //1. scale previous_fs from 80% to 100%
            scale = 0.8 + (1 - now) * 0.2;
            //2. take current_fs to the right(50%) - from 0%
            left = ((1-now) * 50)+"%";
            //3. increase opacity of previous_fs to 1 as it moves in
            opacity = 1 - now;
            current_fs.css({'left': left});
            previous_fs.css({'transform': 'scale('+scale+')', 'opacity': opacity});
        },
        duration: 800,
        complete: function(){
            current_fs.hide();
            animating = false;
        },
        //this comes from the custom easing plugin
        easing: 'easeInOutBack'
    });
});

$(".submit").click(function(){
    return false;
})

$(".next").click(function()
{
    $(".next").hide();
    var xmlhttp;
    if (window.XMLHttpRequest)
    {// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp=new XMLHttpRequest();
    }
    else
    {// code for IE6, IE5
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            document.getElementById("myDiv").innerHTML=xmlhttp.responseText;
        }
    }
    xmlhttp.open("GET","xxxxxx.asp",true);
    xmlhttp.send();
});*/
/**
 *
 * @param id
 * @returns {Element}
 */
function $$(id){
    return document.getElementById(id);
}//end $$
/**
 *
 */
function pageload(){
    var strName = localStorage.getItem("keyName");
    var strPass = localStorage.getItem("keyPass");
    if(strName){
        $$("txtName").value = strName;
    }
    if(strPass){
        $$("txtPass").value = strPass;
    }

}//END pageload

function btn_log_click() {
    var strName = $$("txtName").value;
    var strPass = $$("txtName").value;
    localStorage.setItem("keyName", strName);
    if($$("chksave").checked){
        localStorage.setItem("keyPass", strPass);
    }else{
        localStorage.removeItem("keyPass");
    }
    $$("spnStatus").className = "status";
    $$("spnStatus").innerHTML = "登录成功";
}//end btn_log_click

$("#next").bind('click', function(){
    var emailVar = $("#emalVar").val();
    var passVar = $("#passVar").val();
	alert('调用了');
    $.post("xxxxxxxxxx",
        {email:emailVar, password:passVar},
        function(data){
            alert('Successful Submission');
        });
});

function mail_blur(){
    var mailAdress = $("#emailVar").val();
    $("#mail_result").show();
}

function mail_focus(){
    
}


function pass_blur(){
    var passOnce = $("#passVar").val();
    var passRep = $("input[name='cpass']")
    $("#pass_result").show();
}

function  pass_focus() {
    
}