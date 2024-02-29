package Model; /**
 * Class : Model.SQLiteDB.java
 *
 * @author: Rick Price
 * @version: 1.0
 * Course: ITEC 3860
 * Written: June 22, 2021
 * This class the base interface to the SQLite database
 * Purpose: Execute queries and updates in the SQLite database
 */

import java.sql.DriverManager;
import java.sql.SQLException;

/**Class: Model.SQLiteDB
 * @author Rick Price
 * @version 1.1
 * Course: ITEC 3860 Fall 2023
 * Written: Sep 12, 2023
 * This class – creates the wrapper around SQLite specific initializations.
 */
public class SQLiteDB extends DB {

    /** Constructor: Model.SQLiteDB
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public SQLiteDB() throws SQLException, ClassNotFoundException {
        //Build the connection String
        sJdbc = "jdbc:sqlite";
        sDriverName = "org.sqlite.JDBC";
        // register the driver
        Class.forName(sDriverName);
        sDbUrl = sJdbc + ":" + dbName;
        conn = DriverManager.getConnection(sDbUrl);
    }

    /** Constructor: Model.SQLiteDB
     * @param dbName
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public SQLiteDB(String dbName) throws SQLException, ClassNotFoundException {
        //Build the connection String
        sJdbc = "jdbc:sqlite";
        sDriverName = "org.sqlite.JDBC";
        // register the driver
        Class.forName(sDriverName);
        sDbUrl = sJdbc + ":" + dbName;

        this.dbName = dbName;
        conn = DriverManager.getConnection(sDbUrl);
    }
}
