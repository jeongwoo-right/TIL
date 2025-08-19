package di_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

// 바리스타

@Component // 스프링

public class CoffeeMaker {
	
	// 스프링 프레임워크 내부에서 CoffeeMachine 객체 생성되었다면, 자동으로 주입
	// SetCoffeeMachine이 없어도 됨(Component + Autowired)
	@Autowired
	// 2개 중에 우선할 것을 정해야 함(Drip or Espresso)
	CoffeeMachine coffeeMachine /*= 자동으로 주입해줘*/; 
	
	
	// coffeeMachine 외부에서 받아올 수 있도록
	// DI 잘 되고 있음
	public void setCoffeeMachine(CoffeeMachine coffeeMachine) {
		this.coffeeMachine = coffeeMachine;
	}
	
	@PostConstruct /*DI 완료된 후 자동으로 호출*/
	public void makeCoffee() {
		System.out.println(coffeeMachine.brew());
	}
	
	
	CoffeeMaker() {
		System.out.println("CoffeeMaker 객체 생성");
	}
}
