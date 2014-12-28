package banking;

import framework.IInterest;

public class CInterest implements IInterest {
	double interestRate;
	
	public CInterest(double iRate) {
		// TODO Auto-generated constructor stub
		this.interestRate=iRate;
	}
	@Override
	public double calculateInterest(double balance) {
		// TODO Auto-generated method stub
		return (balance*this.interestRate)/100;
	}

	}


