package com.myteek.common.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;

import java.net.InetSocketAddress;

import static com.myteek.common.constant.NetworkConstant.CLIENT_IP;
import static com.myteek.common.constant.NetworkConstant.X_FORWARDED_FOR;
import static com.myteek.common.constant.NetworkConstant.X_REAL_IP;
import static com.myteek.common.constant.NetworkConstant.PROXY_CLIENT_IP;
import static com.myteek.common.constant.NetworkConstant.WL_PROXY_CLIENT_IP;
import static com.myteek.common.constant.NetworkConstant.DEFAULT_IP;
import static com.myteek.common.constant.NetworkConstant.UNKNOWN;

@Slf4j
public class Network {

    /**
     * 获取客户端的真实IP地址，如果有代理IP地址，则获取代理之前的IP地址
     * @param request Server Http Request
     * @return
     */
    public static String getRemoteIpAddress(ServerHttpRequest request) {
        String ip = "";
        try {
            HttpHeaders httpHeaders = request.getHeaders();
            ip = httpHeaders.getFirst(CLIENT_IP);
            if (ip == null || ip.length() == 0) {
                ip = httpHeaders.getFirst(X_FORWARDED_FOR);
                if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
                    ip = httpHeaders.getFirst(X_REAL_IP);
                }
                if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
                    ip = httpHeaders.getFirst(PROXY_CLIENT_IP);
                }
                if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
                    ip = httpHeaders.getFirst(WL_PROXY_CLIENT_IP);
                }
                if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
                    InetSocketAddress remoteAddress = request.getRemoteAddress();
                    if (remoteAddress != null) {
                        ip = remoteAddress.getHostString();
                    }
                }
                if (ip == null) {
                    ip = DEFAULT_IP;
                }
            }
        } catch (Throwable e) {
            log.warn("get ip error", e);
        }
        return ip;
    }

}
