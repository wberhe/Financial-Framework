package creditcard;

import framework.IInterest;

public class BInterest implements IInterest {

private int interestRate;
	
	
	public BInterest(int interestRate) {
		this.interestRate = interestRate;
	}
	
	@Override
	public double calculateInterest(double balance) {
		// TODO Auto-generated method stub
		return (balance*this.interestRate)/100;	}

}
