package edu.pnu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.pnu.persistence.MemberRepository;

@Service
public class BoardUserDetailsService implements UserDetailsService {

		@Autowired
		private MemberRepository memberRepo;
				
		@Override
		public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
			
			
			return null;
		}
}
