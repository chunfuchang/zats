/* FocusAgent.java

	Purpose:
		
	Description:
		
	History:
		Mar 20, 2012 Created by pao

Copyright (C) 2011 Potix Corporation. All Rights Reserved.
 */
package org.zkoss.zats.mimic.operation;

/**
 * To obtain or release focus of a component that inherits from InputElement, e.g. Datebox, Decimalbox, Textbox, Checkbox, Radio etc...
 * 
 * @author pao
 */
public interface FocusAgent extends OperationAgent {
	
	/**
	 * obtain focus.
	 */
	void focus();

	/**
	 * release focus.
	 */
	void blur();
}
