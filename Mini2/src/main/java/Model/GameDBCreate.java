package Model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Class : Model.GameDBCreate
 *
 * @author: Rick Price
 * @version: 1.0
 * Course: ITEC 3860 Fall 2023
 * Written: July 28, 2023
 * This class creates the View.Game db if it doesn't exist
 * Purpose: Creates the Model.DB for Mini View.Game 2
 */
public class GameDBCreate {
    SQLiteDB sdb;

    /**
     * Method: buildTables
     * Purpose: Build all tables
     *
     * @return void
     * @throws SQLException
     */
    public void buildTables() throws GameException {
        buildRoom();
        buildExit();
        buildPlayer();
    }

    /**
     * Method: buildRoom
     * Purpose: Build the Room table and load data
     *
     * @return void
     * @throws SQLException
     */
    public void buildRoom() throws GameException {
        try {
            sdb = new SQLiteDB();

            FileReader fr;
            try {
                fr = new FileReader("src/main/resources/Rooms.txt");
                Scanner inFile = new Scanner(fr);
                while (inFile.hasNextLine()) {
                    String sql = inFile.nextLine();
                    sdb.updateDB(sql);
                }
                inFile.close();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            //Close the Model.SQLiteDB connection since SQLite only allows one updater
        } catch (SQLException | ClassNotFoundException ex) {
            throw new GameException("Error creating table Room");
        }
        finally {
            if (sdb != null) {
                try {
                    //Close the Model.SQLiteDB connection since SQLite only allows one updater
                    sdb.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    /**
     * Method: buildExit
     * Purpose: Build the Item table and load data
     *
     * @return void
     * @throws SQLException
     */
    public void buildExit() throws GameException {
        FileReader fr;
        try {
            fr = new FileReader("src/main/resources/Exit.txt");
            sdb = new SQLiteDB();
            Scanner inFile = new Scanner(fr);
            while (inFile.hasNextLine()) {
                String sql = inFile.nextLine();
                sdb.updateDB(sql);
            }
            inFile.close();
        } catch (SQLException | ClassNotFoundException | FileNotFoundException ex) {
            throw new GameException("Error creating table Exit");
        }
        finally {
            if (sdb != null) {
                try {
                    //Close the Model.SQLiteDB connection since SQLite only allows one updater
                    sdb.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    /**
     * Method: buildPlayer
     * Purpose: Builds the Player table and loads a phantom record
     *
     * @return void
     * @throws GameException
     */
    public void buildPlayer() throws GameException {
        try {
            sdb = new SQLiteDB();
            String sql = "CREATE TABLE Player(playerID int not Null, playerName text not null, currentRoom int not null)";
            sdb.updateDB(sql);
            sql = "INSERT INTO Player(playerID, playerName, currentRoom) Values(1, 'Fred', 1)";
            sdb.updateDB(sql);

        } catch (SQLException | ClassNotFoundException ex) {
            throw new GameException("Error creating table Player");
        }
        finally {
            if (sdb != null) {
                try {
                    //Close the Model.SQLiteDB connection since SQLite only allows one updater
                    sdb.close();
                } catch (SQLException e) {
                }
            }
        }
    }
}
