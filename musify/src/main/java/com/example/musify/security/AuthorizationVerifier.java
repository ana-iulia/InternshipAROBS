package com.example.musify.security;
import com.example.musify.model.Role;

public class AuthorizationVerifier {
    public static boolean isAdmin() {
        return JwtUtils.getUserRoleFromSession().equals(Role.ADMIN);
    }
}
