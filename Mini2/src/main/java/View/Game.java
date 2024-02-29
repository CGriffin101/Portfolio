package View;
import Controller.GameController;
import java.sql.SQLException;
import java.util.Scanner;
public class Game {
    Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        Game game = new Game();
        game.startGame();
    }
    public void startGame(){
        System.out.println("Welcome to my adventure game. Please enter \"new\" to start a new game or" +
                "\n\"continue\" to continue the previous game");
        String newOrOld = input.nextLine().toLowerCase();
        if(newOrOld.equals("new")){
            startNewGame();
        }else if(newOrOld.equals("continue")){
            try {
                startGamePlayLoop();
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("Invalid input: " + newOrOld +
                    "\nPlease try again. \n");
            startGame();
        }
    }
    public void startNewGame(){
        //enter code to change player's current room to 1, change all the room's visited to 0
        System.out.println("You will proceed through rooms based upon your entries.\n" +
                "You can navigate by using the entire direction or just the first letter.\n" +
                "To exit(X) the game, enter X\n");
        GameController controller = null;
        controller = new GameController();
        try {
            controller.resetGame();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            startGamePlayLoop();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void startGamePlayLoop() throws SQLException, ClassNotFoundException {
        GameController controller = new GameController();
        String userInput = "";
        while(!userInput.equals("x")){
            try {
                System.out.println(controller.getCurrentRoom());
                System.out.println("What would you like to do?");
                userInput = input.nextLine().toLowerCase();
                controller.moveRoom(userInput);

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
