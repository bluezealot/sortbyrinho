package com.bluezealot.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import com.bluezealot.data.SortData;
import com.bluezealot.script.JsEngine;
import com.bluezealot.threads.Executer;
import com.bluezealot.threads.Watcher;

public class MainForm {
	private SortData m_SortTarget = null;
	private JFrame m_MainForm = new JFrame("Main");
	private Executer m_Exe;
	private Watcher m_Watcher;
	
	private MainForm m_Form = null;
	
	private FlatButton m_CreateDataBtn = new FlatButton("Generate");
	private FlatButton m_RunBtn = new FlatButton("Run");
	private JTextArea m_JsText = new JTextArea();
	JsEngine m_Engine = new JsEngine();
	PaintPanel m_Paint = new PaintPanel();
	
	public void init() {
		m_MainForm.setSize(800, 768);
		m_MainForm.setLayout(null);
		m_MainForm.setLocationRelativeTo(null);
		m_MainForm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
		m_Paint.setBounds(100, 0, 700, 300);
        m_RunBtn.setPosition(0, 150);
        m_MainForm.add(m_CreateDataBtn.getComponent(), 0);
        m_MainForm.add(m_RunBtn.getComponent(), 1);
        m_MainForm.add(m_Paint, 2);
        JScrollPane pane=new JScrollPane(m_JsText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        pane.setBounds(100, 350, 700, 300);
        m_MainForm.add(pane, 3);
        m_CreateDataBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					m_SortTarget = SortData.createSortData(500);
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				m_Paint.setSortData(m_SortTarget);
				m_Paint.repaint();
			}
        });
        m_Form = this;
        m_RunBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					m_Exe = new Executer(m_Engine);
					m_Exe.startExecute(m_JsText.getText(), m_SortTarget);
					m_Watcher = new Watcher(m_SortTarget, m_Form);
					m_Watcher.StartWatch();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
				m_Paint.repaint();
				
			}
        	
        });
	}
	
	public void show() {
		m_MainForm.setVisible(true);
	}
	
	public void refresh() {
		m_Paint.repaint();
	}
	
}
