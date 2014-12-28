package banking.views;

import java.awt.Event;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import framework.FinancialSystem;
import framework.views.MainGUI;

public class BankGUI extends MainGUI{
	
	
	javax.swing.JButton JButton_PerAC = new javax.swing.JButton();
	javax.swing.JButton JButton_CompAC = new javax.swing.JButton();
	
	public BankGUI(FinancialSystem system) {
		// TODO Auto-generated constructor stub
		super(system);
		
		
		
	}
	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			
			if (object == JButton_PerAC)
				JButtonPerAC_actionPerformed(event);
				
			else if (object == JButton_CompAC)
				JButtonCompAC_actionPerformed(event);
			
		}
	}
	void JButtonCompAC_actionPerformed(java.awt.event.ActionEvent event)
	{
		/*
		 construct a JDialog_AddCompAcc type object 
		 set the boundaries and 
		 show it 
		*/
		
		JDialog_AddCompAcc pac = new JDialog_AddCompAcc(this);
		pac.setBounds(450, 20, 300, 330);
		pac.show();
		Object rowdata [] = getRowdata();
		if (newaccount){
            // add row to table
            rowdata[0] = accountnr;
            rowdata[1] = clientName;
            rowdata[2] = city;
            rowdata[3] = "0";
            rowdata[5] = accountType;
            rowdata[4] = "C";
            rowdata[6] = zip;
            rowdata[7] = state;
            rowdata[8] = email;
            
            getModel().addRow(rowdata);
            getFinancialSystem().addAccount(rowdata);
            getJTable1().getSelectionModel().setAnchorSelectionIndex(-1);
            newaccount=false;
        }

	}
	//String accountnr, clientName,street,city,zip,state,accountType,clientType,amountDeposit;
	public void JButtonPerAC_actionPerformed(java.awt.event.ActionEvent event)
	{
		/*
		 JDialog_AddPAcc type object is for adding personal information
		 construct a JDialog_AddPAcc type object 
		 set the boundaries and show it 
		*/
		
		JDialog_AddPAcc pac = new JDialog_AddPAcc(this);
		pac.setBounds(450, 20, 300, 330);
		pac.show();

		if (isNewaccount()){
            // add row to table
			Object rowdata [] = getRowdata();
            rowdata[0] = accountnr;
            rowdata[1] = clientName;
            rowdata[2] = city;
            rowdata[3] = "0";
            rowdata[5] = accountType;
            rowdata[4] = "P";
            rowdata[6] = zip;
            rowdata[7] = state;
            rowdata[8] = email;
            getModel().addRow(rowdata);
            getFinancialSystem().addAccount(rowdata);
            getJTable1().getSelectionModel().setAnchorSelectionIndex(-1);
            setNewaccount(false);
        }

       
        
    }
	
	


	
	@Override
	public void initGUI() {
		// TODO Auto-generated method stub
		super.initGUI();
		setTitle("Banking App");
		bankInit();
		
	}
	
	private void bankInit(){
		
		
		SymAction lSymAction = new SymAction();
		JButton_PerAC.addActionListener(lSymAction);
		JButton_CompAC.addActionListener(lSymAction);
		JButton_PerAC.setText("Add personal account");
		getJPanel1().add(JButton_PerAC);
		JButton_PerAC.setBounds(24,20,192,33);
		JButton_CompAC.setText("Add company account");
		JButton_CompAC.setActionCommand("jbutton");
		getJPanel1().add(JButton_CompAC);
		JButton_CompAC.setBounds(240,20,192,33);
		//JButton_CompAC.addActionListener(lSymAction);
	    getModel().addColumn("P/C");
	    getModel().addColumn("Ch/S");

	}

}
