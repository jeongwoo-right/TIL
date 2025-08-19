package di_spring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class DripCoffeeMachine implements CoffeeMachine {
	DripCoffeeMachine() {
		System.out.println("DripCoffeeMachine 객체 생성");
	}
	
	@Override
	public String brew() {
		return "드립커피 머신으로 커피 추출합니다";
	}
}
