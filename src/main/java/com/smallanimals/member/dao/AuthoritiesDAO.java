
package com.smallanimals.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smallanimals.member.vo.MemberVO;

@Repository("AuthoritiesDAO")
public class AuthoritiesDAO {
	 	@Autowired
	    private SqlSessionTemplate sqlSession;
	 	
	    public MemberVO getUserById(String username) {
	    	System.out.println(username+"dao�� ������ ���̵��?" + username);
	    	
	        return sqlSession.selectOne("member.selectUserById", username);
	    }

}

