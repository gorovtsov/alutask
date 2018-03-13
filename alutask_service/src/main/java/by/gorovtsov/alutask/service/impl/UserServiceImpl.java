package by.gorovtsov.alutask.service.impl;

import by.gorovtsov.alutask.entity.user.User;
import by.gorovtsov.alutask.enumeration.Role;
import by.gorovtsov.alutask.repository.UserRepository;
import by.gorovtsov.alutask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Collections;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User registerNewUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByLogin(username);
        if(user == null) {
            throw new UsernameNotFoundException("No such user!");
        }

        org.springframework.security.core.userdetails.User uds = new org.springframework.security.core.userdetails.User(username, user.getPassword(), generateAuthorities(user.getRole()));

        System.out.println(uds.getUsername() + " " + uds.getAuthorities());
        return uds;
    }

    private Collection<? extends GrantedAuthority> generateAuthorities(Role role) {
        return Collections.singletonList(new SimpleGrantedAuthority(role.toString()));
    }
}
