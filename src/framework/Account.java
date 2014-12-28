package framework;

import java.util.ArrayList;
import java.util.List;

public abstract class Account implements IAccount{

	int accnum;
	double balance;
	List<IEntry> history;
	ICustomer customer;
	IInterest interest;
	
	
	
	public Account() {
		this.history =new ArrayList<IEntry>();
	}
	public int getAccnum() {
		return accnum;
	}
	public void setAccnum(int accnum) {
		this.accnum = accnum;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public List<IEntry> getHistory() {
		return history;
	}
	public void setHistory(List<IEntry> history) {
		this.history = history;
	}
	public ICustomer getCustomer() {
		return customer;
	}
	public void setCustomer(ICustomer customer) {
		this.customer = customer;
	}
	
	@Override
	public void deposit(IEntry entry) {
		// TODO Auto-generated method stub
		this.setBalance(this.getBalance()+entry.getAmount());
		entry.setEntryType(EntryType.Deposit);
		this.getHistory().add(entry);
	}
	 @Override
	public void withdraw(IEntry entry) {
		// TODO Auto-generated method stub
		 this.setBalance(this.getBalance()-entry.getAmount());
		 entry.setEntryType(EntryType.WithDraw);
		 this.getHistory().add(entry);
			
	}
	public IInterest getInterest() {
		return interest;
	}
	public void setInterest(IInterest interest) {
		this.interest = interest;
	}

	@Override
	public void addInterest(IEntry entry) {
		// TODO Auto-generated method stub
		double iAmount = this.interest.calculateInterest(this.balance);
		entry.setAmount(iAmount);
		entry.setEntryType(EntryType.Interest);
		this.getHistory().add(entry);
		this.balance+=iAmount;
		
	}

}
