package com.orkhanmammadov.nsp_ticket.service;

import com.orkhanmammadov.nsp_ticket.dao.UserRepository;
import com.orkhanmammadov.nsp_ticket.entity.Role;
import com.orkhanmammadov.nsp_ticket.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User findByUsername(String username) {
        return userRepository.findByUserName(username); }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
        User user = userRepository.findByUserName(userName);
        if(user == null)
            throw new UsernameNotFoundException("Invalid username or password");

        if(!user.isEnabled()){
            System.out.println("User is not enabled!");
            throw new UsernameNotFoundException("User is not enabled!");
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }


}
