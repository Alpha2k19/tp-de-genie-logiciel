
package genie_lgiciel_tp.newpackage.com.groupe4.projets.connectionsample;


import java.sql.Connection;
import java.sql.SQLException;

public interface IConnection {
	Connection getConnection() throws SQLException;
}

