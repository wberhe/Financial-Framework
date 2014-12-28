package framework.views;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import framework.FinancialSystem;
import framework.ICustomer;
import banking.views.JDialog_AddPAcc;



public class MainGUI extends JFrame{

	public final void run() {
		// TODO Auto-generated method stub
		initGUI();
	}

	public  void initGUI() {
		// TODO Auto-generated method stub
		System.out.println("In Main GUI");
		myframe = this;

		setTitle("FinancialFramework");
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0,0));
		setSize(575,310);
		setVisible(false);
		JPanel1.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, JPanel1);
		JPanel1.setBounds(0,0,575,310);
		/*
		/Add five buttons on the pane 
		/for Adding personal account, Adding company account
		/Deposit, Withdraw and Exit from the system
		*/
        JScrollPane1 = new JScrollPane();
        model = new DefaultTableModel();
        JTable1 = new JTable(model);
        model.addColumn("AccountNr");
        model.addColumn("Name");
        model.addColumn("City");
        //model.addColumn("P/C");
        //model.addColumn("Ch/S");
        model.addColumn("Amount");
        rowdata = new Object[9];
        newaccount=false;
        
        
        JPanel1.add(JScrollPane1);
        JScrollPane1.setBounds(12,92,444,160);
        JScrollPane1.getViewport().add(JTable1);
        JTable1.setBounds(0, 0, 420, 0);
