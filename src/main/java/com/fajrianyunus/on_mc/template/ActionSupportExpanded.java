package com.fajrianyunus.on_mc.template;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class ActionSupportExpanded extends ActionSupport implements Preparable, ServletRequestAware, ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -135438571314229365L;
	
	protected Map<String, Object> session;
	protected HttpServletRequest httpServletRequest;
	protected HttpServletResponse httpServletResponse;

	@Override
	public void prepare() {
		//nothing here
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.httpServletRequest = arg0;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.httpServletResponse = arg0;
	}
	
	@Override
	public String execute() throws Exception {
		return super.execute();
	}

}
