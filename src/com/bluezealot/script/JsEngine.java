package com.bluezealot.script;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

import com.bluezealot.data.SortData;

public class JsEngine {
	private Context m_Context = null;
	private SortData m_SortData = null;
	private Scriptable m_Scope;
	
	public SortData getSortData() {
		return m_SortData;
	}
	
	public JsEngine(){
		
	}
	
	public void Run(String script, SortData data) throws Throwable {
		m_Context = Context.enter();
		try {
			m_Scope = m_Context.initStandardObjects();
			m_Context.setOptimizationLevel(-1);
			m_Context.setLanguageVersion(Context.VERSION_1_8);
			ScriptableObject.defineClass(m_Scope, SortData.class);
			m_SortData = (SortData) m_Context.newObject(m_Scope, "SortData");
			m_SortData.copy(data);
			m_Scope.put("SortData", m_Scope, m_SortData);
			m_Context.evaluateString(m_Scope, script, null, 1, null);
		}finally {
			Context.exit();
		}
	}

}
