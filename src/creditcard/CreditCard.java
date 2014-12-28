package creditcard;

import java.util.Date;

import framework.Account;
import framework.EntryType;
import framework.IEntry;

public class CreditCard extends Account {

	private double previousBalance;
	
	private double totalCharges;
	
	private double totalCredit;
	
	private double totalDue;
	
	private Date expiryDate;
	
	private double minimumPayment;
	
	
	
	@SuppressWarnings("deprecation")
	public CreditCard() {
		super();
		this.expiryDate = new Date();
		this.expiryDate.setYear(this.expiryDate.getYear()+5);
	}

	public double getPreviousBalance() {
		if(previousBalance==0)
			this.previousBalance=getBalance();
		return previousBalance;
	}

	public void setPreviousBalance(double previousBalance) {
		this.previousBalance = previousBalance;
	}

	public double getTotalCharges() {
	
		return totalCharges;
	}

	public void setTotalCharges(double totalCharges) {
		this.totalCharges = totalCharges;
	}

	public double getTotalCredit() {
		for (IEntry entry : getHistory()) {
			if(entry.getEntryType().equals(EntryType.WithDraw))
				this.totalCharges+=entry.getAmount();
			else
			
				this.totalCredit+=entry.getAmount();
	}
		return totalCredit;
	}

	public void setTotalCredit(double totalCredit) {
		this.totalCredit = totalCredit;
	}

	public double getTotalDue() {
		return totalDue=getMinimumPayment()*getBalance()/100;
	}

	public void setTotalDue(double totalDue) {
		this.totalDue = totalDue;
	}

	@Override
	public void history() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAccNumber(int number) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public double getBalance() {
		// TODO Auto-generated method stub
		//setBalance(previousBalance-totalCredit+totalCharges+(previousBalance-totalCredit));
		return super.getBalance();
	}

	public double getMinimumPayment() {
		return minimumPayment;
	}

	public void setMinimumPayment(double minimumPayment) {
		this.minimumPayment = minimumPayment;
	}

}
