package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    //psvm
    public static void main(String[] args) {
//        AppConfig appConfig=new AppConfig();
//        MemberService memberService = appConfig.memberService();

        //ApplicationContext를 스프링 컨테이너(스프링빈)라 한다.
        //그래서 아래와 같이 적고 AppConfig를 매개변수로 넘기면, AppConfig에 있는 환경설정 정보들(@Bean을 적은 모든 것)을 스프링 빈에 넣어준다.
        //(앞에 Annotation이 붙는건 어노테이션을 기반으로 했다는 의미)
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        //getBean을 통해 필요한 스프링 빈을 찾을 수 있다. parameter=> 1.어떤 객체를 찾을지 name => 주로 메소드명, 2.반환 타입
        MemberService memberService= applicationContext.getBean("memberService", MemberService.class);
        Member member=new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember= memberService.findMember(1L);
        System.out.println("new Member = "+member.getName());
        System.out.println("find Member = "+findMember.getName());
    }
}
