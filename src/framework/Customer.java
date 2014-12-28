package framework;

public abstract class Customer implements ICustomer{
	String name,state,email,street,city;
	int zip;
	
	IAccount account;
	@Override
	public void addAccount(IAccount account) {
		// TODO Auto-generated method stub
		this.account=account;
	}
	
	@Override
	public void removeAccount(IAccount account) {
		// TODO Auto-generated method stub
		this.account=null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public IAccount getAccount() {
		return account;
	}

	public void setAccount(IAccount account) {
		this.account = account;
	}
	
	

}
