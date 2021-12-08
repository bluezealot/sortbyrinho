package com.bluezealot.ui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.bluezealot.data.SortData;

@SuppressWarnings("serial")
public class PaintPanel extends JPanel{
	
	private SortData m_SortData;
	
	public void setSortData(SortData data) {
		m_SortData = data;
	}
	
	public PaintPanel() {
		super();
		this.setBackground(Color.WHITE);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintData(g);
	}
	
	private void paintData(Graphics g) {
		if(m_SortData != null) {
			g.clearRect(0, 0, getWidth(), getHeight());
			int unitHeight = (this.getHeight()*SortData.MAX_DATA/m_SortData.getMaxValue());
			int unitWidth = (this.getWidth()*SortData.MAX_DATA/m_SortData.getDataCount());
			for(int i = 0; i < m_SortData.getDataCount(); i ++) {
				g.drawRect((i*unitWidth)/SortData.MAX_DATA, 
						getHeight() - ((m_SortData.getDataAt(i)*unitHeight)/SortData.MAX_DATA),
						unitWidth/SortData.MAX_DATA, 
						(m_SortData.getDataAt(i)*unitHeight)/SortData.MAX_DATA);
			}
		}
	}
	
	

}
