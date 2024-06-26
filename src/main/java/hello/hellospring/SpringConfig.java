package hello.hellospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;

@Configuration
public class SpringConfig {
    // private final DataSource dataSource;
    // private final EntityManager em;

    // public SpringConfig(DataSource dataSource, EntityManager em) {
    // this.dataSource = dataSource;
    // this.em = em;
    // }

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    // Aop
    @Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }
    // @Bean
    // public MemberRepository memberRepository() {
    // // return new MemoryMemberRepository();
    // // return new JdbcMemberRepository(dataSource);
    // // return new JdbcTemplateMemberRepository(dataSource);
    // return new JpaMemberRepository(em);

    // }
}
