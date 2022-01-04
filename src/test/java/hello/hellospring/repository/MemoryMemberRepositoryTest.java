package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearstore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("Yu");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();  //optional 에서 값을 꺼내야 하기 때문에 뒤에 .get을 붙여준다.
        System.out.println("result =" + (result ==member)); //  result에서 저장해준 값과 member의 값이 같으면 true를 반환한다.
        Assertions.assertEquals(member,result); //result 와 member가 값은지 검사해준다. 위와 다른점은 void라는 점이다.
        org.assertj.core.api.Assertions.assertThat(member).isEqualTo(result);   //
    }
    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("Lee");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("seo");
        repository.save(member2);
        Member result = repository.findByName("Lee").get();

        org.assertj.core.api.Assertions.assertThat(member1);
    }
    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("Kim");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Ku");
        repository.save(member2);
        List<Member> result = repository.findAll();
        org.assertj.core.api.Assertions.assertThat(result.size()).isEqualTo(2);
    }
}
