//quick sort
function quickSort(left, right){
	if(left > right){
		return;
	}
	var leftIndex = left;
	var rightIndex = right;
	var baseValue = SortData.getDataAt(leftIndex);
	while(leftIndex != rightIndex){
		while(SortData.getDataAt(rightIndex) >= baseValue && leftIndex < rightIndex){
			rightIndex --;
		}
		while(SortData.getDataAt(leftIndex) <= baseValue && leftIndex < rightIndex){
			leftIndex ++;
		}
		if(leftIndex < rightIndex){
			SortData.swap(leftIndex, rightIndex);
		}
	}
	SortData.swap(left, leftIndex);
	quickSort(left, leftIndex-1);
	quickSort(leftIndex+1, right);
}

quickSort(0, SortData.getDataCount() - 1);
SortData.setSortComplete(true);