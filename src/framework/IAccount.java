package framework;

import java.util.List;

public interface IAccount {

	public void deposit(IEntry entry);
	public void withdraw(IEntry entry);
	public void history();
	public void setAccNumber(int number);
	public int getAccnum();
	public void setCustomer(ICustomer cust);
	
	public IInterest getInterest();
	
	public void setInterest(IInterest interest);
	public double getBalance();
	
	public List<IEntry> getHistory();
	public void addInterest(IEntry entry);
	
	
}
