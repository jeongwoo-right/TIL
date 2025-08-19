package enumpackage;

public class EnumMain {

	public static void main(String[] args) {
		Day day1 = Day.MONDAY;
		System.out.println(day1.name());
		System.out.println(day1.valueOf("MONDAY"));
		System.out.println(day1.ordinal());
		
		System.out.println();
		
		Day2 day2 = Day2.FRIDAY;
		System.out.println(day2.name());
		System.out.println(day2.valueOf("SATURDAY"));
		System.out.println(day2.label());
		System.out.println(day2.ordinal());
	}

}

//enum Role {
//	ADMIN("관리자"),
//	USER("일반 회원"),
//	NONUSER("비회원")
//	;
//	// 게스트하우스 조회 메뉴 - 회원 + 비회원 + 관리자
//	// 예약 메뉴 - 회원 + 관리자
//	// 게스트하우스 추가 메뉴 - 관리자
//}