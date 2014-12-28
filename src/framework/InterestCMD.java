package framework;

public class InterestCMD implements Transaction {
	IAccount account;
	IEntry entry;
	IInterest interestAlogrithm;
	public InterestCMD(IEntry entry) {
		// TODO Auto-generated constructor stub
		this.entry=entry;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		account.addInterest(entry);
	}

	@Override
	public void setAccount(IAccount account) {
		// TODO Auto-generated method stub
		this.account=account;
	}

}
