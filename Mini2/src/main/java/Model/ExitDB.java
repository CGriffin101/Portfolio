package Model;

import Controller.Exit;
import Controller.Room;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExitDB extends SQLiteDB{
    public ExitDB() throws SQLException, ClassNotFoundException {
    }

    public ArrayList<Exit> getExits(Room room) throws SQLException {
        ResultSet rs = null;
        ArrayList<Exit> exits = new ArrayList<>();
        rs = queryDB("select * from Exit where roomID = " + room.getId());
        while (rs.next()){
            Exit exit = new Exit();
            exit.setHomeRoomID(rs.getInt(2));
            exit.setDirection(rs.getString(3));
            exit.setTargetRoomID(rs.getInt(4));
            exits.add(exit);
        }
        close();
        return exits;
    }
}
