package SSAFY.demo.test;

import org.springframework.web.bind.annotation.*;

// 사용자가 요청 -> 응답(HTML 파일)
// @Controller
// 사용자가 요청 -> 응답(Data)
@RestController
public class HttpControllerTest {

    // 인터넷 브라우저 요청은 무조건 get요청 밖에 할 수 없다

    private static final String TAG = "HttpControllerTest:";

    @GetMapping("/http/lombok")
    public String lombokTest(){
        Member m = Member.builder().username("wook").password("1234").email("wook7416@naver.com").build();
        System.out.println(TAG+"getter:"+m.getUsername());
        m.setUsername("jin");
        System.out.println(TAG+"setter:"+m.getUsername());
        return "lombok test 완료";
    }


//    @GetMapping("/http/get")
//    public String getTest(@RequestParam int id, @RequestParam String username) {
//        return "get 요청:" + id + "," + username;
//    }

    @GetMapping("/http/get")
    public String getTest(Member m) { // MessageConverter (스프링부트)
        return "get 요청:" + m.getId() + "," + m.getUsername() + "," + m.getPassword() + "," + m.getEmail();
    }

//    @PostMapping("/http/post")
//    public String postTest(Member m) {
//        return "post 요청"+ m.getId() + "," + m.getUsername() + "," + m.getPassword() + "," + m.getEmail();
//    }

    @PostMapping("/http/post") // text/plain, application/json
    public String postTest(@RequestBody Member m) { // MessageConverter (스프링부트)
        return "post 요청"+ m.getId() + "," + m.getUsername() + "," + m.getPassword() + "," + m.getEmail();
    }

    @PutMapping("/http/put") // update
    public String putTest(@RequestBody Member m) {
        return "put 요청 : "+ m.getId() + "," + m.getUsername() + "," + m.getPassword() + "," + m.getEmail();
    }

    @DeleteMapping("/http/delete")
    public String deleteTest() {
        return "delete 요청";
    }
}
