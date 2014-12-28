package framework;

import java.util.Date;

public interface IEntry {

	public double getAmount();
	public Date getDate();
	
	public void setAmount(double amount);
	public void setDate(Date date);
	
	public void setEntryType(EntryType type);
	public EntryType getEntryType();
}
