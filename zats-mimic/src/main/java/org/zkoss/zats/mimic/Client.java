/* Client.java

	Purpose:
		
	Description:
		
	History:
		Mar 20, 2012 Created by pao

Copyright (C) 2011 Potix Corporation. All Rights Reserved.
 */
package org.zkoss.zats.mimic;

import java.util.Map;


/**
 * Represent a client that can connect to zul files. It plays a role like a browser but without rendering anything.
 * @author Hawk
 * @author Dennis
 * @author Pao
 */
public interface Client {
	
	/**
	 * connect to a zul file, you have to provide the path that relative to the resource root folder
	 * @see ZatsEnvironment#init(String)
	 */
	DesktopAgent connect(String zulPath);
	
	/**
	 * connect to a zul file, you have to provide the path that relative to the resource root folder.
	 * You can pass arguments through a map into the specific zul file as including.
	 * @param zulPath the path of zul file. 
	 * @param args the arguments to pass.
	 * @return desktop agent.
	 * @see ZatsEnvironment#init(String)
	 */
	DesktopAgent connectAsIncluded(String zulPath, Map<String, Object> args);

	
	/**
	 * destroy this client, it will also destory all un-destroyed desktops that is created by this client
	 */
	void destroy();
	
	/**
	 * set cookie for the client, the cookie will be sent at every HTTP request.
	 * The cookie name can't start with '$'. Please refer to section 3.2.2 of RFC 2965.
	 * If the name existed, the origin value will be replaced.
	 * @param name The name of the cookie, it should not be null or empty string.  
	 * @param value The value of the cookie. If the value is null, it will erase this cookie.
	 * @since 1.1.0
	 */
	void setCookie(String name, String value);

	/**
	 * get value of cookie with specify name. 
	 * @param name The name of the cookie, it should not be null or empty string.
	 * @return the cookie value if cookie is existed or null otherwise.
	 * @since 1.1.0
	 */
	String getCookie(String name);

	/**
	 * get all cookies in an unmodifiable map.
	 * @return the map contained cookies.
	 * @since 1.1.0
	 */
	Map<String, String> getCookies();
	
	
	/**
	 * change the echo event handling mode.
	 * the default mode is EchoEventMode.IMMEDIATE
	 * @see EchoEventMode
	 * @param mode Control echo event handling mode. If null, do nothing.
	 * @since 1.1.0
	 */
	void setEchoEventMode(EchoEventMode mode);
	
	/**
	 * get the current echo event handling mode.
	 * the default mode is EchoEventMode.IMMEDIATE
	 * @see EchoEventMode
	 * @return current echo event handling mode.
	 * @since 1.1.0
	 */
	EchoEventMode getEchoEventMode();
}
