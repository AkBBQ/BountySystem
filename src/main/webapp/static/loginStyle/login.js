/*用户登录*/
$('#btn').click(function(){
    var name=$('#name').val();
    var pwd=$('#pwd').val();
    $.ajax({
        method:'post',
        url:'Login/login',
        data:{name:name,pwd:pwd},
        success:function(result){
            if(result==1 || result==2){
                $('#err_msg').html("用户名或者密码错误");
            }else if(result==0){
                alert("登录成功");
                window.location.href="index.html";
            }
        },
        error:function(){
            alert("ajax请求失败!");
        },
    })
})

