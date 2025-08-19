package di;

// 바리스타에게 요청하는 Main 고객
public class Main {
	public static void main(String[] args) {
		CoffeeMaker coffeeMaker = new CoffeeMaker(); // @Component
		
		// 1번 요청
		coffeeMaker.setCoffeeMachine(new EspressoMachine()); // @Component + @Autowired
		coffeeMaker.makeCoffee(); // @PostConstruct 메서드 객체 생성 직후에
		
		// 2번 요청
		coffeeMaker.setCoffeeMachine(new DripCoffeeMachine()); // @Component + @Autowired
		coffeeMaker.makeCoffee();
		
		// 3번 요청
		// 현재 coffeeMachine은 functional method이므로 lambda식 표현 가능
		coffeeMaker.setCoffeeMachine(/*CoffeeMachine타입의 객체들*/ () -> "또다른 커피머신으로 커피를 만듭니다");
		coffeeMaker.makeCoffee();
	}
}

// 클래스 간의 결합도 낮추는 방법
// 1. new 사용 X
// 2. 객체 종류 다양 / 교체될 수 있다 - 인터페이스 구조
