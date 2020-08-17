
public class Calculator {
	private double operandOne;
	private double operandTwo;
	private String operation;
	private double results;
	
	public Calculator() {}
	
	public void setOperandOne(double num) {
		this.operandOne = num;
	}
	
	public void setOperandTwo(double num) {
		this.operandTwo = num;
	}
	
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public void performOperation() {
		if (this.operation.equals("+")) {
			this.results = operandOne + operandTwo;
		} else if (this.operation.equals("-")) {
			this.results = operandOne - operandTwo;
		}
	}
	
	public double getResults() {
		return this.results;
	}
}
