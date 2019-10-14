package com.smallanimals.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.smallanimals.member.dao.AuthoritiesDAO;
import com.smallanimals.member.vo.AuthoritiesVO;

@Service
public class AuthoritiesService implements UserDetailsService{
	
    @Autowired
    private AuthoritiesDAO AuthorDAO;


	 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			System.out.println("service���� ���µ�" + username);
			
		   AuthoritiesVO user = AuthorDAO.getUserById("admin");
		   
		   System.out.println("service���� dao ����� ���ؿ�;");
	        if(user==null) {
            throw new UsernameNotFoundException(username);
	        }
	        return user;
	}
}
