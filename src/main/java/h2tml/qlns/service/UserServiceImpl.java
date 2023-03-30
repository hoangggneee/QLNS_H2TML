package h2tml.qlns.service;

import h2tml.qlns.data.UserInfoDetails;
import h2tml.qlns.model.Role;
import h2tml.qlns.model.User;
import h2tml.qlns.repository.IRoleRepository;
import h2tml.qlns.repository.IUserRepository;
import h2tml.qlns.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRoleRepository roleRepository;


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(IUserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User save(@Valid UserRegistrationDto registrationDto) {

        //Creating admin role user
        User user = new User(
                registrationDto.getFirstName()
                ,registrationDto.getLastName()
                , registrationDto.getUserName()
                ,passwordEncoder.encode(registrationDto.getPassword())
                , Arrays.asList(roleRepository.findByName("USER")));

        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByEmail(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);
        if(user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new UserInfoDetails(user);
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}
    
    

}
