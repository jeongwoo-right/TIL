package interfacetest;

public class Main {

	public static void main(String[] args) {
		// lambda 표현식
		CalcInterface c = (i, j) -> {return i+j;};
		System.out.println(c.add(10, 20));
	} 

}
