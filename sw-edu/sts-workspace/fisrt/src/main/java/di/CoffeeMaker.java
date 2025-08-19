package di;

import org.springframework.stereotype.Component;

// 바리스타

@Component // 스프링
public class CoffeeMaker {
	CoffeeMachine coffeeMachine;
	
	// coffeeMachine 외부에서 받아올 수 있도록
	// DI 잘 되고 있음
	public void setCoffeeMachine(CoffeeMachine coffeeMachine) {
		this.coffeeMachine = coffeeMachine;
	}
	
	public void makeCoffee() {
		System.out.println(coffeeMachine.brew());
	}
}
