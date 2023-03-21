package ru.netology.netologydatastoragehibernate.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from users where username = ?")
                .authoritiesByUsernameQuery("select username, authority from authorities where username = ?");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*
    пароль для пользователя user - pass
    пароль для пользователя admin - pass
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((auth) -> auth
                        .requestMatchers(HttpMethod.POST, "/persons").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/persons/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,
                                "/persons/by-city",
                                "/persons/by-age-less",
                                "/persons/by-name-and-surname").hasRole("USER")
                        .anyRequest().permitAll())
                .formLogin(withDefaults())
                .csrf().disable(); // отключаем, чтобы разрешить POST/DELETE методы
        return http.build();
    }
}
