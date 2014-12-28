package framework;

public interface Transaction {
  public void execute();
  public void setAccount(IAccount account);
}
