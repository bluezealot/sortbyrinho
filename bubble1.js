for(var i = 0; i < SortData.getDataCount(); i ++){
	for(var j = 0; j < SortData.getDataCount(); j ++){
		if(SortData.getDataAt(j) > SortData.getDataAt(i)){
			SortData.swap(i, j);
		}
	}
}
SortData.setSortComplete(true);