package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import Model.*;
public class GameController {
    Player player = new Player();
    public String getCurrentRoom(){
        Room room = null;
        try {
            SQLiteDB controller = new SQLiteDB();
            ResultSet rs = controller.queryDB("select * from Player");
            int currentRoomID = rs.getInt(3);
            room = new RoomDB().getRoom(currentRoomID);
            controller.close();
            player.setCurrentRoom(room);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        assert room != null;
        return room.toString();
    }

    public void moveRoom(String userInput) {
        if(userInput.equalsIgnoreCase("x")){
            return;
        }
        Room homeRoom = player.getCurrentRoom();
        try {
            int targetRoomID = homeRoom.verifyExit(userInput);
            RoomDB roomDB = new RoomDB();
            PlayerDB playerDB = new PlayerDB();
            roomDB.updateDB(homeRoom.getId());
            playerDB.updateDB(targetRoomID);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    public void resetGame() throws SQLException {
        try{
            RoomDB roomDB = new RoomDB();
            roomDB.resetRooms();
            PlayerDB playerDB = new PlayerDB();
            playerDB.resetPlayer();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
