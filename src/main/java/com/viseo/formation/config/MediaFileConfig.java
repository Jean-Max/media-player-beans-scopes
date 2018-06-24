package com.viseo.formation.config;

import com.viseo.formation.domain.MediaFile;
import com.viseo.formation.domain.MediaFileGenerator;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

@Configuration
public class MediaFileConfig {

    @Bean(name = "mediaFileSingleton")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    MediaFile mediaFileSingleton(){
        return new MediaFile();
    }

    @Bean(name = "mediaFilePrototype")
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    MediaFile personPrototype(){
        return new MediaFile();
    }

    @Bean(name ="mediaFileRequest")
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    MediaFileGenerator mediaFileRequest(){
        return new MediaFileGenerator();
    }

    @Bean(name ="mediaFileSession")
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    MediaFileGenerator mediaFileSession(){
        return new MediaFileGenerator();
    }
}
