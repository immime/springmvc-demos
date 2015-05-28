package com.qiqi.demo.system;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.util.WebUtils;

/**
 * 获取当前WebApp的name
 * @author wenyong
 *
 */
public class WebAppNameListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		System.setProperty(AppConstants.WEB_APP_NAME_KEY, event.getServletContext().getContextPath());
		WebUtils.setWebAppRootSystemProperty(event.getServletContext());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.getProperties().remove(AppConstants.WEB_APP_NAME_KEY);
	}

}
