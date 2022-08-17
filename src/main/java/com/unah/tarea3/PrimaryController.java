package com.unah.tarea3;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PrimaryController {

    @FXML
    private Label LaPantalla;

    
    @FXML
    private void click_siete(ActionEvent event) {
        digitoPantalla("7");
    }

    @FXML
    private void click_ocho(ActionEvent event) {
        digitoPantalla("8");
    }

    @FXML
    private void click_nueve(ActionEvent event) {
        digitoPantalla("9");
    }

    @FXML
    private void click_cuatro(ActionEvent event) {
        digitoPantalla("4");
    }

    @FXML
    private void click_cinco(ActionEvent event) {
        digitoPantalla("5");
    }

    @FXML
    private void click_seis(ActionEvent event) {
        digitoPantalla("6");
    }

    @FXML
    private void click_uno(ActionEvent event) {
        digitoPantalla("1");
    }

    @FXML
    private void click_dos(ActionEvent event) {
        digitoPantalla("2");
    }

    @FXML
    private void click_tres(ActionEvent event) {
        digitoPantalla("3");
    }

    @FXML
    private void click_cero(ActionEvent event) {
        digitoPantalla("0");
    }

    @FXML
    private void click_punto(ActionEvent event) {
       if(!punto && !Digito){
           LaPantalla.setText("0.");
           Digito = true;
       }
       else if(!punto){
        String ValActual = LaPantalla.getText();
        LaPantalla.setText(ValActual + ".");
       }
       punto = true;
    }
    
    private boolean Digito= false;
    private boolean punto =false;
    private int numeOperandos = 0;
    private double Operando1, Operando2;
    private char Operador = ' ';
    
    private void digitoPantalla(String numero){
        if(!Digito && numero.equals("0"))
            return;
        
        if(!Digito){
            LaPantalla.setText("");
            punto = false;
        }
        
        String ValActual = LaPantalla.getText();
        LaPantalla.setText(ValActual + numero);
        Digito = true;
    }

    @FXML
    private void click_porcentaje(ActionEvent event) {
        if(numeOperandos == 0){
            LaPantalla.setText("0");
            return;
        }
        double valor = Double.parseDouble(LaPantalla.getText());
        double porcentaje = (Operando1 * valor)/100;
        LaPantalla.setText(String.valueOf(porcentaje));
        Digito = true;
        punto = true;
    }

    @FXML
    private void click_unoentreX(ActionEvent event) {
        double valor2 = Double.parseDouble(LaPantalla.getText());
        double resultado = 1 / valor2;
        LaPantalla.setText(String.valueOf(resultado));
        Digito = true;
        punto = true;
    }
    

    @FXML
    private void click_negativo(ActionEvent event) {
         if(Digito)
             LaPantalla.setText("-" + LaPantalla.getText());
    }

    @FXML
    private void click_borrar(ActionEvent event) {
        Digito = false;
        punto = false;
        numeOperandos = 0;
        Operando1 = 0;
        Operando2 = 0;
        Operador = ' ';
        LaPantalla.setText("0");
    }

    @FXML
    private void click_dividir(ActionEvent event) {
         evalOperador("/");
    }

    @FXML
    private void click_multiplicar(ActionEvent event) {
         evalOperador("*");
    }

    @FXML
    private void Click_restar(ActionEvent event) {
         evalOperador("-");
    }

    @FXML
    private void click_mas(ActionEvent event) {
         evalOperador("+");
    }

    @FXML
    private void click_igual(ActionEvent event) {
         evalOperador("=");
    }
    private void evalOperador(String Operador){
        
        if(Digito)
            numeOperandos++;
        if(numeOperandos == 1){
               Operando1 = Double.parseDouble(LaPantalla.getText());
            }
        if(numeOperandos == 2){
            Operando2 = Double.parseDouble(LaPantalla.getText());
            switch(this.Operador){
                case '+':
                    Operando1 = Operando1 + Operando2;
                    break;
                    case '-':
                    Operando1 = Operando1 - Operando2;
                    break;
                    case '*':
                    Operando1 = Operando1 * Operando2;
                    break;
                    case '/':
                    Operando1 = Operando1 / Operando2;
                    break;
                    case '=':
                    Operando1 = Operando2;
                    break;
            }
            LaPantalla.setText(String.valueOf(Operando1));
           numeOperandos = 1;
           punto =false; 
        }
        Digito = false;
        this.Operador = Operador.charAt(0);
    }
}