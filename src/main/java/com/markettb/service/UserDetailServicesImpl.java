package com.markettb.service;

import com.markettb.dao.UserDAO;
import com.markettb.model.User;
import com.markettb.model.UserDetailsImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServicesImpl implements UserDetailsService {
    private Logger log = Logger.getLogger(UserDetailServicesImpl.class);
    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> optionalUser = this.userDAO.getUserByName(s);
        log.info("Get User: " + optionalUser);

        return Optional.ofNullable(optionalUser).orElseThrow(()-> new UsernameNotFoundException("======= ERROR ========: UserName not found"))
                .map(UserDetailsImpl::new).get();
    }
}
