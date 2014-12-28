package framework;

import banking.CheckingAccount;
import banking.SavingAccount;

public abstract class FinancialFactory {
	
	public ICustomer getCustomer(String type){
		if(type.equals("P"))
			return new Person();
		
		return new Company();
	}
	
	
	public abstract IAccount getAccount(String type);


	public  Transaction getTransaction(String type, double amount) {
		// TODO Auto-generated method stub
		IEntry entry= getEntry(amount);
		if(type.equals("D"))
			return new DepositeCMD(entry);
		
		else if(type.equals("W"))
			return new WithdrawCMD(entry);
		
		return new InterestCMD(entry);
	}


	private  IEntry getEntry(double amount) {
		
		return new Entry(amount);
	}


	public abstract IInterest getInterest(String type) ;

}
