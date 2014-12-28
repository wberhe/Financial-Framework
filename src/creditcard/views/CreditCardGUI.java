package creditcard.views;

import java.awt.Event;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import framework.FinancialSystem;
import framework.views.MainGUI;

public class CreditCardGUI extends MainGUI{
	
	
	javax.swing.JButton JButton_PerAC = new javax.swing.JButton();
	
	public CreditCardGUI(FinancialSystem system) {
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
		setTitle("CreditCard App");
		ccardInit();
		
	}
	
	private void ccardInit(){
		
		
		SymAction lSymAction = new SymAction();
		JButton_PerAC.addActionListener(lSymAction);
		JButton_PerAC.setText("Add Credit Card account");
		getJPanel1().add(JButton_PerAC);
		JButton_PerAC.setBounds(24,20,192,33);
		
		getJButton_GenReport().setBounds(240,20,192,33);
		getJButton_GenReport().setText("Generate Monthly Bills");
        getJButton_Withdraw().setText("Charge");
	    getModel().addColumn("P/C");
	    getModel().addColumn("Type");

	}

}
