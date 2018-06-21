package solution;

public class Main {
	private Solution solution;
	
	public static void main(String[] args) {
		new Main().run();
	}
	
	private void run() {
		solution = new SolutionWithHibernate();
		solution.run();
		solution = new SolutionWithSpring();
		solution.run();
	}

}