//        rowdata = new Object[8];
		
		JButton_PerAC.setText("Add personal account");
		//JPanel1.add(JButton_PerAC);
		JButton_PerAC.setBounds(24,20,192,33);
		JButton_CompAC.setText("Add company account");
		//JButton_CompAC.setActionCommand("jbutton");
		//JPanel1.add(JButton_CompAC);
		JButton_CompAC.setBounds(240,20,192,33);
		JButton_Deposit.setText("Deposit");
		JPanel1.add(JButton_Deposit);
		JButton_Deposit.setBounds(468,104,96,33);
		JButton_Withdraw.setText("Withdraw");
		JPanel1.add(JButton_Withdraw);
		JButton_Addinterest.setBounds(448,20,106,33);
		JButton_Addinterest.setText("Add interest");
		JPanel1.add(JButton_Addinterest);
		JButton_Withdraw.setBounds(468,164,96,33);
		JButton_Exit.setText("Exit");
		JPanel1.add(JButton_Exit);
		JButton_Exit.setBounds(468,248,96,31);
		
		JButton_PerAC.setActionCommand("jbutton");
		
		JPanel1.add(JButton_GenReport);
		JButton_GenReport.setBounds(468,200,96,31);
		JButton_GenReport.setText("GenerateReport");
		JButton_GenReport.setActionCommand("Report");

		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		JButton_Exit.addActionListener(lSymAction);
		JButton_PerAC.addActionListener(lSymAction);
		JButton_CompAC.addActionListener(lSymAction);
		JButton_Deposit.addActionListener(lSymAction);
		JButton_Withdraw.addActionListener(lSymAction);
		JButton_Addinterest.addActionListener(lSymAction);
		JButton_GenReport.addActionListener(lSymAction);
	}
	/****
     * init variables in the object
     ****/
   public String accountnr, clientName,street,city,zip,state,accountType,clientType,amountDeposit,email;
    public boolean isNewaccount() {
		return newaccount;
	}

	public void setNewaccount(boolean newaccount) {
		this.newaccount = newaccount;
	}

	public JTable getJTable1() {
		return JTable1;
	}

	public void setJTable1(JTable jTable1) {
		JTable1 = jTable1;
	}

	public FinancialSystem getFinancialSystem() {
		return financialSystem;
	}

	public void setFinancialSystem(FinancialSystem financialSystem) {
		this.financialSystem = financialSystem;
	}
	public boolean newaccount;
    private DefaultTableModel model;
    private JTable JTable1;
    private JScrollPane JScrollPane1;
    MainGUI myframe;
    private Object rowdata[];
    static public void main(String args[])
	{
		try {
		    // Add the following code if you want the Look and Feel
		    // to be set to the Look and Feel of the native system.
		    
		    try {
		        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    } 
		    catch (Exception e) { 
		    }
		    FinancialSystem system = new FinancialSystem();
		    system.setGUI(new MainGUI(system));
		    system.start();
			//Create a new instance of our application's frame, and make it visible.
			//(new MainFrm()).setVisible(true);
		} 
		catch (Throwable t) {
			t.printStackTrace();
			//Ensure the application exits with an error condition.
			System.exit(1);
		}
	}
    FinancialSystem financialSystem;
	public MainGUI(FinancialSystem system) {
		// TODO Auto-generated constructor stub
		this.financialSystem=system;
	}
	javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
	javax.swing.JButton JButton_PerAC = new javax.swing.JButton();
	javax.swing.JButton JButton_CompAC = new javax.swing.JButton();
	javax.swing.JButton JButton_Deposit = new javax.swing.JButton();
	javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();
	javax.swing.JButton JButton_Addinterest= new javax.swing.JButton();
	javax.swing.JButton JButton_Exit = new javax.swing.JButton();
	javax.swing.JButton JButton_GenReport = new javax.swing.JButton();
	void exitApplication()
	{
		try {
		    	this.setVisible(false);    // hide the Frame
		    	this.dispose();            // free the system resources
		    	System.exit(0);            // close the application
		} catch (Exception e) {
		}
	}

	class SymWindow extends java.awt.event.WindowAdapter
	{
		public void windowClosing(java.awt.event.WindowEvent event)
		{
			Object object = event.getSource();
			if (object == MainGUI.this)
				BankFrm_windowClosing(event);
		}
	}

	void BankFrm_windowClosing(java.awt.event.WindowEvent event)
	{
		// to do: code goes here.
			 
		BankFrm_windowClosing_Interaction1(event);
	}

	void BankFrm_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
		try {
			this.exitApplication();
		} catch (Exception e) {
		}
	}

	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_Exit)
				JButtonExit_actionPerformed(event);
			
			else if (object == JButton_Deposit)
				JButtonDeposit_actionPerformed(event);
			else if (object == JButton_Withdraw)
				JButtonWithdraw_actionPerformed(event);
			else if (object == JButton_Addinterest)
				JButtonAddinterest_actionPerformed(event);
			else if (object == JButton_GenReport)
				JButtonGenerateReport_actionPerformed(event);
			
		}
	}
	void JButtonGenerateReport_actionPerformed(java.awt.event.ActionEvent event)
	{
		JDialogGenBill billFrm = new JDialogGenBill();
		String report = getFinancialSystem().report();
		billFrm.getJTextField1().setText(report);
		billFrm.setBounds(450, 20, 400, 350);
		billFrm.show();
	    
	}
    
    //When the Exit button is pressed this code gets executed
    //this will exit from the system
    void JButtonExit_actionPerformed(java.awt.event.ActionEvent event)
	{
		System.exit(0);
	}



	void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event)
	{
	    // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >=0){
            String accnr = (String)model.getValueAt(selection, 0);
    	    
		    //Show the dialog for adding deposit amount for the current mane
		    JDialog_Deposit dep = new JDialog_Deposit(myframe,accnr);
		    dep.setBounds(430, 15, 275, 140);
		    dep.show();
    		
		    // compute new amount
            double deposit = Double.parseDouble(amountDeposit);
            String samount = (String)model.getValueAt(selection, 3);
            String custName = (String)model.getValueAt(selection, 1);
            String accNo = (String)model.getValueAt(selection, 0);
            double currentamount = Double.parseDouble(samount);
		    double newamount=currentamount+deposit;
		    getFinancialSystem().deposite(Integer.parseInt(accNo), custName, deposit);
		    model.setValueAt(String.valueOf(newamount),selection, 3);
		}
		
		
	}

	void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event)
	{
	    // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >=0){
            String accnr = (String)model.getValueAt(selection, 0);

		    //Show the dialog for adding withdraw amount for the current mane
		    JDialog_Withdraw wd = new JDialog_Withdraw(myframe,accnr);
		    wd.setBounds(430, 15, 275, 140);
		    wd.show();
    		
		    // compute new amount
            double amountWithDraw = Double.parseDouble(amountDeposit);
            String samount = (String)model.getValueAt(selection, 3);
            String custName = (String)model.getValueAt(selection, 1);
            String accNo = (String)model.getValueAt(selection, 0);
            double currentamount = Double.parseDouble(samount);
		    double newamount=currentamount-amountWithDraw;
		    
		    if (newamount <0){
		       JOptionPane.showMessageDialog(JButton_Withdraw, " Account "+accnr+" : balance is negative: $"+String.valueOf(newamount)+" !","Warning: negative balance",JOptionPane.WARNING_MESSAGE);
		      
		    } 
		    getFinancialSystem().withDraw(Integer.parseInt(accNo), custName, amountWithDraw);
		    model.setValueAt(String.valueOf(newamount),selection, 3);
		}
		
		
	}
	
	void JButtonAddinterest_actionPerformed(java.awt.event.ActionEvent event)
	{
		  JOptionPane.showMessageDialog(JButton_Addinterest, "Add interest to all accounts","Add interest to all accounts",JOptionPane.WARNING_MESSAGE);
		  List<ICustomer> customers = getFinancialSystem().calculateInterest();
		  
		 
		  for (int i = 0; i < model.getRowCount(); i++) {
			  model.setValueAt(String.valueOf(customers.get(i).getAccount().getBalance()),i, 3);
		}
	}

	
	public javax.swing.JPanel getJPanel1() {
		return JPanel1;
	}

	public void setJPanel1(javax.swing.JPanel jPanel1) {
		JPanel1 = jPanel1;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public Object[] getRowdata() {
		return rowdata;
	}

	public void setRowdata(Object[] rowdata) {
		this.rowdata = rowdata;
	}

	public javax.swing.JButton getJButton_Exit() {
		return JButton_Exit;
	}

	public void setJButton_Exit(javax.swing.JButton jButton_Exit) {
		JButton_Exit = jButton_Exit;
	}

	public javax.swing.JButton getJButton_GenReport() {
		return JButton_GenReport;
	}

	public void setJButton_GenReport(javax.swing.JButton jButton_GenReport) {
		JButton_GenReport = jButton_GenReport;
	}

	public javax.swing.JButton getJButton_Withdraw() {
		return JButton_Withdraw;
	}

	public void setJButton_Withdraw(javax.swing.JButton jButton_Withdraw) {
		JButton_Withdraw = jButton_Withdraw;
	}
	
	
}
