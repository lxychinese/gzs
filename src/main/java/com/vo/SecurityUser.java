package com.vo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

/**
 * Created by YB on 2014/8/28.
 */
public class SecurityUser implements UserDetails {
    private Integer serverId;
    private String username;
    private String password;
    private String platform;
    private Set<String> groups;
    private Set<String> platforms;
    private Set<SecurityRole> authorities;

    public SecurityUser(String username, String password, Set<String> platformSet, Set<SecurityRole> authorities, Set<String> groups) {
        this.platforms = platformSet;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.groups = groups;
    }

   

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Set<String> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(Set<String> platforms) {
        this.platforms = platforms;
    }

    public Integer getServerId() {
        return serverId;
    }

    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }

    public Set<String> getGroups() {
        return groups;
    }

    public void setGroups(Set<String> groups) {
        this.groups = groups;
    }



	public Collection<? extends GrantedAuthority> getAuthorities() {
		  return authorities;
	}



	public String getPassword() {
		return password;
	}



	public String getUsername() {
		return username;	
	}



	public boolean isAccountNonExpired() {
	     return true;
	}



	public boolean isAccountNonLocked() {
	     return true;
	}



	public boolean isCredentialsNonExpired() {
	     return true;
	}



	public boolean isEnabled() {
	     return true;
	}
}
