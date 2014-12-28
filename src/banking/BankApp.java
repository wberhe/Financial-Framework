package banking;

import java.util.List;

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

public class BankApp  extends FinancialSystem{
	public static void main(String[] args) {
		
		
		FinancialSystem bankSystem = new BankApp();
		FinancialFactory bankFactory = new BankingFactory();
		MainGUI bankGui = new BankGUI(bankSystem);
		bankSystem.setGUI(bankGui);
		bankSystem.setFactory(bankFactory);
		bankSystem.start();
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
		IInterest pInterest = this.getFactory().getInterest("P");
		IInterest cInterest = this.getFactory().getInterest("C");
		
		for (ICustomer customer : this.getCustomers()) {
			if(customer instanceof Person)
				customer.getAccount().setInterest(pInterest);
			else
				customer.getAccount().setInterest(cInterest);
			
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
			report.append("Current Balance: "+customer.getAccount().getBalance()+"\r\n");
			report.append("Transactions: "+"\r\n");
			for (IEntry entry : customer.getAccount().getHistory()) {
				report.append("Amount: "+entry.getAmount()+"\t");
				report.append("Type: "+entry.getEntryType()+"\t");
				report.append("Date: "+entry.getDate()+"\t\n");
				
			}
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
