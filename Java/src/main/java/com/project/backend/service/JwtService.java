package com.project.backend.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.project.backend.entity.Account;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private final String SECRET_KEY = "dVjsAvl36jmqckAdM4X3mk4cZMYLWgAToALaQuO4v23w3VMz7xmI28c32ebW4acC7hGbzfsfux1WyEywn+2XK4JRNE12JZYBNLWUS07M5NIhVFafEkzQrY0jqbmtOmWIn73sLFelxhwiUoZjvphdiKvd2sXvFKfTf94btBkGEqey/kS11F4jpSOthj/geYfQopa+Cdr78nTV66Wpvqod3HcolCk4Nk3WFq3+s8MwTZID1C1KM5E1ANgMD9NgyDxEtJkbNFBkJTtv6MBcDYz3krlARlyvIuLdSlQ6JUFindsgFLaQ4liSlnm83jpI04vPAHZ58EMkrCuOzFqVWxVYIoN9cvwY5ZtPlYotu71sDAc=\n";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

//    public String generateToken(UserDetails userDetails){
//        return generateToken(new HashMap<>(), userDetails);
//    }
//
//    public String generateToken(
//            Map<String, Object> extraClaims,
//            UserDetails userDetails
//    ) {
//        return Jwts
//                .builder()
//                .setClaims(extraClaims)
//                .setSubject(userDetails.getUsername())
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
//                .signWith(getSigningKey(), SignatureAlgorithm.ES256)
//                .compact();
//    }
    // Trong phương thức generateToken của JwtService

    public String generateToken(Account account){
        return generateToken(new HashMap<>(), account);
    }

    public String generateToken(
            Map<String, Object> extraClaims,
            Account account
    ) {
        List<String> roles = account.getAuthorities().stream().map(GrantedAuthority:: getAuthority).toList();
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(account.getUsername())
                .claim("email", account.getEmail())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24 * 10000)).claim("roles",roles).claim("id",account.getId()).claim("accountBalance", account.getAccountBalance()).claim("email", account.getEmail())
                .signWith(getSigningKey(), SignatureAlgorithm.HS256) // Chuyển sang sử dụng HS256
                .compact();
    }


    private Claims extractAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) &&  !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token , Claims::getExpiration);
    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
