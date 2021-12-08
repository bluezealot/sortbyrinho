for(var i = 0; i < SortData.getDataCount(); i ++){
	for(var j = 0; j < SortData.getDataCount() - i - 1; j ++){
		if(SortData.getDataAt(j) > SortData.getDataAt(j + 1)){
			SortData.swap(j, j + 1);
		}
	}
}
SortData.setSortComplete(true);