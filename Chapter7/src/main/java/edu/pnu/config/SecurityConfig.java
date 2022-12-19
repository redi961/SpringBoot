package edu.pnu.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private DataSource dataSource;
	
	@Bean
	public SecurityFilterChain sercurityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable();
		
		http.authorizeHttpRequests()
		//Member로 시작하는 모든 사이트는 인증을 받아야 된다.
			.requestMatchers("/member/**").authenticated()
		//manager로 시작하는 모든 사이트에 접근 하기 위해서는 해당권한 중 하나가 필요하다
			.requestMatchers("/manager/**").hasAnyRole("MANAGER","ADMIN")
		//admin으로 시작하는 사이트에 접근하기 위해서는 ADMIN 권한이 필요하다
			.requestMatchers("/admin/**").hasRole("ADMIN")
			.anyRequest().permitAll();
		
		//디폴트 로그인페이지 사용자 설정 화면으로
		http.formLogin().loginPage("/login").defaultSuccessUrl("/loginSuccess", true);
		return http.build();
	}
	
	//DB연동 x
	//로그인 테스트간 사용할 계정생성
//	@Autowired
//	public void authenticate(AuthenticationManagerBuilder auth) throws Exception {
//		
//		auth.inMemoryAuthentication()
//			.withUser("manager")
//			.password("{noop}manager123")
//			.roles("MANAGER");
//		
//		auth.inMemoryAuthentication()
//			.withUser("admin")
//			.password("{noop}admin123")
//			.roles("ADMIN" ,"MANAGER");
//	}
	
	//DB연동 o
	// noop를 사용시 시큐리티 내에서 텍스트를 그대로 인식하도록 만듬 (암호화x)
	// concat -> 문자열 붙이기
	@Autowired
	public void authenticate(AuthenticationManagerBuilder auth) throws Exception {
		String query1 = "select id username, concat('{noop}', password)"
				+ "password, true enabled from member where id=?";
		String query2 = "select id, role from member where id=?";
		
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery(query1)
		.authoritiesByUsernameQuery(query2);
	}
	
}
