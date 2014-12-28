package banking;

import framework.FinancialFactory;
import framework.IAccount;
import framework.IInterest;

public class BankingFactory extends FinancialFactory {

	@Override
	public IAccount getAccount(String type) {
		// TODO Auto-generated method stub
		
		if(type.equals("S"))
			return new SavingAccount();
		
		return new CheckingAccount();
	}

	@Override
	public IInterest getInterest(String type) {
		// TODO Auto-generated method stub

		if(type.equals("P"))
			return new PInterest(6);
		
		return new CInterest(7);
	}

	

}
