package h2tml.qlns.service;

import h2tml.qlns.model.Employee;
import h2tml.qlns.model.Position;
import h2tml.qlns.model.User;

import java.util.List;

import h2tml.qlns.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.validation.Valid;

public interface IUserService extends UserDetailsService {
    User save(@Valid UserRegistrationDto registrationDto);

    User findByUsername(String username);

    List<User> findAll();
    User getById(Long id);

    void deleteById(Long id);

    void save(User user);

    
    
}


/*
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findByEmail(email);
        List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
        return buildUserForAuthentication(user, authorities);
    }

    private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        for (Role role : userRoles) {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
        return grantedAuthorities;
    }

    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(
                user.getEmail()
                , user.getPassword()
                , user.getActive()
                , true
                , true
                , true
                , authorities);
    }
}
*/
