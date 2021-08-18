package com.souza.springsecurityleo;

import com.souza.springsecurityleo.entities.Person;
import com.souza.springsecurityleo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private PersonService personService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = Optional.ofNullable(personService.findByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException("Person not found!"));
        //MONTANDO MANUAL POIS NÃO TEM AS ROLES MAPEADAS NA BASE
        List<GrantedAuthority> authorityList = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
        return new User(person.getUsername(), person.getPassword(), authorityList);
    }
}
