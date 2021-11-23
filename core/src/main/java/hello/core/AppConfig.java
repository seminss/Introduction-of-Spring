package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//스프링은 앱의 구성을 나타내는 설정 정보에 @Configuration을 적어주도록 되어 있음(따라서 AppConfig가 스프링컨테이너의 구성 정보)
//@Bean을 적은 메소드는 스프링 컨테이너에 등록이 됨

@Configuration
public class AppConfig {

    //@Bean이라 적힌 메소드를 모두 호출해서 반환된 객체를 컨테이너에 등록
    //스프링 빈은 @bean이 붙은 메서드 명을 스프링 빈의 이름으로 사용
    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberService");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.memberService");
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}