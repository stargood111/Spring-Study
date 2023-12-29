package hello.core.beanfind;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.core.AppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class ApplicationContextSameBeanFind {
   AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);
   
   @Test
   @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 중복 오류 발생")
   void findBeanTypeDuplicate() {
//      MemberRepository bean = ac.getBean(MemberRepository.class);
      assertThrows(NoUniqueBeanDefinitionException.class,
            () -> ac.getBean(MemberRepository.class));
   }
   @Test
   @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 빈 이름을 지정하면 된다")
   void findBeanByName() {
      MemberRepository memberRepository = ac.getBean("memberRepository1", MemberRepository.class);
      assertThat(memberRepository).isInstanceOf(MemberRepository.class);
   }
   @Test
   @DisplayName("특정 타입을 모두 조회하기")
   void findAllbeanByType() {
      Map<String, MemberRepository> beanOfType = ac.getBeansOfType(MemberRepository.class);
      for(String key : beanOfType.keySet()) {
         System.out.println("key = " + key + " value = " + beanOfType.get(key));
      }
      System.out.println(beanOfType);
      assertThat(beanOfType.size()).isEqualTo(2);
   }
   
   
   
   @Configuration
   static class SameBeanConfig{
      
      @Bean
      public MemberRepository memberRepository1() {
         return new MemoryMemberRepository();
      }
      
      @Bean
      public MemberRepository memberRepository2() {
         return new MemoryMemberRepository();
      }
   }
}

