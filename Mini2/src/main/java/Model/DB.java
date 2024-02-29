package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class : Model.DB.java
 * @author: Rick Price
 * @version: 1.2
 * Course: ITEC 3860
 * Written: June 22, 2023
 * This class controls basic Model.DB functionality
 * Purpose:Has Query and Update Model.DB
 */
abstract public class DB {
    protected String dbName = "src/main/resources/Mini2.db";
    protected String sJdbc;
    protected String sDriverName;
    protected Connection conn;
    protected String sDbUrl;
    protected int timeout = 5;

    /**
     * Method: queryDB
     * Purpose: read from the database
     * @param sql
     * @return ResultSet
     * @throws SQLException
     */
    public ResultSet queryDB(String sql) throws SQLException {
        ResultSet rs = null;
        Statement stmt = conn.createStatement();
        stmt.setQueryTimeout(timeout);
        rs = stmt.executeQuery(sql);
        return rs;
    }

    /**
     * Method: updateDB
     * Purpose: Updates the database
     * @param SQL
     * @return boolean
     * @throws SQLException
     */
    public boolean updateDB(String SQL) throws SQLException {
        Statement stmt = conn.createStatement();
        boolean success = stmt.execute(SQL);
        return success;
    }

    /** Method: close
     * Purpose: Close the database connection
     * @throws SQLException
     * @return void
     */
    public void close() throws SQLException {
        conn.close();
    }

}
