package com.epam.rd.onlinestore.config;

import com.epam.rd.onlinestore.service.impl.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailServiceImpl userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable().authorizeRequests().anyRequest().permitAll();
        http
            .authorizeRequests()
                .antMatchers("/", "/header.html", "/footer.html", "/images/*", "/users/registration", "/users/add", "/users/**", "/users/*", "/*", "*/", "*/*",
                        "/css/*", "/js/*", "/fonts/*", "/fragments/*", "/products/search*").permitAll()
//                .antMatchers("/", "/header.html", "/footer.html", "/images/*", "/cart/*", "/cart/**", "/users/*", "/users/**", "/users*",
//                        "/css/*", "/js/*", "/fragments/*", "/products/search*", "/registration").permitAll()
                .anyRequest().authenticated();
        http
//            .formLogin()
//                .loginPage("/login")
//                .permitAll()
            .formLogin()
                .permitAll()
            .and()
                .logout()
                .permitAll();
    }

//    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider
                = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }

//    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(11);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

}
