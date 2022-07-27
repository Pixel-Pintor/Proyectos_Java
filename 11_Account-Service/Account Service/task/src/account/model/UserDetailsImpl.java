package account.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class UserDetailsImpl implements UserDetails {
    private final String name;
    private final String lastname;
    private final String email;
    private final String password;
    private final User user;
    private final boolean active;
    private final Collection<GrantedAuthority> roles;

    public UserDetailsImpl(User user) {
        this.name = user.getName();
        this.lastname = user.getLastname();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.roles = getAuthorities(user);
        this.active = user.isActive();
        this.user = user;
    }

    private Collection<GrantedAuthority> getAuthorities(User user){
        Set<Role> userGroups = user.getRoles();
        Collection<GrantedAuthority> authorities = new ArrayList<>(userGroups.size());
        for(Role userGroup : userGroups){
            authorities.add(new SimpleGrantedAuthority(userGroup.getName()));
        }

        return authorities;
    }

    public User getUser() {
        return user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return active;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}