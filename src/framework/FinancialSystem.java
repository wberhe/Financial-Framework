package framework;

import java.util.ArrayList;
import java.util.List;

import framework.views.MainGUI;

public class FinancialSystem {
	
	MainGUI gui ;
	FinancialFactory factory;
	List<ICustomer> customers;
	protected TransactionManager txManager;
	
	
	@SuppressWarnings("static-access")
	public FinancialSystem() {
		// TODO Auto-generated constructor stub
		this.customers = new ArrayList<ICustomer>();
		txManager=TransactionManager.getInstance();
	}
	public void setGUI(MainGUI gui){
		this.gui=gui;
	}
	public void setFactory(FinancialFactory factory){
		this.factory=factory;
		}
	
	
	
	public void start(){
		this.gui.run();
		this.gui.setVisible(true);
	}

	public void addAccount(Object[] rowdata) {
		// TODO Auto-generated method stub
		
		
	}
	public FinancialFactory getFactory() {
		return factory;
	}
	public MainGUI getGui() {
		return gui;
	}
	public void setGui(MainGUI gui) {
		this.gui = gui;
	}
	public List<ICustomer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<ICustomer> customers) {
		this.customers = customers;
	}
	
	public void sendEmail(double amount,ICustomer customer){
		
	}
	
	public void deposite(int accNo,String custName, double amount ){
		ICustomer customer=null;
		for(ICustomer cust: customers){
			if(cust.getName().equals(custName)){
				customer=cust;
				break;
			}
		}
			
		Transaction tx=factory.getTransaction("D",amount);
		tx.setAccount(customer.getAccount());
		txManager.submit(tx);
		this.sendEmail(amount,customer);
	}


	public void withDraw(int accNo,String custName, double amount ){
		ICustomer customer=null;
		for(ICustomer cust: customers){
			if(cust.getName().equals(custName)){
				customer=cust;
				break;
			}
		}
			
		Transaction tx=factory.getTransaction("W",amount);
		tx.setAccount(customer.getAccount());
		txManager.submit(tx);
		
		this.sendEmail(amount,customer);
	}
	public List<ICustomer> calculateInterest() {
		// TODO Auto-generated method stub
		return this.customers;
		
	}
	public String report() {
		// TODO Auto-generated method stub
		StringBuilder report = new StringBuilder();
		for (ICustomer iCustomer : customers) {
			report.append(iCustomer.getName()+iCustomer.getAccount().getBalance());
		}
		return report.toString();
	}
}
