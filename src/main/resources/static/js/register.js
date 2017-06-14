/**
 *
 * @param id
 * @returns {Element}
 */
function $$(id) {
    return document.getElementById(id);
}//end $$
/**
 *
 */
function pageload() {
    var strName = localStorage.getItem("keyName");
    var strPass = localStorage.getItem("keyPass");
    if (strName) {
        $$("txtName").value = strName;
    }
    if (strPass) {
        $$("txtPass").value = strPass;
    }

}//END pageload

function btn_log_click() {
    var strName = $$("txtName").value;
    var strPass = $$("txtName").value;
    localStorage.setItem("keyName", strName);
    if ($$("chksave").checked) {
        localStorage.setItem("keyPass", strPass);
    } else {
        localStorage.removeItem("keyPass");
    }
    $$("spnStatus").className = "status";
    $$("spnStatus").innerHTML = "登录成功";
}//end btn_log_click

$("#next").bind('click', function () {
    var emailVar = $("#emailVar").val();
    var passVar = $("#passVar").val();
    var passRep = $("#cpass").val();
    if (passVar !== passRep) {
        return;
    }

    $.post("/register/post",
        {
            email: emailVar,
            password: passVar
        },
        function (data) {
            if (data === 'exist') {
                alert('邮箱已被注册');
            } else {
                $.post("/login",
                    {
                        username: emailVar,
                        password: passVar
                    }, function (data) {
                        // console.log(data);
                    });
                setTimeout(function () {
                    window.location.href = '/';
                }, 1000);
            }
        });
});

function mail_blur() {
    var mailAdress = $("#emailVar").val();
    $("#mail_result").show();
}

function mail_focus() {

}


function pass_blur() {
    var passOnce = $("#passVar").val();
    // console.log(passOnce);
    // var passRep = $("input[name='cpass']")
    var passRep = $("#cpass").val();
    // console.log(passRep);

    if (passOnce === passRep) {
        $("#pass_result").hide();
    } else {
        $("#pass_result").show();
    }
}

function pass_focus() {

}