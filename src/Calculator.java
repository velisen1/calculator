import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10]; //10 buttons 0-9
    JButton[] functionButtons = new JButton[9]; //functional buttons listed below
    JButton addButton, subButton, mulButton, divButton, decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;

    Font myFont = new Font("Ink Free", Font.BOLD, 30); //Font used for all buttons

    double num1=0, num2=0, result=0;
    char operator; //holds arithmetic operation


    Calculator(){
        //calculator frame paremeters
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close the calculator
        frame.setSize(420, 550);
        frame.setLayout(null); //layout will be set later

        //textfield(display) parameters
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false); //makes textfield non interactable by clicking

        //setting function buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        negButton = new JButton("(-)");

        //adding function buttons to array for convenience
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        //setting buttons properties
        for(int i=0; i<9; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        //setting number buttons
        for(int i=0;i<10;i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430, 100, 50);
        negButton.setBounds(50, 430, 100, 50);

        //initializing panel of number buttons
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4,10,10)); //4x4 grid

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);



        frame.add(panel);
        frame.add(delButton);
        frame.add(negButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);

    }

    public static void main(String[] args) {

        Calculator calc = new Calculator();

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //functionalities of buttons
        for(int i=0;i<10;i++) {
            if(e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==decButton) {
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource()==addButton) {
            num1= Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if(e.getSource()==subButton) {
            num1= Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if(e.getSource()==mulButton) {
            num1= Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if(e.getSource()==divButton) {
            num1= Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource()==equButton) {
            num2=Double.parseDouble(textField.getText());
            //action dependent on used operator
            switch (operator) {
                case'+':
                    result=num1+num2;
                    break;
                case'-':
                    result=num1-num2;
                    break;
                case'*':
                    result=num1*num2;
                    break;
                case'/':
                    result=num1/num2;
                    break;
            }
            textField.setText(String.valueOf(result)); //displays result
            num1=result; //in the case we want to continue calculations we save the result


        }
        if (e.getSource()==clrButton) {
            textField.setText("");
        }
        if(e.getSource()==delButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i=0; i<string.length()-1;i++) { //this loop add back all char in string EXCEPT the last one
                textField.setText(textField.getText() + string.charAt(i));
            }
        }
        if (e.getSource()==negButton) {
            double temp = Double.parseDouble(textField.getText());
            temp*=-1;
            textField.setText(String.valueOf(temp));
        }
    }
}
