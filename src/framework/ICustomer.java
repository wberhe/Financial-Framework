package framework;

public interface ICustomer {
	
	public void addAccount(IAccount account);
	public void removeAccount(IAccount account);
	public void setName(String name);
	public String getName();
	public IAccount getAccount();
	public String getEmail();
	

}
