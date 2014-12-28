package framework;

import java.util.Date;

public class Entry implements IEntry{
	double amount;
	Date date;
	EntryType entryType;
	
	
	public Entry(double amount) {
		this.date=new Date();
		this.amount = amount;
		//this.entryType=type;
	}

	@Override
	public double getAmount() {
		// TODO Auto-generated method stub
		return this.amount;
	}

	@Override
	public Date getDate() {
		// TODO Auto-generated method stub
		return this.date;
	}

	@Override
	public void setAmount(double amount) {
		// TODO Auto-generated method stub
		this.amount=amount;
	}

	@Override
	public void setDate(Date date) {
		// TODO Auto-generated method stub
		this.date=date;
	}

	@Override
	public void setEntryType(EntryType type) {
		// TODO Auto-generated method stub
		this.entryType=type;
	}

	@Override
	public EntryType getEntryType() {
		// TODO Auto-generated method stub
		return this.entryType;
	}

}
