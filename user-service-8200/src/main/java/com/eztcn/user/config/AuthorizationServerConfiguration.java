package com.eztcn.user.config;

import com.eztcn.user.dto.CustomTokenEnhancer;
import com.eztcn.user.dto.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: zouxiliang
 * @description:
 * @date: Created in 18:30 2017/10/27
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter implements EnvironmentAware {
    private String resourceId = "ezt";
    private int accessTokenValiditySeconds = 3600;

    private static String REALM = "MY_OAUTH_REALM";
    private static final String ENV_OAUTH2 = "security.oauth2.client.";
    private RelaxedPropertyResolver propertyResolver;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.realm(REALM + "/client").allowFormAuthenticationForClients();
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer(), jwtTokenEnhancer()));
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("pc")
                .authorizedGrantTypes("password","refresh_token")
                .authorities("ROLE_USER").scopes("read", "write").resourceIds(resourceId)
                .accessTokenValiditySeconds(accessTokenValiditySeconds).and().withClient("trusted-app")
                .authorizedGrantTypes("client_credentials", "password").authorities("ROLE_TRUSTED_CLIENT")
                .scopes("read", "write").resourceIds(resourceId).accessTokenValiditySeconds(accessTokenValiditySeconds)
                .secret("secret");
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.propertyResolver = new RelaxedPropertyResolver(environment, ENV_OAUTH2);
    }

    @Bean
    public TokenEnhancer tokenEnhancer() {
        return new CustomTokenEnhancer();
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtTokenEnhancer());
    }

    @Bean
    public JwtAccessTokenConverter jwtTokenEnhancer() {
        JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter() {
            /**
             * 重写增强token方法，用于自定义一些token返回值
              */
            @Override
            public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
                String userName = authentication.getUserAuthentication().getName();
                CustomUserDetails user = (CustomUserDetails) authentication.getUserAuthentication().getPrincipal();
                /**自定义token属性**/
                final Map<String, Object> additionalInformation = new HashMap<>();
                long expTime = System.currentTimeMillis() + 24*60*60*1000;
                additionalInformation.put(JwtAccessTokenConverter.EXP, new Date(expTime));
                additionalInformation.put("userid", user.getUserid());
                additionalInformation.put("tid", user.getTid());
                additionalInformation.put("rid", user.getType());
                additionalInformation.put("isAdmin",user.getIsAdmin());
                additionalInformation.put("type",user.getType());

                ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInformation);
                OAuth2AccessToken enhancedToken = super.enhance(accessToken, authentication);
                return enhancedToken;
            }
        };
        accessTokenConverter.setSigningKey("123");
        return accessTokenConverter;
    }

    @Bean
    @Primary
    public DefaultTokenServices tokenService() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore());
        defaultTokenServices.setSupportRefreshToken(true);
        return defaultTokenServices;
    }
}
