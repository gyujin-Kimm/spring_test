package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach                 // 테스트 실행하기 전에 무조건 실행하도록 하는 것. 테스트가 2개 있으면 2번 돌아감.
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join(){
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // join한 것과 찾은거랑 똑같다면 ..
        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);        // Assertions == 검증
    }
}

// 단위 테스트를 만드는 것이 정말 중요.
// 단위 테스트란 오롯이 자바 코드로 테스트하는 것.
