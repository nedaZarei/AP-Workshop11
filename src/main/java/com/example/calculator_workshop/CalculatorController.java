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
    private float firstNumber;
    private float secondNumber;

    public void number(ActionEvent ae){
        Button button = (Button) ae.getSource();

        if(button.getText().equals(".")){
            if(textResult.getText().length() == 0){
                textResult.setText("0.");
            }
            else {
                textResult.setText(textResult.getText() + ".");
            }
        }
        else{
            String num = button.getText();
            textResult.setText(textResult.getText() + num);
        }

    }
    public void operation(ActionEvent ae){
        Button button = (Button) ae.getSource();
        String op = button.getText();

        if(op.equals("c")){
            textResult.setText("");
        }
        else if(!op.equals("=")){
            if(!operation.equals("")){
                return;
            }
            operation = op;
            firstNumber = Float.parseFloat(textResult.getText());
            textResult.setText("");
        }
        else{
            if(operation.equals("")){
                return;
            }
            secondNumber = Float.parseFloat(textResult.getText());
            calculate(firstNumber,secondNumber,operation);
            operation = "";
        }
    }

    public void calculate(float firstNumber , float secondNumber , String operation){
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