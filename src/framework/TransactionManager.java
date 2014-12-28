package framework;

public class TransactionManager {
   
	public static TransactionManager instance= null;
	
	private TransactionManager(){
		}
	
	public static TransactionManager getInstance() {
		if(instance==null)
			instance = new TransactionManager();
		return instance;
	}

	public  void submit(Transaction tx){
		tx.execute();
	}
}
