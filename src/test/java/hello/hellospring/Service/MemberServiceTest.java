package hello.hellospring.Service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberService();
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    @AfterEach
    public void afterEach(){
        memberRepository.clearstore();
    }

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
    void dejoin(){
        //given
        Member member1 = new Member();
        member1.setName("you");
        Member member2 = new Member();
        member2.setName("you");
        //when
        memberService.join(member1);
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        //        try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e){
//            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원");
//        }
    }
    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}