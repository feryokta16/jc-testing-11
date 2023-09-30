package com.juaracoding;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BankAccountTest {
    @Test
    //amount =100
    public void testSetAccount(){
        BankAccount bankAccount = new BankAccount();
        Assert.assertEquals(bankAccount.deposit(1000,100),1100);
    }
    @Test
    public void testString(){
        BankAccount bankAccount = new BankAccount();
        Assert.assertEquals(bankAccount.setAccount("Fery"),"Fery");
    }
    @Test
    public void testWitdraw(){
        BankAccount bankAccount = new BankAccount();
        double draw = bankAccount.withdraw(100,10);
        Assert.assertEquals(draw, 10);
    }
    @Test
    public void testCheckBallace(){
        BankAccount bankAccount = new BankAccount();
//        double check = bankAccount.checkBalance(100);
        Assert.assertEquals(bankAccount.checkBalance(100),100);
    }
    @Test void testDisplay() {
        BankAccount bankAccount = new BankAccount();
        Assert.assertEquals(bankAccount.display(10),10);
    }
}
