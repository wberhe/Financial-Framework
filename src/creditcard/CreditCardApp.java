package creditcard;

import java.util.List;

import creditcard.views.CreditCardGUI;
import banking.views.BankGUI;
import framework.FinancialFactory;
import framework.FinancialSystem;
import framework.IAccount;
import framework.ICustomer;
import framework.IEntry;
import framework.IInterest;
import framework.IPredicate;
import framework.Person;
import framework.Transaction;
import framework.views.MainGUI;

public class CreditCardApp  extends FinancialSystem{
	public static void main(String[] args) {
		
		
		FinancialSystem ccardSystem = new CreditCardApp();
		FinancialFactory ccardFactory = new CreditCardFactory();
		//MainGUI ccardGui = new CreditCardGUI(ccardSystem);
		MainGUI ccardGui = new CreditCardGUI(ccardSystem);

		ccardSystem.setGUI(ccardGui);
		ccardSystem.setFactory(ccardFactory);
		ccardSystem.start();
	}
	
	@Override
	public void addAccount(Object[] rowdata) {
		// TODO Auto-generated method stub
		//super.addAccount(rowdata);
		
		ICustomer customer = getFactory().getCustomer(rowdata[4].toString());
		
		customer = PopulateUtil.populateCustomer(rowdata,customer);
		
		IAccount account = getFactory().getAccount(rowdata[5].toString());
		
		account = PopulateUtil.populateAccount(rowdata,account,customer);
		
		getCustomers().add(customer);
		
	}
	
	@Override
	public List<ICustomer> calculateInterest() {
		// TODO Auto-generated method stub
		Transaction tx = this.getFactory().getTransaction("I", 0);
		IInterest gInterest = this.getFactory().getInterest("G");
		IInterest bInterest = this.getFactory().getInterest("B");
		IInterest sInterest = this.getFactory().getInterest("S");

		for (ICustomer customer : this.getCustomers()) {
			if(customer.getAccount() instanceof GoldACC)
				customer.getAccount().setInterest(gInterest);
			if(customer.getAccount() instanceof SilverACC)
				customer.getAccount().setInterest(sInterest);
			else
				customer.getAccount().setInterest(bInterest);
			
			tx.setAccount(customer.getAccount());
			txManager.submit(tx);
		}
		
		return this.getCustomers();
		
	}
	
	@Override
	public String report() {
		// TODO Auto-generated method stub
		StringBuilder report = new StringBuilder();
		for (ICustomer customer : getCustomers()) {
			report.append("CustomerName: "+customer.getName()+"\r\n");
			report.append("Account Number: "+customer.getAccount().getAccnum()+"\r\n");
			report.append("CreditCard Type: "+customer.getAccount().getClass().getSimpleName()+"\r\n");
			CreditCard cc = (CreditCard) customer.getAccount();
			report.append("Previous Balance: "+cc.getPreviousBalance()+"\r\n");
			report.append("Total Credits: "+cc.getTotalCredit()+"\r\n");
			report.append("Total Charges: "+cc.getTotalCharges()+"\r\n");
			report.append("New Balance "+cc.getBalance()+"\r\n");
			report.append("Total Amount Due:  "+cc.getTotalDue()+"\r\n");
			report.append("\n");
			
		}
		
		return report.toString();
	}
	
	@Override
	public void sendEmail(double amount, ICustomer customer) {
		// TODO Auto-generated method stub
		IPredicate predicate = new EmailLimit();
		
		EmailUtil.sendEmail(amount,customer,predicate);
	}
}
