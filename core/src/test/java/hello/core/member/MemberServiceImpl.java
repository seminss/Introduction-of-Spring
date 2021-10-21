package hello.core.member;

public class MemberServiceImpl implements MemberService {
    //문제점 : 오른쪽 부분이 구현체를 의존(따라서 추상화와 구체화 모두 의존 => DIP 위반 중)
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
