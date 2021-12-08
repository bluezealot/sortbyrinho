package com.bluezealot.ui;

import java.awt.Rectangle;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class FlatButton {
	
	private Rectangle m_Bounds = new Rectangle();
	private JButton m_Btn = new JButton("测试按钮");
	
	public FlatButton(String text) {
		m_Btn.setText(text);
		m_Bounds.setBounds(0, 0, 100, 24);
	}
	
	public void setSize(int width, int height) {
		m_Bounds.setSize(width, height);
	}
	
	public void setPosition(int x, int y) {
		m_Bounds.setLocation(x, y);
	}
	
	public JButton getComponent() {
		m_Btn.setBounds(m_Bounds);
		return m_Btn;
	}
	
	public void addActionListener(ActionListener l) {
		m_Btn.addActionListener(l);
	}

}
