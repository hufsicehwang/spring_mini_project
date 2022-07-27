package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

// @Service
public class MemberService {
    private final MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public int join(Member member) {

        memberRepository.save(member);
        return member.getId();
    }
    @Transactional
    public List<Member> findMembers() {

        return memberRepository.findAll();
    }
    @Transactional
    public Optional<Member> findOne(int memberId) {

        return memberRepository.findById(memberId);
    }
}
