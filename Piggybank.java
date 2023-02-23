public class Piggybank {
  
  private int balance;
  
  public Piggybank() {
    this.balance = 0;
  }
  
  public void deposit(int amount) {
    this.balance += amount;
  }
  
  public void withdraw(int amount) {
    if (amount > balance) {
      System.out.println("Error: insufficient funds");
    } else {
      this.balance -= amount;
    }
  }
  
  public int checkBalance() {
    return this.balance;
  }
}