package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
// @Service
public class MemberService {
    private final MemberRepository memberRepository;

    // @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public int join(Member member) {

        validateDuplicateMember(member);    //  중복 회원 검증******
        memberRepository.save(member);
        return member.getId();
    }

    //  중복 회원 검증 *********************************
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }


    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(int memberId) {
        return memberRepository.findById(memberId);
    }
}
