package security.client.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import security.client.domain.User;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Mocart on 06-Sep-17.
 */
public class CustomUserDetails implements UserDetails{
    private User user;
    private Collection<UserAuthority> authorities = new ArrayList<>();

    public CustomUserDetails(User user) {
        this.user = user;
        authorities.add(new UserAuthority(user.getRole()));
    }

    public User getUser(){
        return user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPswrd();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
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
