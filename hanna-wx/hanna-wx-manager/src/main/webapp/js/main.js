$(function() {
	$('.left dl dt').click(function(){
		$(this).next('dd').slideToggle();
	})
});
//iframe显示菜单页面
function getMenu(obj,url){
	$('#iframeid').attr('src',url);
	$('.leftList li').each(function(index) {
	    $(this).removeClass('bluefc');
	});
	 $(obj).attr("class", "bluefc");
}
//登出操作
function loginOut(){
	layer.confirm('确定退出系统么', {
	    btn: ['确定','取消']
	}, function(){
		layer.closeAll();//关闭所有layer弹出框
		window.location.href="loginOut.htm";
	}, function(){
	    
	});
}
//返回首页
function goTo(url){
	$('#iframeid').attr('src',url);
	$('.leftList li').each(function(index) {
	    $(this).removeClass('bluefc');
	});
	
	$('.leftListName').each(function(index) {
	    $(this).css('display','none');
	});
	
}
