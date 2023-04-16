package com.springboot.hello.controller;

import com.springboot.hello.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    // localhost:8080/api/v1/get-api/hello
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello() {
        // 4.3 이후 @RequestMapping은 더이상 사용하지 않는다.
        // 참고만 하자.
        return "Hello World";
    }

    @GetMapping(value = "/name")
    public String getName() {
        return "Flature";
    }

    @GetMapping(value = "variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        // 매개변수
        return variable;
    }

    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var) {
        // 매개변수 매핑
        return var;
    }

    // http://localhost:8080/api/v1/get-api/request1?name=name&email=email&org=org
    @GetMapping(value = "/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String org) {
        // 쿼리 파라미터
        return name + " " + email + " " + org;
    }

    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param) {
        /*
        String은 변경 불가능한 객체라 덧셈 연산시 메모리의 할당과 해제가 발생하여 성능이 하락한다.
        StringBuilder를 사용하면 변경 가능한 문자열 객체를 생성해 사용할 수 있다.
        entrySet() -> key, value (python 에서 items())
        forEach -> 반복
        map -> Map.Entry 객체
         */
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    // http://localhost:8080/api/v1/get-api/request3?name=name&email=email&organization=org
    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDto memberDto) {
        // dto를 이용해 쿼리파라미터를 받는다.
        return memberDto.toString();
    }
}
