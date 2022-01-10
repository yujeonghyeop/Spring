package hello.hellospring.Service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Transactional
public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    public Long join(Member member){    //회원가입 서비스, 동명이인은 회원가입을 불허
        memberRepository.findByName(member.getName())    //들어온 member의 getname을 통해 해당 member가 있는지 확인
                .ifPresent(m->{ //해당 멤버가 존재하면
                    throw new IllegalStateException("이미 존재하는 회원");  //이 문구를 날려준다.
                });
        memberRepository.save(member);
        return member.getId();
    }

    public List<Member> findMembers(){  //전체 회원 조회
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
