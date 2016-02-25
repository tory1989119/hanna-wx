$(function() {
	//登录方法
	$("#dologin").click(function(){
		var isTop = false;
		if($("#username").val() == '' || $("#username").val() == null){
			layer.tips('用户名不能为空', '#username', {
				tipsMore: true,
			    tips: [2, '#2AC0CE']
			});
			isTop = true;
		}
		
		if($("#password").val() == '' || $("#password").val() == null){
			layer.tips('密码不能为空', '#password', {
				tipsMore: true,
			    tips: [2, '#2AC0CE']
			});
			isTop = true;
		}
		
		if(isTop){
			return;
		}
		
		$.ajax({
    		type:"post",
    		url:"doLogin.htm",
    		async:true,
    		traditional:true,
    		data:{
    			username:$("#username").val(),
				password:$("#password").val()
    		},
    		dataType:"json",
    		success:function(data){
    			if(data.flag == "1" && data.errorCode == "10000"){
					$("#main").submit();
    			}else{
    				layer.msg(data.content, {icon: 5});
    			}
    		}
		});
	});
});