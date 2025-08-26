package swaggertest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;

@RestController("swaggercontroller")
@RequestMapping("/swagger")
@Tag(name="회원관리", description = "crud 기능 구현")
public class UserController {

    private Long id = 1L;
    private List<User> userList = new ArrayList<>();

    // 회원 등록
    @Operation(summary = "회원등록", description="회원가입 시 호출 api")
    @Parameters({
    		@Parameter(name="name", description="회원이름", example="배나불리"),
    		@Parameter(name="password", description="회원암호", example="BaenaBully123!@#")
    })
    @ApiResponses({
    	@ApiResponse(responseCode="200", description = "성공"),
    	@ApiResponse(responseCode="4xx", description = "실패")
    })
    @PostMapping("/user")
    public String addUser(@RequestBody UserAddDTO userAddDto) {
        userList.add(new User(id, userAddDto.getName(), userAddDto.getPassword()));
        return id++ + "번 " +  userAddDto.getName() + " 회원 등록 완료";
    }

    // 회원 1명 조회
    @GetMapping("/user/{id}")
    public UserDTO findUser(@PathVariable("id") int id) {
        User findUser = userList.get(id-1);
        return new UserDTO(findUser.getId(), findUser.getName());
    }

    // 회원 전체 조회
    @GetMapping("/user/list")
    public All findAllUsers() {
        List<UserDTO> userDtos = userList.stream()
                .map(m -> new UserDTO(m.getId(), m.getName()))
                .collect(Collectors.toList());

        return new All(userDtos.size(), userDtos);
    }
    
    @PutMapping("/user/{id}")
    public UserDTO put(@PathVariable("id") Long id, @RequestBody(required = true) UserAddDTO userAddDTO) {
    	User findUser = userList.get((int)(id-1));
    	findUser.setName(userAddDTO.getName());
        findUser.setPassword(userAddDTO.getPassword());
        return new UserDTO(findUser.getId(), findUser.getName());
    }

   @DeleteMapping("/userdel")
    public void delete(@RequestParam("id") Long id) { 
	   User findUser = userList.remove((int)(id-1));
    }
    
    @Data
    @AllArgsConstructor
    static class All<T> {
        private int count;
        private T userData;
    }

    @Data
    @AllArgsConstructor
    static class UserDTO {
        private Long id;
        private String name;
    }

}
