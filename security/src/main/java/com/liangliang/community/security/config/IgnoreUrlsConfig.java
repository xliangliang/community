package com.liangliang.community.security.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liangliang
 * @date 2020/4/7
 * @desc 配置不需要保护的资源路径
 */
@Getter
@Setter
@EnableConfigurationProperties(IgnoreUrlsConfig.class)
@ConfigurationProperties(prefix = "secure.ignored")
public class IgnoreUrlsConfig {

    private List<String> urls = new ArrayList<>();

}
