package wtvr;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class WithdrawScene {
    HomeScreen homeScreen;
    Stage stage;
    Scene scene;
    ATM withdraw;


    public WithdrawScene(Stage stage, ATM withdraw) {
        this.stage = stage;
        this.withdraw = withdraw;
    }

    public void prepareFourthScene() {


        TextField withdrawTextField = new TextField();
        Label withdrawValue = new Label();
        Button submit = new Button("Take Them Away");
        Button goBackButton = new Button("Go Back");

        GridPane grid = new GridPane();

        grid.add(goBackButton, 0, 0);
        grid.add(withdrawTextField, 4, 2);
        grid.add(withdrawValue, 4, 5);
        grid.add(submit, 4, 3);


        scene = new Scene(grid, 500, 400);

        goBackButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                stage.setScene(homeScreen.getSecondaryScene());

            }
        });

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {



                if (withdrawTextField.getText().equals("")) {
                    stage.setScene(homeScreen.getSecondaryScene());
                }
                    else {




                    if (new Double(withdrawTextField.getText()) > withdraw.getbalance()) {

                        withdrawValue.setText("Poor You..");
                    } else {

                        withdraw.setWithdrawInArray(withdrawTextField.getText());

                        withdraw.setWithDraw(new Double(withdrawTextField.getText()));
                        double b = withdraw.getWithDraw();
                        withdrawValue.setText(" Your withdrawal is "+ String.valueOf(b));
                        withdrawTextField.clear();
                    }
                }
            }
        });


    }

    public Scene getFourthScene() {
        return this.scene;
    }

    public void setHomeScreen(HomeScreen homeScreen) {
        this.homeScreen = homeScreen;
    }


}
