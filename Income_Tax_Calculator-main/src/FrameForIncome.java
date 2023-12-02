import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameForIncome implements ActionListener {
    JFrame frame;
    JLabel instructions, taxRate, datePanel;
    JTextField answer;
    JButton button, backButton;
    JPanel panel, taxRateAndBack, answerAndButton;
    int status;
    public FrameForIncome(int status){
        this.status = status;

        createTopPanel();
        createFirstPanel();
        createSecondPanel();
        createDatePanel();
        joinPanels();
        createFrame();
    }

    public void createFirstPanel(){
        answer = new JTextField(20);
        button = new JButton("Enter");
        button.addActionListener(this);
        answerAndButton = new JPanel();
        answerAndButton.add(answer);
        answerAndButton.add(button);
        answerAndButton.setBorder(new EmptyBorder(160,200,0,200));
        answerAndButton.setBackground(Color.BLACK);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        taxRateAndBack.setVisible(true);
        String answerValue = answer.getText();
        double income = Double.parseDouble(answerValue);
        TaxBracket x = createTaxFiler(this.status,income);
        double taxAmount = x.getTaxAmount();
        String output = String.format("With a filing status of " + this.getStatus() + " and income of $%.2f, your tax rate is " + (100 * x.taxRate) + "%% \n $%.2f",income,taxAmount);
        String outputText = output;
        taxRate.setText(output);

        answerAndButton.setVisible(false);
        if(e.getActionCommand().equals("Restart")){
            FrameForTaxes frameForTaxes = new FrameForTaxes();
            frame.dispose();
        }
    }
    public static TaxBracket createTaxFiler(int status, double income){
        switch (status){
            case 0: return new HeadOfHouseholdTaxBracket(income);
            case 1: return new SingleTaxBracket(income);
            case 2: return new MarriedSeparatlyTaxBracket(income);
            case 3: return new MarriedJointlyTaxBracket(income);
        }
        return null;
    }
    public String getStatus(){
        if(this.status == 0){
            return "Single filer";
        }else if (this.status == 1) {
            return "Head of Household";
        }else if(this.status == 2){
            return "Married: Separately";
        }else if(this.status == 3){
            return "Married: Jointly";
        }return null;
    }
    public void createTopPanel(){
        instructions = new JLabel("Please enter your annual income in the text box below");
        instructions.setBorder(new EmptyBorder(20,0,5,0));
        instructions.setHorizontalAlignment(0);
    }

    public void createSecondPanel(){
        taxRate = new JLabel();
        taxRate.setHorizontalAlignment(0);
        taxRate.setForeground(Color.WHITE);
        taxRateAndBack = new JPanel();
        backButton = new JButton("Restart");
        backButton.addActionListener(this);
        taxRateAndBack.add(taxRate);
        taxRateAndBack.add(backButton);
        taxRateAndBack.setBackground(Color.black);
        taxRateAndBack.setVisible(false);
        taxRateAndBack.setBackground(Color.BLACK);
        taxRateAndBack.setBorder(new EmptyBorder(160,200,0,200));
    }
    public void joinPanels(){
        panel = new JPanel();
        panel.setBackground(Color.black);
        panel.setLayout(new BorderLayout());
        panel.add(taxRateAndBack,BorderLayout.CENTER);
        panel.add(answerAndButton,BorderLayout.NORTH);
    }
    public void createDatePanel(){
        datePanel = new JLabel(String.valueOf(java.time.LocalDate.now()));
        datePanel.setHorizontalAlignment(0);
        datePanel.setBorder(new EmptyBorder(20,0,5,0));
    }
    public void createFrame(){
        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setMinimumSize(new Dimension(800,500));
        frame.add(instructions,BorderLayout.NORTH);
        frame.add(panel,BorderLayout.CENTER);
        frame.add(datePanel,BorderLayout.SOUTH);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

}
