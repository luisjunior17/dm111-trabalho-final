package br.inatel.luis.trabalho_DM111.service;

import br.inatel.luis.trabalho_DM111.model.User;
import br.inatel.luis.trabalho_DM111.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.logging.Logger;

@Service("userDetailsService")
public class UserService implements UserDetailsService {

    private static final Logger log = Logger.getLogger("UserService");

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        Optional<User> optUser =
                userRepository.getByEmail(email);
        if (optUser.isPresent()) {
            //userRepository.updateUserLogin(optUser.get());
            return optUser.get();
        } else {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
    }
}