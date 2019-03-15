package wtvr;

public class ATM extends Main {
    //fields
    private String balanceNumber = "8246";
    private double balance = 2000;
    private double withDraw;
    private double deposit;
    private String password = "8888";
    private String[] history = new String[5];
    private int i = 0;






    //getters
    public double getbalance() {

        return balance;
    }

    public double getWithDraw() {
        return withDraw;
    }

    public double getdeposit() {
        return deposit;
    }

    //setters
    public double setWithDraw(double withDraw) {
        if (withDraw > balance) {

            return balance;
        } else {
            this.balance = balance - withDraw;
            this.withDraw = withDraw;
            return balance;
        }

    }

    public void setdeposit(double deposit) {

        this.balance = balance + deposit;

        this.deposit = deposit;
    }

    //Validation for account privacy
    public boolean validate(String balanceNumber, String password) {

        if (this.balanceNumber.equals(balanceNumber) && this.password.equals(password)) {

            return true;
        }
        return false;
    }

    public void setDepositInArray(String value) {
        arrayShifting();
        this.history[i] = "Deposit " + value;

        i++;

    }

    public void setWithdrawInArray(String value) {
        arrayShifting();
        this.history[i] = "Withdraw " + value;
        i++;
    }

//    public void setBalanceInArray(String value) {
//        arrayShifting();
//        history[i] = "Balance Info " + value;
//        i++;


//    }
    public void arrayShifting(){
        if(i==5){

            for(int j=0;j<4;j++){
                history[j]=history[j+1];}
                i=4;


        }

    }

    public String getPrev(){
        if(i==0){

            return "No prev Transaction";
        }
        else{


            return history[--i];}

    }
    public String getNext(){
        if(i==5){

            return "No Next Transaction";
        }

        else { System.out.println(i);
            return history[i++];}
    }
}

