package hu.nje.naplo.service;

import hu.nje.naplo.entity.User;
import hu.nje.naplo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Invalid username or password."));

//        return new org.springframework.security.core.userdetails.User(user.getEmail(),
//                user.getPassword(),
//                mapRolesToAuthorities(user.getRole()));

        return user;
    }

//    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(String... roles) {
//        return Arrays.stream(roles)
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
//    }
}