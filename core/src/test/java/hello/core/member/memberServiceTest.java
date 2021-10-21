package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/*Test Code*/
//test code는 main에서 가시적으로 실행시켜서 확인하는 것과는 달리
//초록색으로 잘 실행되냐,, 빨강색으로 어디서 오류가 났냐,, 확인하는 느낌..?
public class memberServiceTest {
    MemberService memberService = new MemberServiceImpl();
    @Test
    void join(){
        //given
        Member member=new Member(1L, "member A", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember=memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
