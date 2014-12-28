package creditcard;

import framework.Company;
import framework.EntryType;
import framework.ICustomer;
import framework.IEntry;
import framework.IPredicate;
import framework.Person;

public class EmailLimit implements IPredicate {

	@Override
	public boolean check(double amount, ICustomer customer) {
		// TODO Auto-generated method stub
		boolean result =false;
		if(amount>400){
			IEntry entry = customer.getAccount().getHistory().get(customer.getAccount().getHistory().size()-1);
			if(entry.getEntryType().equals(EntryType.WithDraw))
				result=true;
		}
		
		return result;
	}

}
