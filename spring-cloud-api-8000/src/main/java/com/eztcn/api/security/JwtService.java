package com.eztcn.api.security;

import lombok.Data;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author: zouxiliang
 * @description:
 * @date: Created in 11:11 2017/10/30
 */
@Component
@Data
public class JwtService {
    private JwtUser jwtUser;
    private String token;

    public void create() {
        OAuth2Authentication auth2Authentication = (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
        if(auth2Authentication == null || auth2Authentication.getDetails() == null) {
            return;
        }

        token = ((OAuth2AuthenticationDetails)auth2Authentication.getDetails()).getTokenValue();
        String jsonToken = JwtHelper.decode(token).getClaims();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            jwtUser = objectMapper.readValue(jsonToken, JwtUser.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        String json = JwtHelper.decode("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9" +
                ".eyJ1c2VyX25hbWUiOiIxMzIxMjM0NTY3OCIsInNjb3BlIjpbIndyaXRlIl0sImV4cCI6MTQ5NzU0MDQzNSwidXNlcmlkIjoyMzkyOTAxLCJhdXRob3JpdGllcyI6WyJhZG1pbiJdLCJqd" +
                "GkiOiI2MGQ0ODMwNi00NjJmLTQ0YzgtYmM1NC1hMjgwMDY3YjgwZjIiLCJ0aWQiOjEsImNsaWVudF9pZCI6IkVYUEVSVCJ9" +
                ".UDGaMeMe-P25tzhamJu1tH_jXl57FIJVKcwbPOS-Ibo").getClaims();

        System.out.print(json);
    }
}
