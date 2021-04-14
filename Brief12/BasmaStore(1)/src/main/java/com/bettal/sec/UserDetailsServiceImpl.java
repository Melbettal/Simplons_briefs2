package com.bettal.sec;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.elbettal.model.AppUser;
import com.elbettal.service.AccountService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
    private AccountService accountService;

	
	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { // methode ou on indique ou chercher l'utilisateur, et quand considerer si c'est valide (customed)
    	AppUser appUser=accountService.loadUserByUsername(username);
         if(appUser==null) throw new UsernameNotFoundException("invalid user");
         Collection<GrantedAuthority> authorities=new ArrayList<>();
         appUser.getRoles().forEach(r->{ //parcourir sur la list des users que jai récuperer
             authorities.add(new SimpleGrantedAuthority(r.getRoleName())); //
         });
         return new User(appUser.getUsername(),appUser.getPassword(),authorities); //create a spring user to use in his context, vérifier le mdp (encoder => comparer)
	}

}
