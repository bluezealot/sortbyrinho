package com.bluezealot.threads;

import javax.swing.SwingUtilities;

import com.bluezealot.data.SortData;
import com.bluezealot.ui.MainForm;

public class Watcher {
	
	private MainForm m_RefreshTarget;
	private SortData m_WatchTarget;

	
	public Watcher(SortData watchTarget, MainForm refreshTarget) {
		m_RefreshTarget = refreshTarget;
		m_WatchTarget = watchTarget;
	}
	
	public void StartWatch() {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				while(!m_WatchTarget.getSortComplete()) {
					SwingUtilities.invokeLater(new Runnable(){
						public void run() {
							m_RefreshTarget.refresh();
						}
					});
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				}
				m_RefreshTarget.refresh();
			}
			
		});
		
		thread.start();
	}

}
