package creditcard;

import framework.Customer;
import framework.IAccount;
import framework.ICustomer;

public class PopulateUtil {

	


	public static ICustomer populateCustomer(Object[] rowdata,
			ICustomer cust) {
		// TODO Auto-generated method stub
		Customer customer = (Customer) cust;
		customer.setName(rowdata[1].toString());
		customer.setCity(rowdata[2].toString());
		customer.setZip(Integer.parseInt(rowdata[6].toString()));
		customer.setState(rowdata[7].toString());
		customer.setEmail(rowdata[8].toString());
		
		 
		return customer;
	}

	public static IAccount populateAccount(Object[] rowdata, IAccount account,
			ICustomer customer) {
		// TODO Auto-generated method stub
		account.setAccNumber(Integer.parseInt(rowdata[0].toString()));
		account.setCustomer(customer);
		customer.addAccount(account);
		return account;
	}

	
}
