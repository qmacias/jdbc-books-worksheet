package com.cqube.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOUtils {
	
    static public void close(PreparedStatement statement) throws DAOException {
        try {
        	if (!(statement == null)) {
        		statement.close();
        	}
        } catch (SQLException e) {
            throw new DAOException("Error en SQL", e);
        }
    }
    
    static public void close(ResultSet result) throws DAOException { 
        try {
        	if (!(result == null)) {
        		result.close();
        	}
        } catch (SQLException e) {
            throw new DAOException("Error en SQL", e);
        }
    }

}
