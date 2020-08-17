
public class CalculatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator calculator = new Calculator();
		calculator.setOperandOne(6.7);
		calculator.setOperandTwo(4.4);
		calculator.setOperation("+");
		calculator.performOperation();
		System.out.println(calculator.getResults());
		calculator.setOperation("-");
		calculator.performOperation();
		System.out.println(calculator.getResults());
	}

}
