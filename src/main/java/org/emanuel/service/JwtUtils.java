package org.emanuel.service;

import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jose4j.jws.RsaUsingShaAlgorithm;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.PrivateKey;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class JwtUtils {




    public static String generateToken(String iss, String sub, String aud, String kid) {
        String token =
                Jwt.issuer(iss)
                        .subject(sub)
                        .audience(aud)
                        .issuedAt(System.currentTimeMillis() / 1000)
                        .expiresAt((System.currentTimeMillis() / 1000) + 3600)
                        .jws().header("kid", kid)
                        .header("alg", "RS256")
                        .header("typ", "JWT")
                        .sign();
        return token;
    }

}
