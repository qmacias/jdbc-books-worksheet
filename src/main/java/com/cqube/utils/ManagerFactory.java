package com.cqube.utils;

import java.sql.Connection;

import com.cqube.controller.common.IManagerController;
import com.cqube.controller.impl.ManagerControllerImpl;
import com.cqube.persistence.common.IManagerDAO;
import com.cqube.persistence.impl.ManagerDAOImpl;
import com.cqube.service.common.IManagerService;
import com.cqube.service.impl.ManagerServiceImpl;
import com.cqube.service.proxy.ManagerProxyImpl;
import com.cqube.service.proxy.common.IManagerProxy;

public class ManagerFactory {
	public static IManagerController getManagerController(Connection connection) {
		return new ManagerControllerImpl(getMProxy(getMService(getMDAO(connection))));
	}
	
	private static IManagerProxy getMProxy(IManagerService serviceManager) {
		return new ManagerProxyImpl(serviceManager);
	}
	
	private static IManagerService getMService(IManagerDAO daoManager) {
		return new ManagerServiceImpl(daoManager);
	}
	
	private static IManagerDAO getMDAO(Connection connection) {
		return new ManagerDAOImpl(connection);
	}
	
}
