$(function(){
	//定义查询选择框
	$.jqPaginator('#paginationId', {
        totalPages: 1,
        currentPage: 1,
        first:'首页',
        first: '<li class="first"><a href="javascript:void(0);">首页<\/a><\/li>',
        prev: '<li class="prev"><a href="javascript:void(0);">上一页<\/a><\/li>',
        next: '<li class="next"><a href="javascript:void(0);">下一页<\/a><\/li>',
        last: '<li class="last"><a href="javascript:void(0);">末页<\/a><\/li>',
        page: '<li class="page"><a href="javascript:void(0);">{{page}}<\/a><\/li>',
        onPageChange: function (num, type) {
        	search(num);
        }
    });
})

var pageSize = 10;

//查询 刷新当前页数pageNum
function search(pageNum){
	var phoneNumber = '';
	var nickName = '';
	if($("#type").val() == 1){
		nickName = $("#typeValue").val();
	}else if($("#type").val() == 2){
		phoneNumber = $("#typeValue").val();
	}
	
	layer.load(2);//遮罩层
	$.ajax({
	      url: "queryAdmin.htm",
	      datatype: 'json',
	      type: "post",
	      data: {
	    	  begin:(pageNum-1)*pageSize,
	    	  rows:pageSize,
	    	  nickName:nickName,
	    	  phoneNumber:phoneNumber,
	    	  startDate:$("#startDate").val(),
	    	  endDate:$("#endDate").val()
	      },
	      success: function (data) {
	    	  layer.closeAll('loading');
	        if (data.flag == '1' && data.errorCode == '10000') {
	        	table(data,pageNum);//显示列表
	        }else{
	        	layer.alert(data.content, {icon: 6});
	        }
	      }
	    });
}

//列表显示内容
function table(data,pageNum){
	if(data.content == null || data.content.length <= 0){
		$("#tbodyId").html('<tr ><td colspan="7">无数据</td></tr>');
		$('#pageId').css('display','none');
		return;
	}else{
		$('#pageId').css('display','block');
	}
	
	//计算页数
    if(data.pageCount%10 > 0){
  	  var pageCount = (data.pageCount - data.pageCount%10)/10 + 1; 
    }else{
  	  var pageCount = data.pageCount/10; 
    }
    
    $('#paginationId').jqPaginator('option', {
    	currentPage: pageNum, //当前页数
        totalPages: pageCount //总页数
    });

    $("#showPageCount").html(pageCount);//按时一共查询出几页
	
	var str = '';
	for (var i = 0; i < data.content.length; i++) { 
		str = str + '<tr>';
		str = str + '<td>' + data.content[i].id + '</td>';
		str = str + '<td>' + data.content[i].nickName + '</td>';
		
		if(data.content[i].sex != null){
			if(data.content[i].sex == 1){
				str = str + '<td>' + '男' + '</td>';
			}else{
				str = str + '<td>' + '女' + '</td>';
			}
		}else{
			str = str + '<td></td>';
		}
		
		if(data.content[i].age != null){
			str = str + '<td>' + data.content[i].age + '</td>';
		}else{
			str = str + '<td></td>';
		}
		
		if(data.content[i].phoneNumber != null){
			str = str + '<td>' + data.content[i].phoneNumber + '</td>';
		}else{
			str = str + '<td></td>';
		}
		str = str + '<td>' + data.content[i].createTime + '</td>';
		str = str + '<td><a href="javascript:void(0)" onclick="getAdminInfo(\'' + data.content[i].id + '\')">管理员详情</a>　<a href="javascript:void(0)" onclick="modify(\'' + data.content[i].id + '\')">修改</a>　<a href="javascript:void(0)" onclick="dele(\'' + data.content[i].id + '\')">删除</a></td>';
		str = str + '</tr>';
    }
	$("#tbodyId").html(str);
}
//查看管理员详情
function getAdminInfo(id){
	//iframe层-父子操作
	var index = layer.open({
	    type: 2,
	    area: ['900px', '500px'],
	    fix: false, //不固定
	    maxmin: true,
	    content: 'getAdminInfo.htm?id=' + id
	});
	layer.full(index);
}
//新增
function add(){
	//iframe层-父子操作
	var index = layer.open({
	    type: 2,
	    area: ['900px', '500px'],
	    fix: false, //不固定
	    maxmin: true,
	    content: 'addAdminPage.htm'
	});
	layer.full(index);
}
//修改
function modify(id){
	//iframe层-父子操作
	var index = layer.open({
	    type: 2,
	    area: ['900px', '500px'],
	    fix: false, //不固定
	    maxmin: true,
	    content: 'modifyAdminInfo.htm?id='+id
	});
	layer.full(index);
}
//删除
function dele(id){
	layer.confirm('确定删除该管理员？',{
		btn: ['确定','取消']
	},function(){
		$.ajax({
			url: "updateAdminInfo.htm",
			datatype: 'json',
			type: "post",
			data: {
				id:id,
				isDeleted:'1'
			},
			success: function (data) {
				if (data.flag == '1' && data.errorCode == '10000') {
					layer.alert('删除成功！', {
						icon: 6
					},function(index){
						search(1);
						layer.close(index);
					});
				}else{
					layer.alert(data.content, {icon: 6});
				}
			}
		});
	});
}