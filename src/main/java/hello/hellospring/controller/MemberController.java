package hello.hellospring.controller;

import hello.hellospring.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired      //스프링 컨테이너에서 멤버서비스를 가져온고, dependenct Injection 의존관계를 주입해준다. controller와 memeberService가 연결됨.
    public MemberController(MemberService memberService) {  //memberService는 순수 자바 클래스이기 때문에 스프링이 알 방법이 없다.
        this.memberService = memberService;
    }
}
