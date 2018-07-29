package com.sharebaseinc.web;

import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jService;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.ipc.UnixIpcService;
import org.web3j.protocol.ipc.WindowsIpcService;
import org.web3j.spring.actuate.Web3jHealthIndicator;
import org.web3j.spring.autoconfigure.Web3jAutoConfiguration;
import org.web3j.spring.autoconfigure.Web3jProperties;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

@Configuration
@EnableWebMvc

public class ShareBaseWebConfig implements WebMvcConfigurer {
	private static Log log = LogFactory.getLog(Web3jAutoConfiguration.class);

	@Autowired
	private Web3jProperties properties;

	@Bean
	@ConditionalOnMissingBean
	public Web3j web3j() {
		Web3jService web3jService = buildService(properties.getClientAddress());
		log.info("Building service for endpoint: " + properties.getClientAddress());
		return Web3j.build(web3jService);
	}

	@Bean
	public Admin admin() {
		Web3jService web3jService = buildService(properties.getClientAddress());
		log.info("Building admin service for endpoint: " + properties.getClientAddress());
		return Admin.build(web3jService);
	}

	private Web3jService buildService(String clientAddress) {
		Web3jService web3jService;

		if (clientAddress == null || clientAddress.equals("")) {
			web3jService = new HttpService(createOkHttpClient());
		} else if (clientAddress.startsWith("http")) {
			web3jService = new HttpService(clientAddress, createOkHttpClient(), false);
		} else if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
			web3jService = new WindowsIpcService(clientAddress);
		} else {
			web3jService = new UnixIpcService(clientAddress);
		}

		return web3jService;
	}

	private OkHttpClient createOkHttpClient() {
		OkHttpClient.Builder builder = new OkHttpClient.Builder();
		configureLogging(builder);
		configureTimeouts(builder);
		return builder.build();
	}

	private void configureTimeouts(OkHttpClient.Builder builder) {
		Long tos = properties.getHttpTimeoutSeconds();
		if (tos != null) {
			builder.connectTimeout(tos, TimeUnit.SECONDS);
			builder.readTimeout(tos, TimeUnit.SECONDS); // Sets the socket
														// timeout too
			builder.writeTimeout(tos, TimeUnit.SECONDS);
		}
	}

	private static void configureLogging(OkHttpClient.Builder builder) {
		if (log.isDebugEnabled()) {
			HttpLoggingInterceptor logging = new HttpLoggingInterceptor(log::debug);
			logging.setLevel(HttpLoggingInterceptor.Level.BODY);
			builder.addInterceptor(logging);
		}
	}

	@Bean
	@ConditionalOnBean(Web3j.class)
	Web3jHealthIndicator web3jHealthIndicator(Web3j web3j) {
		return new Web3jHealthIndicator(web3j);
	}

}
