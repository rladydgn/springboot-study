package com.springboot.hello.controller;

import com.springboot.hello.dto.MemberDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    @PostMapping(value = "/member1")
    public String postMember(@RequestBody Map<String, Object> postData) {
        // json 형식으로 body에 데이터 받아와 postData에 매핑된다.
        // 값을 특정하기 어려울 때 사용한다.
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    @PostMapping(value = "/member2")
    public String postMemberDto(@RequestBody MemberDto memberDto) {
        // string 리턴
        return memberDto.toString();
    }

    @PostMapping(value = "/member3")
    public MemberDto ostMemberDto2(@RequestBody MemberDto memberDto) {
        // json 리턴
        // @RestController 때문에 자동으로 json으로 변환된다.
        // 이걸 안쓸거면 @ResponseBody 어노테이션을 메서드에 추가해 주면 된다.
        return memberDto;
    }
}
