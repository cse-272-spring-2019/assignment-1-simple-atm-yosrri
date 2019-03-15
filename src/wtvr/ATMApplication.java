package wtvr;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ATMApplication extends Application {

    public static void main(String[] args) {


        //launch is inside the application library and its calls start
        launch(args);

    }

    @Override
    //start is used to set the stage of the application to work
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("ATM MACHINE");
        //i made an object of class ATM and made it accessible by making a constructor in every other class and sending it in the parameters in line26,27,28
        ATM account = new ATM();

        //i guess this sends wtvr window is working the stage to show it on
        LoginWindow loginWindow = new LoginWindow(primaryStage);
        HomeScreen homeScreen = new HomeScreen(primaryStage,account);
        DepositScene depositScene = new DepositScene(primaryStage,account);
        WithdrawScene withdrawScene = new WithdrawScene(primaryStage, account);
        // the scene to the stage is treated like one element so it displays it with all what's in it

        loginWindow.prepareScene();
        homeScreen.prepareSecondScene();
        depositScene.prepareThirdScene();
        withdrawScene.prepareFourthScene();

        //Making both classes know about each others, by making a method that takes a scene as a parameter and set it
        loginWindow.setHomeScreen(homeScreen);
        homeScreen.setLoginWindow(loginWindow);

        depositScene.setHomeScreen(homeScreen);
        homeScreen.setDepositScene(depositScene);

        withdrawScene.setHomeScreen(homeScreen);
        homeScreen.setWithdrawScene(withdrawScene);


            //we put the whole scene in the stage
        primaryStage.setScene(loginWindow.getScene());


        // Stage Only can hold one element so we put all elements in a scene
        primaryStage.show();


    }
}
