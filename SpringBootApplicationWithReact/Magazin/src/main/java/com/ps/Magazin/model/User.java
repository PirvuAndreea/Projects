package com.ps.Magazin.model;

import com.ps.Magazin.validators.RoleTypeSubset;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "username cannot be empty")
    @Size(min=3)
    private String username;
    @NotBlank(message = "password cannot be empty")
    @Size(min=3)
    private String password;
    @Email
    private String email;
    @NotNull
    @Min(4)
    private Integer codactivare;
    @RoleTypeSubset(anyOf = {RolUser.USER, RolUser.ADMIN})
    private RolUser rol;
    private Boolean enable;
    @OneToMany( fetch = FetchType.EAGER)
    private List<ProdusComanda> produse;
    @OneToMany(cascade = {CascadeType.REMOVE},fetch = FetchType.LAZY)
    private List<Parfum> wishList;
    private Boolean activ;
    private Boolean forgotPassword;



    public boolean isAdmin() {
        if( rol == RolUser.ADMIN)
            return true;
        else
            return false;

    }

    /*@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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
    }*/


}
