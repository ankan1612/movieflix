package movieflix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

/**
 * Created by Ankan on 8/14/2017.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private CustomAuthenticationProvider authProvider;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    public SecurityConfig() {
        super();
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/movies").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/movies/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/movies/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/users").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/users/**").hasRole("ADMIN")
                .and()
                .httpBasic();


    }



}
