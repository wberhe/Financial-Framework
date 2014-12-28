package framework;

public class DepositeCMD implements Transaction {
    IEntry entry;
    IAccount account;
    
	public DepositeCMD(IEntry entry) {
		this.entry=entry;
	}
	

	public void setAccount(IAccount account) {
		this.account = account;
	}


	@Override
	public void execute() {
		account.deposit(this.entry);

	}

}
