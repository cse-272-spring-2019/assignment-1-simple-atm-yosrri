package wtvr;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.xml.soap.Text;

public class DepositScene {

    HomeScreen homeScreen;
    Stage stage;
    Scene scene;
    ATM deposit;




    public DepositScene(Stage stage, ATM deposit) {
        this.stage = stage;
        this.deposit = deposit;
    }


    public void prepareThirdScene() {



        TextField depositTextField = new TextField();

        Label depositValue = new Label();


        Button submit = new Button("Put Them");
        Button goBackButton = new Button("Go Back");


        GridPane grid = new GridPane();
        grid.add(goBackButton, 0, 0);
        grid.add(depositTextField, 4, 2);
        grid.add(depositValue, 4, 5);
        grid.add(submit, 4, 3);


        scene = new Scene(grid, 500, 400);

        goBackButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //to go back to HomeScreen
                stage.setScene(homeScreen.getSecondaryScene());

            }
        });

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // I took the deposit entered by client changed it to double sent it to setDeposit in the logic section and changed the balance and got the deposit to be printed out
                if (depositTextField.getText().equals("") ) {

                    stage.setScene(homeScreen.getSecondaryScene());}

                 else {


                    deposit.setDepositInArray(depositTextField.getText());



                    String a = depositTextField.getText();
                    deposit.setdeposit(new Double(a));
                    double b = deposit.getdeposit();
                    depositValue.setText("Your Deposit is " + String.valueOf(b));
                    depositTextField.clear();
                }

            }
        });


    }

    public Scene getThirdScene() {
        return this.scene;
    }

    public void setHomeScreen(HomeScreen homeScreen) {
        this.homeScreen = homeScreen;
    }


}
