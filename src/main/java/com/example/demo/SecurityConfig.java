package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.util.matcher.AntPathRequestMatcher; // 👈 이 임포트는 더 이상 필요 없음
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; 
import org.springframework.security.crypto.password.PasswordEncoder; 
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher; // 👈 **이 임포트 추가**
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
                // [수정 1] /** 문자열을 직접 antMatcher() 메서드에 전달
                .requestMatchers(antMatcher("/**")).permitAll()) 
            .csrf((csrf) -> csrf
                    // [수정 2] /h2-console/** 문자열을 직접 antMatcher() 메서드에 전달
                    .ignoringRequestMatchers(antMatcher("/h2-console/**"))) 
            .headers((headers) -> headers
                    .addHeaderWriter(new XFrameOptionsHeaderWriter(
                        XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)))
            .formLogin((formLogin) -> formLogin
                    .loginPage("/user/login")
                    .defaultSuccessUrl("/"))
            .logout((logout) -> logout
                    // [수정 3] /user/logout 문자열을 직접 antMatcher() 메서드에 전달
                    .logoutRequestMatcher(antMatcher("/user/logout")) 
                    .logoutSuccessUrl("/")
                    .invalidateHttpSession(true))
        ;
        return http.build();
    }
    
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
