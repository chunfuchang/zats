/* GenericFocusAgentBuilder.java

	Purpose:
		
	Description:
		
	History:
		Mar 20, 2012 Created by pao

Copyright (C) 2011 Potix Corporation. All Rights Reserved.
 */
package org.zkoss.zats.mimic.impl.operation;

import java.util.Map;

import org.zkoss.zats.mimic.ComponentAgent;
import org.zkoss.zats.mimic.impl.ClientCtrl;
import org.zkoss.zats.mimic.impl.EventDataManager;
import org.zkoss.zats.mimic.impl.OperationAgentBuilder;
import org.zkoss.zats.mimic.operation.FocusAgent;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
/**
 * The builder for focus agent
 * @author pao
 *
 */
public class GenericFocusAgentBuilder implements OperationAgentBuilder<ComponentAgent,FocusAgent> {
	public FocusAgent getOperation(final ComponentAgent target) {
		return new FocusAgentImpl(target);
	}
	
	public Class<FocusAgent> getOperationClass() {
		return FocusAgent.class;
	}

	class FocusAgentImpl extends AgentDelegator<ComponentAgent> implements FocusAgent {
		public FocusAgentImpl(ComponentAgent target) {
			super(target);
		}

		public void focus() {
			String desktopId = target.getDesktop().getId();
			String cmd = Events.ON_FOCUS;
			Map<String, Object> data = EventDataManager.getInstance().build(new Event(cmd, (Component)target.getDelegatee()));
			((ClientCtrl)target.getClient()).postUpdate(desktopId, target.getUuid(), cmd, data, false);
			((ClientCtrl)target.getClient()).flush(desktopId);
		}

		public void blur() {
			String desktopId = target.getDesktop().getId();
			String cmd = Events.ON_BLUR;
			Map<String, Object> data = EventDataManager.getInstance().build(new Event(cmd, (Component)target.getDelegatee()));
			((ClientCtrl)target.getClient()).postUpdate(desktopId, target.getUuid(), cmd, data, false);
			((ClientCtrl)target.getClient()).flush(desktopId);
		}
	}
}
