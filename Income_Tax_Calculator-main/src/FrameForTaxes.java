import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class FrameForTaxes implements ActionListener {
    JFrame frame;
    JButton single;
    JButton head;
    JButton marriedJoin;
    JButton marriedSep;
    JLabel textArea, label;
    JPanel groupOfButtons;
    public FrameForTaxes(){
        createButtons();
        groupButtons();
        createTextArea();
        createDateLabel();
        createFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Single Filer")){
            FrameForIncome frame2 = new FrameForIncome(0);
            frame.setVisible(false);
            frame.dispose();
        }else if(e.getActionCommand().equals("Head of Household")){
            FrameForIncome frame2 = new FrameForIncome(1);
            frame.setVisible(false);
            frame.dispose();
        }else if(e.getActionCommand().equals("Married: Jointly")){
            FrameForIncome frame2 = new FrameForIncome(3);
            frame.setVisible(false);
            frame.dispose();
        }else if(e.getActionCommand().equals("Married: Separately")){
            FrameForIncome frame2 = new FrameForIncome(2);
            frame.setVisible(false);
            frame.dispose();
        }
    }
    public void createButtons(){
        ButtonForTaxes button1 = new ButtonForTaxes("Single Filer");
        single = button1.getButton();
        single.addActionListener(this);
        ButtonForTaxes button2 = new ButtonForTaxes("Head of Household");
        head = button2.getButton();
        head.addActionListener(this);
        ButtonForTaxes button3 = new ButtonForTaxes("Married: Jointly");
        marriedJoin = button3.getButton();
        marriedJoin.addActionListener(this);
        ButtonForTaxes button4 = new ButtonForTaxes("Married: Separately");
        marriedSep = button4.getButton();
        marriedSep.addActionListener(this);
    }
    public void groupButtons(){
        groupOfButtons = new JPanel();
        groupOfButtons.add(single);
        groupOfButtons.add(head);
        groupOfButtons.add(marriedSep);
        groupOfButtons.add(marriedJoin);
        groupOfButtons.setBackground(Color.BLACK);
        groupOfButtons.setBorder(new EmptyBorder(180,10,10,10));
    }
    public void createTextArea(){
        textArea = new JLabel("Please Select your filing status");
        textArea.setHorizontalAlignment(0);
        textArea.setBorder(new EmptyBorder(20,0,5,0));
    }
    public void createDateLabel(){
        label = new JLabel(String.valueOf(java.time.LocalDate.now()));
        label.setHorizontalAlignment(0);
        label.setBorder(new EmptyBorder(20,0,5,0));
    }
    public void createFrame(){
        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.add(textArea,BorderLayout.NORTH);
        frame.add(groupOfButtons,BorderLayout.CENTER);
        frame.add(label,BorderLayout.SOUTH);
        frame.setMinimumSize(new Dimension(800,500));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
