package Model;

import java.sql.SQLException;

public class PlayerDB extends SQLiteDB{
    public PlayerDB() throws SQLException, ClassNotFoundException {
    }

    public void updateDB(int roomID) throws SQLException {
        updateDB("UPDATE Player SET currentRoom = " + roomID +" WHERE playerID = 1");
        close();
    }
    public void resetPlayer() throws SQLException {
        updateDB("UPDATE Player SET currentRoom = 1 WHERE playerID = 1");
        close();
    }
}
