package com.example.library_management_backend.service;

import com.example.library_management_backend.dto.authen.request.AuthenticationRequest;
import com.example.library_management_backend.dto.authen.request.IntrospectRequest;
import com.example.library_management_backend.dto.authen.request.LogoutRequest;
import com.example.library_management_backend.dto.authen.request.RefreshRequest;
import com.example.library_management_backend.dto.authen.response.AuthenticationResponse;
import com.example.library_management_backend.dto.authen.response.IntrospectResponse;
import com.example.library_management_backend.entity.InvalidatedToken;
import com.example.library_management_backend.entity.User;
import com.example.library_management_backend.exception.AppException;
import com.example.library_management_backend.exception.ErrorCode;
import com.example.library_management_backend.repository.InvalidatedTokenRepository;
import com.example.library_management_backend.repository.UserRepository;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.StringJoiner;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService {
    PasswordEncoder passwordEncoder;

    public IntrospectResponse introspect(IntrospectRequest request) {
        // Luôn trả về hợp lệ vì đã tắt xác thực
        return IntrospectResponse.builder().valid(true).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        // Luôn trả về thành công và token giả lập
        return AuthenticationResponse.builder()
                .token("dummy-token")
                .authenticated(true)
                .build();
    }

    public AuthenticationResponse refreshToken(RefreshRequest request) {
        // Luôn trả về thành công và token giả lập
        return AuthenticationResponse.builder()
                .token("dummy-token")
                .authenticated(true)
                .build();
    }

    public void logout(LogoutRequest request) {
        // Không làm gì vì đã tắt xác thực
    }
}

