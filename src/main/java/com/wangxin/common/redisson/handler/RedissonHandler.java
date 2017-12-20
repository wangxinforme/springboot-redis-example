package com.wangxin.common.redisson.handler;


import java.io.IOException;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wangxin.common.constant.AquariusConstant;
import com.wangxin.common.property.AquariusContent;
import com.wangxin.common.redisson.constant.RedissonConstant;

public class RedissonHandler {
    private static final Logger LOG = LoggerFactory.getLogger(RedissonHandler.class);

    // 创建默认Redisson
    public static RedissonClient createDefaultRedisson() {
        try {
            Config config = RedissonHandler.createYamlConfig(RedissonConstant.CONFIG_FILE);

            return RedissonHandler.createRedisson(config);
        } catch (IOException e) {
            LOG.error("Initialize Redisson failed", e);
        }

        return null;
    }

    // 创建Yaml格式的配置文件
    public static Config createYamlConfig(String yamlConfigPath) throws IOException {
        LOG.info("Start to read {}...", yamlConfigPath);

        AquariusContent content = new AquariusContent(yamlConfigPath, AquariusConstant.ENCODING_UTF_8);

        return Config.fromYAML(content.getContent());
    }

    // 创建Json格式的配置文件
    public static Config createJsonConfig(String jsonConfigPath) throws IOException {
        LOG.info("Start to read {}...", jsonConfigPath);

        AquariusContent content = new AquariusContent(jsonConfigPath, AquariusConstant.ENCODING_UTF_8);

        return Config.fromJSON(content.getContent());
    }

    // 使用config创建Redisson
    public static RedissonClient createRedisson(Config config) {
        LOG.info("Start to initialize Redisson...");

        RedissonClient redisson = Redisson.create(config);

        return redisson;
    }

    // 关闭Redisson客户端连接
    public static void closeRedisson(RedissonClient redisson) {
        LOG.info("Start to close Redisson...");

        redisson.shutdown();
    }

    // Redisson客户端连接是否正常
    public static boolean isStarted(RedissonClient redisson) {
        return !redisson.isShutdown() && !redisson.isShuttingDown();
    }
}