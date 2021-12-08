package com.bluezealot.data;

import java.util.ArrayList;
import java.util.Random;

import org.mozilla.javascript.ScriptableObject;

@SuppressWarnings("serial")
public class SortData extends ScriptableObject{
	
	private int[] m_Indexes;
	
	private ArrayList<Integer> m_SortList = new ArrayList<Integer>();
	
	private int m_ScanIndex;
	
	private int m_SwapCount;
	
	private int m_ScanCount;
	
	private int m_MaxValue;
	
	private boolean m_SortComplete;
	
	public static final int MAX_DATA = 10000;
	
	public SortData() {
		
	}
	
	public void copy(SortData data) {
		this.reset(data.getMaxValue());
		this.m_Indexes = data.m_Indexes;
		this.m_SortList = data.m_SortList;
	}
	
	public void init(int dataCount) {
		Random rnd = new Random();
		ArrayList<Integer> sortTarget = new ArrayList<Integer>();
		for(int i = 0; i < dataCount; i ++) {
			int val = rnd.nextInt(SortData.MAX_DATA);
			sortTarget.add(val);
		}
		init(sortTarget);
	}
	
	public void init(ArrayList<Integer> sortTarget) {
		m_Indexes = new int[sortTarget.size()];
		int maxValue = 0;
		for(int i = 0; i < sortTarget.size(); i ++) {
			m_Indexes[i] = i;
			int val = sortTarget.get(i);
			if(val > maxValue) {
				maxValue = val;
			}
		}
		m_SortList = sortTarget;
		reset(maxValue);
	}
	
	private void reset(int maxValue) {
		m_MaxValue = maxValue;
		m_ScanIndex = 0;
		m_ScanCount = 0;
		m_SwapCount = 0;
		m_SortComplete = false;
	}
	
	public int getDataAt(int index) {
		m_ScanCount ++;
		m_ScanIndex = index;
		return m_SortList.get(m_Indexes[index]);
	}
	
	public void swap(int firstIndex, int secondIndex) {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		m_SwapCount ++;
		int first = m_Indexes[firstIndex];
		m_Indexes[firstIndex] = m_Indexes[secondIndex];
		m_Indexes[secondIndex] = first;
	}
	
	public int getCurrentScanIndex() {
		return m_ScanIndex;
	}
	
	public int getSwapCount() {
		return m_SwapCount;
	}
	
	public int getScanCount() {
		return m_ScanCount;
	}
	
	public int getDataCount() {
		return m_SortList != null ? m_SortList.size() : 0;
	}
	
	public int getMaxValue() {
		return m_MaxValue;
	}
	
	public boolean getSortComplete() {
		return m_SortComplete;
	}
	
	public void setSortComplete(boolean sortComplete) {
		m_SortComplete = sortComplete;
	}
	
	public static SortData createSortData(int dataCount) {
		SortData retVal = new SortData();
		retVal.init(dataCount);
		return retVal;
	}
	
	public static SortData copySortData(SortData src) {
		ArrayList<Integer> sortTarget = new ArrayList<Integer>();
		for(int i = 0; i < src.getDataCount(); i ++) {
			sortTarget.add(src.getDataAt(i));
		}
		SortData retVal = new SortData();
		retVal.m_SortList = sortTarget;
		retVal.m_MaxValue = src.m_MaxValue;
		return retVal;
	}
	
	@Deprecated
	private static ArrayList<Integer> generateData(int count){
		ArrayList<Integer> result = new ArrayList<Integer>();
		Random rnd = new Random();
		for(int i = 0; i < count; i ++) {
			int val = rnd.nextInt(SortData.MAX_DATA);
			result.add(val);
		}
		return result;
	}
	
	@Override
	public String getClassName() {
		return "SortData";
	}
	
	public int jsFunction_getDataAt(int index) {
		return this.getDataAt(index);
	}
	
	public void jsFunction_swap(int firstIndex, int secondIndex) {
		this.swap(firstIndex, secondIndex);
	}
	
	public int jsFunction_getDataCount() {
		return this.getDataCount();
	}
	
	public void jsFunction_setSortComplete(boolean sortComplete) {
		setSortComplete(sortComplete);
	}



}
