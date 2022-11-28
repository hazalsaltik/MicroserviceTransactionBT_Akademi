package com.bt_akademi.transaction_management.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
    web tabanlı güvenlik sağlamak için
    @EnableWebSecurity "annotation"ı
    ve WebSecurityConfigurerAdapter sınıfı
    kullanılır.
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Value("${service.security.secure-key-username}")
    private String secureKeyUsername;

    @Value("${service.security.secure-key-password}")
    private String secureKeyPassword;

    /*
        Uygulamanın kullanıcı ad ve parola bilgileri
        belirlenen bilgiler olması için
        bu metot "override" edilir.
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        // https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/in-memory.html
        auth.inMemoryAuthentication()
                .passwordEncoder(encoder)
                .withUser(secureKeyUsername)
                .password(encoder.encode(secureKeyPassword))
                .roles("USER");
    }

    // Session kullanılmayacak. JSON Web Token (JWT) kullanılacak.
    // https://www.prismacsi.com/cross-site-request-forgery-csrf-nedir
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception
    {
        super.configure(httpSecurity);

        httpSecurity.csrf().disable();
    }
}
