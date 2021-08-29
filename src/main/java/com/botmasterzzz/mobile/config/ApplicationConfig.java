package com.botmasterzzz.mobile.config;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;
import org.jasypt.spring.properties.EncryptablePropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.lang.NonNull;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.concurrent.Executor;

@Configuration
@EnableWebMvc
@ComponentScan({"com.botmasterzzz.mobile"})
@EnableAsync
public class ApplicationConfig implements WebApplicationInitializer {

    private static final String DISPATCHER_SERVLET_NAME = "dispatcher-mobile-service";
    private static final String BASE_PACKAGES = "com.botmasterzzz.mobile";


    @Override
    public void onStartup(@NonNull ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.scan(BASE_PACKAGES);
        servletContext.addListener(new ContextLoaderListener(ctx));
        ctx.setServletContext(servletContext);
        ServletRegistration.Dynamic servlet = servletContext.addServlet(DISPATCHER_SERVLET_NAME, new DispatcherServlet(ctx));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }

    @Bean
    public RestOperations restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setDefaultEncoding("utf-8");
        return multipartResolver;
    }

    @Bean
    public Executor taskExecutor() {
        return new SimpleAsyncTaskExecutor();
    }

    @Bean
    @DependsOn("configurationEncryptor")
    public EncryptablePropertyPlaceholderConfigurer propertyEncodedPlaceholderConfigurer() {
        EncryptablePropertyPlaceholderConfigurer encryptablePropertyPlaceholderConfigurer = new EncryptablePropertyPlaceholderConfigurer(configurationEncryptor());
        encryptablePropertyPlaceholderConfigurer.setIgnoreResourceNotFound(true);
        encryptablePropertyPlaceholderConfigurer.setLocation(new ClassPathResource("application.properties"));
        return encryptablePropertyPlaceholderConfigurer;
    }


    @Bean
    @DependsOn("environmentVariablesConfiguration")
    public StandardPBEStringEncryptor configurationEncryptor() {
        StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        standardPBEStringEncryptor.setConfig(environmentVariablesConfiguration());
        return standardPBEStringEncryptor;
    }

    @Bean
    public EnvironmentStringPBEConfig environmentVariablesConfiguration() {
        EnvironmentStringPBEConfig environmentStringPBEConfig = new EnvironmentStringPBEConfig();
        environmentStringPBEConfig.setAlgorithm("PBEWithMD5AndDES");
        environmentStringPBEConfig.setPassword("");
        return environmentStringPBEConfig;
    }


}
