package di_spring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// Component Annotation
// new EspressoMachine() - Spring에게 부탁하는 코드(EspressoMachine 하나 만들어줘)
@Component
@Primary /*나를 우선해줘*/
public class EspressoMachine implements CoffeeMachine {
	 
	EspressoMachine() {
		System.out.println("EspressoMachine 객체생성");
	}
	
	@Override
	public String brew() {
		return "에스프레소 머신으로 커피 추출합니다";
	}
}
