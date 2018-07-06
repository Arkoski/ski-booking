package com.github.project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/registration", "/registration-error").permitAll()
                .antMatchers("/confirm").permitAll()
                .antMatchers("/css/*", "/img/*").permitAll()
                .antMatchers("/home").permitAll()
                .anyRequest().authenticated();

        http
                .formLogin()
                .loginPage("/login")
                .successHandler(authenticationSuccessHandler)
                .failureHandler((request, response, exception) -> response.sendError(HttpStatus.BAD_REQUEST.value(), "Email or password invalid"))
                .failureUrl("/login-error")
                .usernameParameter("email")
                .passwordParameter("password")
                .permitAll();

        http
                .logout()
                .invalidateHttpSession(true)
                .permitAll()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/home");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.
                ignoring()
                .antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources", "/configuration/security", "/swagger-ui.html", "/webjars/**");
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }
}
