package com.venture.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@Configuration
@EnableWebSecurity
public class SecurityConfig  {

	
//	extends WebSecurityConfiguration 
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
////	@Autowired
//	@Autowired(required = false)
//	@Override
//	@SuppressWarnings({ "deprecation", "removal" })
//	public void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .requestMatchers("/").permitAll()
//                .requestMatchers("/h2-console/**").permitAll();
//
//        http.csrf().disable();
//        http.headers().frameOptions().disable();
//    }
	
//	@SuppressWarnings("removal")
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.csrf().disable()
//		.authorizeHttpRequests((authorize) -> 
//		 		authorize.requestMatchers("/h2-console/**").permitAll()
//				);
//		
//		return http.build();
//			
//	}
	
	@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    return http.authorizeHttpRequests()
	            .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()
	            .requestMatchers(AntPathRequestMatcher.antMatcher("/save")).permitAll()
	            .requestMatchers(AntPathRequestMatcher.antMatcher("/getAll")).permitAll()
	            .requestMatchers(AntPathRequestMatcher.antMatcher("/loginurl")).permitAll()
	            .requestMatchers(AntPathRequestMatcher.antMatcher("/home")).permitAll()
	            .requestMatchers(AntPathRequestMatcher.antMatcher("/register")).permitAll()
	            .requestMatchers(AntPathRequestMatcher.antMatcher("/login_page")).permitAll()
//	            .requestMatchers(AntPathRequestMatcher.antMatcher("/content")).permitAll()
	            .and().formLogin(
                        form -> form
                        .loginPage("/login_page")
                        .loginProcessingUrl("/loginurl")
                        .defaultSuccessUrl("/content")
                        .permitAll()
        ).logout(
                logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .permitAll()
        )
	            .csrf().ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**"))
	            		.ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/save"))
	            		.ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/loginurl"))
	            		.ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/register"))
//	            		.ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/content"))
	            		.ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/home"))
	            		.ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/loginurl"))
	            		.ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/login_page"))
	            		
	            		
	            .and()
	            .headers(headers -> headers.frameOptions().sameOrigin())
	            .build();
	}
}




















