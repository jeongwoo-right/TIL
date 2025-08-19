package enumpackage;

public enum Day {
    MONDAY, 	// 0
    TUESDAY, 	// 1
    WEDNESDAY, 	// 2
    THURSDAY, 	// 3
    FRIDAY,		// 4
    SATURDAY,	// 5
    SUNDAY;		// 6
}

enum Day2 {

    MONDAY("월요일"),
    TUESDAY("화요일"),
    WEDNESDAY("수요일"),
    THURSDAY("목요일"),
    FRIDAY("금요일"),
    SATURDAY("토요일"),
    SUNDAY("일요일")
    ;

    private final String label;

    // 생성자
    Day2(String label) {
        this.label = label;
    }
    
    // 메서드
    public String label() {
        return label;
    }

}
