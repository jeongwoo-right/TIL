package di;

public class EspressoMachine implements CoffeeMachine {
	@Override
	public String brew() {
		return "에스프레소 머신으로 커피 추출합니다";
	}
}
