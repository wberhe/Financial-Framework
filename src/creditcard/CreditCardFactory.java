package creditcard;

import framework.FinancialFactory;
import framework.IAccount;
import framework.IInterest;

public class CreditCardFactory extends FinancialFactory {

	@Override
	public IAccount getAccount(String type) {
		// TODO Auto-generated method stub
		
		if(type.equals("G"))
			return new GoldACC();
		else if(type.equals("S"))
			return new SilverACC();
		
		return new BronzeACC();
	}

	@Override
	public IInterest getInterest(String type) {		
		// TODO Auto-generated method stub

		if(type.equals("G"))
			return new GInterest(6);
		else if (type.equals("S"))
			return new SInterest(8);
		
		return new BInterest(10);
	}

	

}
