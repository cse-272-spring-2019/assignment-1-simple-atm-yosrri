package wtvr;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HomeScreen {

    Scene scene;
    LoginWindow loginWindow;
    Stage stage;
    ATM newBalance;
    DepositScene depositScene;
    WithdrawScene withdrawScene;





    public HomeScreen(Stage stage, ATM newBalance) {
        this.stage = stage;
        this.newBalance = newBalance;
    }

    public void prepareSecondScene() {


        //Place where a text appear to tell you what to write
        Label balanceTextField = new Label();
        Label nextTransaction = new Label();
        Label prevTransaction = new Label();


        //Place where you write sth to the window ex:email, pass search.



        //Buttons to perform events
        Button depositButton = new Button("Deposit");
        Button withDrawButton = new Button("Withdraw");
        Button balanceInfoButton = new Button("Balance Info");
        Button goBackButton = new Button("Go Back");
        Button nextButton = new Button("Next Transaction ");
        Button prevButton = new Button ("Previous Transaction ");



        //To make a layout to arrange all these stuff on the screen
        GridPane grid = new GridPane();

        grid.add(withDrawButton, 0, 1);
        grid.add(balanceInfoButton, 0, 2);
        grid.add(depositButton, 0, 3);
        grid.add(nextButton,0,4);
        grid.add(nextTransaction,1,4);
        grid.add(prevButton,0,5);
        grid.add(prevTransaction,1,5);
        grid.add(goBackButton, 0, 0);
        grid.add(balanceTextField, 2, 2);


        scene = new Scene(grid, 500, 400);


        goBackButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //to go back to loginwindow
                stage.setScene(loginWindow.getScene());

            }
        });

        depositButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//
                stage.setScene(depositScene.getThirdScene());

            }


        });

        withDrawButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//
                stage.setScene(withdrawScene.getFourthScene());

            }
        });



        balanceInfoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {



                double b = newBalance.getbalance();
                balanceTextField.setText(String.valueOf(b));
               // newBalance.setBalanceInArray(String.valueOf(b));








            }
        });
        prevButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = newBalance.getPrev();
                balanceTextField.setText(a);

            }
        });


        nextButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = newBalance.getNext();
                balanceTextField.setText(a);
            }
        });


    }

    public Scene getSecondaryScene() {
        return this.scene;
    }


    public void setLoginWindow(LoginWindow loginWindow) {
        this.loginWindow = loginWindow;
    }
    public void setDepositScene(DepositScene depositScene){
        this.depositScene = depositScene;
    }
    public void setWithdrawScene(WithdrawScene withdrawScene){
        this.withdrawScene = withdrawScene;
    }
}
