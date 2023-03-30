package h2tml.qlns.data;

import h2tml.qlns.model.Role;
import h2tml.qlns.model.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class UserInfoDetails implements UserDetails {
    protected User user;

    public UserInfoDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<SimpleGrantedAuthority> getAuthorities() {
        Collection<SimpleGrantedAuthority> roles = new ArrayList<>();
        for(Role role: this.user.getRoles()) {
            roles.add(new SimpleGrantedAuthority(role.getName()));
        }
        return roles;
    }

    public String getFullName() {
        return String.format("%s %s", this.user.getFirstName(), this.user.getLastName());
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.user.getActive();
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.user.getActive();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.user.getActive();
    }

    @Override
    public boolean isEnabled() {
        return this.user.getActive();
    }

    public String getPhotoLink() {
        if (this.user.getPhoto().length() > 0) {
            return String.format("/dist/img/%s", this.user.getPhoto());
        }
        return "/dist/img/R.png";
    }
}
