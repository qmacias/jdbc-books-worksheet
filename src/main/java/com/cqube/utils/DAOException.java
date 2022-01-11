package com.cqube.utils;

public class DAOException extends Exception {
	
	private static final long serialVersionUID = -6150315899787575755L;

	public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOException(Throwable cause) {
        super(cause);
    }
    
}
