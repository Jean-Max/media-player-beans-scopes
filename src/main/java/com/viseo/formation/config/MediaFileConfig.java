package com.viseo.formation.config;

import com.viseo.formation.domain.MediaFile;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

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
}
