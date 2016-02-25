//车辆类型
function getVehicleTypeName(vehicleType){
	if(vehicleType == '0'){
		return '厢式车 ';
	}else if(vehicleType == '1'){
		return '集装箱车 ';
	}else if(vehicleType == '2'){
		return '高低板车 ';
	}else if(vehicleType == '3'){
		return '平板车 ';
	}else if(vehicleType == '4'){
		return '高栏车 ';
	}else if(vehicleType == '5'){
		return '中栏车 ';
	}else if(vehicleType == '6'){
		return '低栏车 ';
	}else if(vehicleType == '7'){
		return '罐式车 ';
	}else if(vehicleType == '8'){
		return '冷藏车 ';
	}else if(vehicleType == '9'){
		return '保温车 ';
	}else if(vehicleType == '10'){
		return '危险品车 ';
	}else if(vehicleType == '11'){
		return '铁笼车 ';
	}else if(vehicleType == '12'){
		return '自卸货车 ';
	}else if(vehicleType == '13'){
		return '其他车型 ';
	}else{
		return '';
	}
}

//车长类型
function getVehicleLengthTypeName(vehicleLengthType){
	if(vehicleLengthType == '0'){
		return '4.2M ';
	}else if(vehicleLengthType == '1'){
		return '5.2M ';
	}else if(vehicleLengthType == '2'){
		return '5.8M ';
	}else if(vehicleLengthType == '3'){
		return '6.2M ';
	}else if(vehicleLengthType == '4'){
		return '6.5M ';
	}else if(vehicleLengthType == '5'){
		return '6.8M ';
	}else if(vehicleLengthType == '6'){
		return '7.2M ';
	}else if(vehicleLengthType == '7'){
		return '8M ';
	}else if(vehicleLengthType == '8'){
		return '9.6M ';
	}else if(vehicleLengthType == '9'){
		return '12M ';
	}else if(vehicleLengthType == '10'){
		return '13M ';
	}else if(vehicleLengthType == '11'){
		return '13.5M ';
	}else if(vehicleLengthType == '12'){
		return '15M ';
	}else if(vehicleLengthType == '13'){
		return '16.5M ';
	}else if(vehicleLengthType == '14'){
		return '17.5M ';
	}else if(vehicleLengthType == '15'){
		return '18.5M ';
	}else if(vehicleLengthType == '167'){
		return '20M ';
	}else if(vehicleLengthType == '17'){
		return '22M ';
	}else if(vehicleLengthType == '18'){
		return '24M ';
	}else{
		return '';
	}
}

//车载类型
function getVehicleWeightTypeName(vehicleWeightType){
	if(vehicleWeightType == '0'){
		return '5T';
	}else if(vehicleWeightType == '1'){
		return '10T';
	}else if(vehicleWeightType == '2'){
		return '15T';
	}else if(vehicleWeightType == '3'){
		return '20T';
	}else if(vehicleWeightType == '4'){
		return '25T';
	}else if(vehicleWeightType == '5'){
		return '30T';
	}else if(vehicleWeightType == '6'){
		return '35T';
	}else if(vehicleWeightType == '7'){
		return '40T';
	}else if(vehicleWeightType == '8'){
		return '45T';
	}else if(vehicleWeightType == '9'){
		return '50T';
	}else if(vehicleWeightType == '10'){
		return '55T';
	}else{
		return '';
	}
}

//货物类型
function getGoodsTypeName(goodsType){
	if(goodsType == '0'){
		return '日用品';
	}else if(goodsType == '1'){
		return '农副产品';
	}else if(goodsType == '2'){
		return '电子电器';
	}else if(goodsType == '3'){
		return '纺织品';
	}else if(goodsType == '4'){
		return '化工';
	}else if(goodsType == '5'){
		return '药品';
	}else if(goodsType == '6'){
		return '木材';
	}else if(goodsType == '7'){
		return '家禽';
	}else if(goodsType == '8'){
		return '生鲜';
	}else if(goodsType == '9'){
		return '水果';
	}else if(goodsType == '10'){
		return '蔬菜';
	}else if(goodsType == '11'){
		return '食品(其它)';
	}else if(goodsType == '12'){
		return '建材';
	}else if(goodsType == '13'){
		return '矿产';
	}else if(goodsType == '14'){
		return '生产设备';
	}else if(goodsType == '15'){
		return '危险品';
	}else if(goodsType == '16'){
		return '其它';
	}else{
		return '';
	}
}

//订单状态
function getOrderStatusName(status){
	if(status == '0'){
		return '待确认';
	}else if(status == '1'){
		return '报价中';
	}else if(status == '2'){
		return '待发货';
	}else if(status == '3'){
		return '发货中';
	}else if(status == '4'){
		return '转运中';
	}else if(status == '5'){
		return '已到达';
	}else if(status == '6'){
		return '已完成';
	}else if(status == '7'){
		return '已取消';
	}else{
		return '';
	}
}

//车辆状态
function getTruckStatusName(status){
	if(status == '0'){
		return '空车';
	}else if(status == '1'){
		return '配送中';
	}else if(status == '2'){
		return '返程';
	}else if(status == '3'){
		return '保养';
	}else{
		return '';
	}
}

//仓储类型
function getWareHouseTypeName(type){
	if(type == '0'){
		return '普通仓储';
	}else if(type == '1'){
		return '恒温仓储';
	}else if(type == '2'){
		return '冷藏仓储';
	}else if(type == '3'){
		return '货架仓储';
	}else if(type == '4'){
		return '危险品仓储';
	}else{
		return '';
	}
}

//求助状态
function getConsultingStatusName(status){
	if(status == '0'){
		return '求助中';
	}else if(status == '1'){
		return '已解决';
	}
}
