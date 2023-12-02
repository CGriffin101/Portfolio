import javax.swing.*;
import java.awt.*;

public class ButtonForTaxes{
    static int increment = 10;
    int x;
    int y;
    int width;
    int height;
    String name;
    public ButtonForTaxes(String name){
        this.width = 220;
        this.height = 100;
        this.name = name;
    }
    public JButton getButton(){
        JButton y = new JButton(this.name);
        y.setSize(200,100);
        return y;
    }
}
