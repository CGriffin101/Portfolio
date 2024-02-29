package Model;

import Controller.Room;
import Controller.Exit;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoomDB extends SQLiteDB{
    public RoomDB() throws SQLException, ClassNotFoundException {
    }

    public Room getRoom(int roomID) throws SQLException {
        Room room = new Room();
        ResultSet rs = null;
        rs = queryDB("select * from Room where roomID == " + roomID);
        room.setId(roomID);
        room.setName(rs.getString(2));
        room.setDescription(rs.getString(3));
        room.setVisited(rs.getInt(4) != 0);
        room.setExits(getExitsFromDB(room));
        close();
        return room;
    }

    public ArrayList<Exit> getExitsFromDB(Room room) {
        ArrayList<Exit> exits = new ArrayList<>();
        try {
            ExitDB exitDB = new ExitDB();
            exits = exitDB.getExits(room);
            exitDB.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return exits;
    }

    public void updateDB(int roomID) throws SQLException {
        updateDB("UPDATE Room SET visited = 1 WHERE roomID = " + roomID);
        close();
    }
    public void resetRooms() throws SQLException {
        updateDB("UPDATE Room SET visited = 0");
        close();
    }
}
