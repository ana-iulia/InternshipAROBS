package com.example.musify.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.musify.exception.RestExceptionHandler;
import com.example.musify.model.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class JwtUtils {
    private static final String issuer = "musify";

    private List<String> blacklist = new ArrayList<>();
    private final Logger log = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${jwt.secret:INTERNAROBS}")
    private String signatureSecret;

    @PostConstruct
    public void init() {
        log.info("SECERET: {}", signatureSecret);
    }

    public String generateToken(int userId, String email, Role role, String version) {

        Algorithm algorithm = Algorithm.HMAC256(signatureSecret);

        Calendar c = Calendar.getInstance();
        Date currentDate = c.getTime();

        c.add(Calendar.MINUTE, 30);
        Date expireDate = c.getTime();

        return JWT.create()
                .withIssuer(issuer)
                .withSubject(issuer)
                .withIssuedAt(currentDate)
                .withExpiresAt(expireDate)
                .withClaim("userId", userId)
                .withClaim("email", email)
                .withClaim("role", role.toString())
                .withClaim("version", version)
                .sign(algorithm);
    }

    public Pair<Integer, String> validateToken(String jwtToken) {
        Algorithm algorithm = Algorithm.HMAC256(signatureSecret);

        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer(issuer)
                .withSubject(issuer)
                .build();

        DecodedJWT decodedJWT = verifier.verify(jwtToken);
        Integer userId = decodedJWT.getClaim("userId").asInt();
        //String role = decodedJWT.getClaim("role").asString();
        String version = decodedJWT.getClaim("version").asString();
        if (blacklist.contains(jwtToken)) {
            return Pair.of(userId, null);
        }

        return Pair.of(userId, version);
    }

    public void invalidateToken(String jwtToken) {
        blacklist.add(jwtToken);

    }

    public Role getRoleFromToken(String jwtToken) {
        Algorithm algorithm = Algorithm.HMAC256(signatureSecret);
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer(issuer)
                .withSubject(issuer)
                .build();
        DecodedJWT decodedJWT = verifier.verify(jwtToken);
        String role = decodedJWT.getClaim("role").asString();
        if (role.equals("ADMIN")) {
            return Role.ADMIN;
        }
        return Role.REGULAR;
    }

    public Integer getIdFromToken(String jwtToken) {
        Algorithm algorithm = Algorithm.HMAC256(signatureSecret);
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer(issuer)
                .withSubject(issuer)
                .build();
        DecodedJWT decodedJWT = verifier.verify(jwtToken);
        return decodedJWT.getClaim("userId").asInt();
    }

    public List<String> getBlacklist() {
        return blacklist;
    }

}
