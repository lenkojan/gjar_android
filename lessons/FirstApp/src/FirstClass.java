public class FirstClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		
		Robot robot1 = new Robot();
		robot1.setName("Jozo");
		String name = robot1.getName();
		System.out.println(name);
		
		int factorial = robot1.factorial(4);
		System.out.println(factorial);
	}

}
