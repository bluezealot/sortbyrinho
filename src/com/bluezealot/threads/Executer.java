package com.bluezealot.threads;

import com.bluezealot.data.SortData;
import com.bluezealot.script.JsEngine;

public class Executer {
	
	private JsEngine m_JsEngine;
	
	public Executer(JsEngine jsEngine) {
		m_JsEngine = jsEngine;
	}
	
	public void startExecute( String script, SortData data) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					m_JsEngine.Run(script, data);
				} catch (Throwable e) {
					throw new RuntimeException(e);
				}
			}
			
		});
		thread.start();
	}

}
