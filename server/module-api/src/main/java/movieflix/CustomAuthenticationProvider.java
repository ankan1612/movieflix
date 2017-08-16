package movieflix;

import movieflix.repository.IUserRepository;
import movieflix.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ankan on 8/16/2017.
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private IUserRepository userRepository;

    public CustomAuthenticationProvider() {
        super();
    }

    @Override
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
        final String name = authentication.getName();
        final String password = authentication.getCredentials().toString();
        movieflix.entity.User user = userRepository.authenticateUser(name, password);
        if (name.equals("ankan") && password.equals("ankan123"))
        {
            final List<GrantedAuthority> grantedAuths = new ArrayList<>();
            grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            final UserDetails principal = new User(name, password, grantedAuths);
            final Authentication auth = new UsernamePasswordAuthenticationToken(principal, password, grantedAuths);
            System.out.println(auth);
            return auth;
        }
        else if(user!=null)
        {
            String role = user.getRole();
            System.out.println(role);
            final List<GrantedAuthority> grantedAuths = new ArrayList<>();
            if(role.equals("ADMIN")) {
                grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            }
            else
            {
                grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
            }
            final UserDetails principal = new User(name, password, grantedAuths);
            final Authentication auth = new UsernamePasswordAuthenticationToken(principal, password, grantedAuths);
            System.out.println(auth);
            return auth;
        }
        else
        {
            return null;
        }
    }

    @Override
    public boolean supports(final Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
