package swaggertest;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
// 사용자 전달 파라미터값 저장 객체
public class UserAddDTO {
	@Schema(description = "가입회원이름-xxxx", example="배나불리")
    private String name;
    private String password;
}
