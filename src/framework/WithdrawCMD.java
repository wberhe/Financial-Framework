package framework;

public class WithdrawCMD implements Transaction {
	IEntry entry;
    IAccount account;
    
	public WithdrawCMD(IEntry entry) {
		// TODO Auto-generated constructor stub
		this.entry=entry;
	}

	@Override
	public void setAccount(IAccount account) {
		this.account = account;
	}


	@Override
	public void execute() {
		account.withdraw(this.entry);

	}

}
