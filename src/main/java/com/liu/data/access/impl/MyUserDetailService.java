package com.liu.data.access.impl;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailService implements UserDetailsService {
	 /**
    *
    * @param username
    * @return
    * @throws org.springframework.security.core.userdetails.UsernameNotFoundException
    * @throws org.springframework.dao.DataAccessException
    */
   public UserDetails loadUserByUsername(String username)
           throws UsernameNotFoundException, DataAccessException {
       // TODO Auto-generated method stub
       UserDetails userDetails=null;
       try {
          
           userDetails=new User("admin", "202cb962ac59075b964b07152d234b70", true, true, true, true, getAuthorities(1));
       } catch (Exception e) {
           throw new UsernameNotFoundException("用户没通过");
       }
       return userDetails;
   }

   public Collection<GrantedAuthority> getAuthorities(Integer usertypeid){
       List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(3);
       authList.add(new GrantedAuthorityImpl("ROLE_ORDINARY_USERS"));
       if (usertypeid.compareTo(1) == 0) {
           authList.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
           authList.add(new GrantedAuthorityImpl("ROLE_MANAGER"));
       }if (usertypeid.compareTo(2) == 0){
           authList.add(new GrantedAuthorityImpl("ROLE_MANAGER"));
       }
       authList.add(new GrantedAuthorityImpl("default"));
       return authList;
   }
}