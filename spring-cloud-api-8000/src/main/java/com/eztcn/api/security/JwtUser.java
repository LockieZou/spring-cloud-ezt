package com.eztcn.api.security;

import lombok.Data;

/**
 * @author: zouxiliang
 * @description:
 * @date: Created in 11:08 2017/10/30
 */
@Data
public class JwtUser {
    /**
     * token id
     */
    private String accessToken;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户ID
     */
    private long userId;
    /**
     * 客户端ID
     */
    private String clientId;
}
