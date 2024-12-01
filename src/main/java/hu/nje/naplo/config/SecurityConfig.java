package hu.nje.naplo.config;

import hu.nje.naplo.controller.web.CustomAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final CustomAuthenticationSuccessHandler successHandler;

    public SecurityConfig(CustomAuthenticationSuccessHandler successHandler) {
        this.successHandler = successHandler;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
//                .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(STATELESS))
//                .csrf(AbstractHttpConfigurer::disable)
//                .cors(AbstractHttpConfigurer::disable)
                .formLogin(
//                        Customizer.withDefaults())
                        form -> form
                                .loginPage("/login")
                                .successHandler(successHandler)
                                .permitAll()
                )
                .authorizeHttpRequests(
                        requests -> requests.requestMatchers(
                                "/","/home","/users/register","/login","/css/**", "/js/**", "/images/**",
                                "favicon.ico","/api/**"
                                ).permitAll()
                        .anyRequest().authenticated()
                )
                .logout(
                        logout -> logout.permitAll()
                                .invalidateHttpSession(true)
                                .clearAuthentication(true)
                                .logoutUrl("/logout")
                                .logoutSuccessUrl("/")
                )
                .build();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("user")
//                        .password("password")
//                        .roles("USER")
//                        .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
//
//    @Bean
//    @SuppressWarnings({"deprecation"})
//    public NoOpPasswordEncoder passwordEncoder() {
//        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//    }
}
