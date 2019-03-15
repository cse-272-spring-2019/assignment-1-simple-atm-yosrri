package wtvr;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javafx.scene.text.Font;
import javafx.stage.Stage;


public class LoginWindow {

    ATM validation;
    Scene scene;
    HomeScreen homeScreen;
    Stage stage;
    //Constructor that takes stage from ATM application i dnt understand this tbh
    public LoginWindow(Stage stage){
        this.stage = stage;

    }



    public void prepareScene() {

        validation = new ATM();


        //Place where a text appear to tell you what to write
        Label balanceNumberLabel = new Label(" Account Number ");
        Label passwordLabel = new Label(" Password ");
        Label validationLabel = new Label();

        //Place where you write sth to the window ex:email, pass search.
        TextField balanceNumberField = new TextField();
        PasswordField passwordField = new PasswordField();

        //Buttons to perform events
        Button sumbit = new Button(" Enter ");

        //To make a layout to arrange all these stuff on the screen
        GridPane grid = new GridPane();

        grid.add(balanceNumberLabel, 0, 0);
        grid.add(passwordLabel, 0, 1);
        grid.add(balanceNumberField, 2, 0);
        grid.add(passwordField, 2, 1);
        grid.add(sumbit, 2, 2);
        grid.add(validationLabel,2,3);


        // the scene to the stage is treated like one element so it displays it with all what's in it
        scene = new Scene(grid, 600, 300);

        // When the button is pressed the code inside public void handler is initiated
        sumbit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String balanceNumber = balanceNumberField.getText();
                String password = passwordField.getText();


                if (!validation.validate(balanceNumber, password)) {

                    validationLabel.setText("Error Wrong Card Number Or Password");
                    validationLabel.setFont(new Font("bold", 25));




                } else {

                    validationLabel.setText("");
                    validationLabel.setFont(new Font("bold", 25));
                    stage.setScene(homeScreen.getSecondaryScene());


                }


            }
        });







    }


    public Scene getScene() {
        return this.scene;
    }

    public void setHomeScreen(HomeScreen homeScreen) {
        this.homeScreen = homeScreen;
    }



}
