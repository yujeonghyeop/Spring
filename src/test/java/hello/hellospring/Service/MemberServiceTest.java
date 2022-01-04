package hello.hellospring.Service;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberService();
    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("you");
        //when
        Long saveId = memberService.join(member);
        //then
        Member findMember   = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}