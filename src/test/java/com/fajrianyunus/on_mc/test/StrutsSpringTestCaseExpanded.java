package com.fajrianyunus.on_mc.test;
import org.apache.struts2.StrutsSpringTestCase;
import org.springframework.test.context.support.GenericXmlContextLoader;
import org.springframework.web.context.WebApplicationContext;


public abstract class StrutsSpringTestCaseExpanded extends StrutsSpringTestCase {
	
	private static boolean applicationContextHasBeenSet = false;

	@Override
    protected void setupBeforeInitDispatcher() throws Exception {
        // only load beans from spring once
        if (!applicationContextHasBeenSet) {
            GenericXmlContextLoader xmlContextLoader = new GenericXmlContextLoader();
            applicationContext = xmlContextLoader.loadContext(getContextLocations());
            applicationContextHasBeenSet = true;
        }

        servletContext.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, applicationContext);
    }	
	
	@Override
	protected String[] getContextLocations() {
        return new String[]{"classpath:applicationContext_test.xml"};
    }	
	
}
