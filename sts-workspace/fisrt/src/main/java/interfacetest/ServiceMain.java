package interfacetest;

public class ServiceMain {

	//  선언 규칙. 
	// java application class (main 메소드를 가지고 있는 클래스)
	public static void main(String[] args) {
		
		CommonService service = null;

		// BoardService 요청
		if (args[0].equals("board")) {
			service = new BoardService();
		}
		
		// MemberService 요청
		else if (args[0].equals("member")) {
			service = new MemberService();
		}
		
		// Reservation 요청
		else if (args[0].equals("reservation")) {
			service = new ReservationService();
		}

		String result1 = service.getServiceName();
		String result2 = service.printServiceName(" 요청 중");

		System.out.println(result1);
		System.out.println(result2);
		
		
		
		// BoardService 요청
//		BoardService service1 = new BoardService();
//		String result1 = service1.getServiceName();
//		String result2 = service1.printServiceName(" 요청 중");
//
//		System.out.println(result1);
//		System.out.println(result2);
		
		// MemberService 요청
//		MemberService service1 = new MemberService();
//		String result1 = service1.getServiceName();
//		String result2 = service1.printServiceName(" 요청 중");
//
//		System.out.println(result1);
//		System.out.println(result2);
//		
		// CommonService 인터페이스 상속 구현 강제한 클래스들
		// BoardService, MemberService, ReservationService는 모두 CommonService 타입
		// CommonService 타입으로 간주
		
//		CommonService b1 = new BoardService();
//		CommonService b2 = new MemberService();
//		CommonService b3 = new ReservationService();
	}

}
