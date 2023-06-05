package com.example.calculator_workshop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculatorController {
    @FXML
    private TextField textResult;
    private String operation = "";
    private long firstNumber;
    private long secondNumber;

    public void number(ActionEvent ae){
        Button button = (Button) ae.getSource();
        String num = (button).getText();
        textResult.setText(textResult.getText() + num);
    }
    public void operation(ActionEvent ae){
        Button button = (Button) ae.getSource();
        String op = (button).getText();
        if(button.getText().equals("c")){
            textResult.setText("");
        }
        else if(!op.equals("=")){
            if(!operation.equals("")){
                return;
            }
            operation = op;
            firstNumber = Long.parseLong(textResult.getText());
            textResult.setText("");
        }
        else{
            if(operation.equals("")){
                return;
            }
            secondNumber = Long.parseLong(textResult.getText());
            calculate(firstNumber,secondNumber,operation);
            operation = "";
        }
    }

    public void calculate(long firstNumber , long secondNumber , String operation){
        switch (operation){
            case "*" :
                textResult.setText(firstNumber*secondNumber+"");
                break;
            case "/" :
                if(secondNumber == 0){
                    textResult.setText("0");
                }
                else textResult.setText(firstNumber/secondNumber + "");
                break;
            case "-" :
                textResult.setText(firstNumber-secondNumber + "");
                break;
            case "+" :
                textResult.setText(firstNumber+secondNumber + "");
                break;
            case "%" :
                textResult.setText(firstNumber%secondNumber + "");
                break;
        }

    }
}