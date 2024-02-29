package Controller;

public class IllegalDirectionException extends RuntimeException{
    public IllegalDirectionException() {
        super();
    }
    public IllegalDirectionException(String message){
        super(message);
    }
}
