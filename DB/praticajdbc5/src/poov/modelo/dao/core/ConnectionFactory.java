package poov.modelo.dao.core;

import java.sql.Connection;

public interface ConnectionFactory {

    public Connection getConnection();
    
}
