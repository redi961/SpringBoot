package edu.pnu.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private SecurityUserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity security) throws Exception {
		security.userDetailsService(userDetailsService);

		//index 페이지 및 system으로 시작하는 사이트에 대한 접근권한은 모두 승인함
		security.authorizeRequests().antMatchers("/", "/system/**").permitAll();
		// board로 시작하는 사이트에 대한 접근은 인증이 필요함
		security.authorizeRequests().antMatchers("/board/**").authenticated();
		// admin으로 시작하는 사이트에 대한 접근은 admin 권한이 필요함
		security.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");

		security.csrf().disable();
		security.formLogin().loginPage("/system/login").defaultSuccessUrl("/board/getBoardList", true);
		// 권한이 없는 사이트에 접근시 accessDenied 페이지로 이동함
		security.exceptionHandling().accessDeniedPage("/system/accessDenied");
		// system/logout 요청이 들어올시 세션 강제종료 후 인덱스 페이지로 이동시킴
		security.logout().logoutUrl("/system/logout").invalidateHttpSession(true).logoutSuccessUrl("/");
	}
	
	@Bean
	// 패스워드 암호화 절차
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

}
