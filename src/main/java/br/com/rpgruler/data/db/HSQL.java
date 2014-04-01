package br.com.rpgruler.data.db;

import br.com.gmp.utils.system.SystemProperties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kaciano
 */
public class HSQL {

    public HSQL() {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
            Logger.getLogger(HSQL.class.getName()).log(Level.SEVERE, null, e);
            return;
        }
        try {
            Connection c = DriverManager.getConnection("jdbc:hsqldb:file:" + SystemProperties.USER_HOME + SystemProperties.FILE_SEPARATOR + ".RPG" + SystemProperties.FILE_SEPARATOR + "rpgdb", "sa", "");            
        } catch (SQLException ex) {
            Logger.getLogger(HSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("jdbc:hsqldb:file:" + SystemProperties.USER_HOME + SystemProperties.FILE_SEPARATOR + ".RPG" + SystemProperties.FILE_SEPARATOR + "rpgdb");
    }

    public static void main(String[] args) {
        HSQL hsql = new HSQL();
    }
}
