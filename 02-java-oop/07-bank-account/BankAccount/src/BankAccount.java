import java.util.Random;
public class BankAccount {
	private String accountNumber;
	private double checkingBalance;
	private double savingsBalance;
	private static int totalAccounts;
	private static double totalDeposits;
	
	public BankAccount() {
		this.accountNumber = createRandomAccountNumber();
		totalAccounts++;
	}
	
	private String createRandomAccountNumber() {
		String accountNumber = "";
		Random r = new Random();
		for (int i = 0; i < 9; i++) {
			Integer currentNum = new Integer(r.nextInt(9));
			accountNumber += currentNum.toString(); ;			
		}
		System.out.println(accountNumber);
		return accountNumber;
	}
	
	public double getCheckingBalance() {
		System.out.println(this.checkingBalance);
		return this.checkingBalance;
	}
	
	public double getSavingsBalance() {
		System.out.println(this.savingsBalance);
		return this.savingsBalance;
	}
	
	public void deposit(String depositType, double amount) {
		totalDeposits += amount;
		if (depositType.equals("checking")) {
			this.checkingBalance += amount;
		} else if (depositType.equals("savings")) {
			this.savingsBalance += amount;
		}
	}
	
	public void withdraw(String withdrawType, double amount) {
		totalDeposits -= amount;
		if (withdrawType.equals("checking")) {
			if (this.checkingBalance - amount < 0) {
				System.out.println("Not enough funds in Checking.");
			} else {
				this.checkingBalance -= amount;	
				totalDeposits -= amount;
			}
		} else if (withdrawType.equals("savings")) {
			if (this.savingsBalance - amount < 0) {
				System.out.println("Not enough funds in Savings.");
			} else {
				this.savingsBalance -= amount;	
				totalDeposits -= amount;
			}
		}
	}
	
	public static void getTotalDeposits() {
		System.out.println("Total Deposits: " + totalDeposits);
	}
	
	public static void getTotalAccounts() {
		System.out.println("Total Accounts: " + totalAccounts);
	}
}
