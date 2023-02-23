import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PiggybankGUI extends JFrame implements ActionListener {
  
  private Piggybank piggybank;
  private JLabel balanceLabel;
  private JTextField amountTextField;
  
  public PiggybankGUI() {
    this.piggybank = new Piggybank();
    
    setLayout(new FlowLayout());
    
    JButton depositButton = new JButton("Deposit");
    depositButton.addActionListener(this);
    add(depositButton);
    
    JButton withdrawButton = new JButton("Get my money");
    withdrawButton.addActionListener(this);
    add(withdrawButton);
    
    this.balanceLabel = new JLabel("Balance: " + this.piggybank.checkBalance());
    add(this.balanceLabel);
    
    this.amountTextField = new JTextField(10);
    add(this.amountTextField);
    
    setSize(250, 100);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    int amount = Integer.parseInt(this.amountTextField.getText());
    
    if (e.getActionCommand().equals("Deposit")) {
      this.piggybank.deposit(amount);
    } else if (e.getActionCommand().equals("Get my money")) {
      if (amount > piggybank.checkBalance()) {
        JOptionPane.showMessageDialog(this, "Error: There is not enough money", "Error", JOptionPane.ERROR_MESSAGE);
      } else {
        this.piggybank.withdraw(amount);
      }
    }
    
    this.balanceLabel.setText("Balance: " + this.piggybank.checkBalance());
    this.amountTextField.setText("");
  }
  
  public static void main(String[] args) {
    new PiggybankGUI();
  }
}
