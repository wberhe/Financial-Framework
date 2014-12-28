package banking;

import framework.Company;
import framework.ICustomer;
import framework.IPredicate;
import framework.Person;

public class EmailLimit implements IPredicate {

	@Override
	public boolean check(double amount, ICustomer customer) {
		// TODO Auto-generated method stub
		boolean result =false;
		if(amount>500 && (customer instanceof Person))
			result=true;
		else if(customer instanceof Company)
			result=true;
		return result;
	}

}
