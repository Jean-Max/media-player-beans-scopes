package com.viseo.formation;

import com.viseo.formation.config.MediaFileConfig;
import com.viseo.formation.domain.MediaFile;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunApplication {

    public static void main(String[] args) {

        // Getting application context
        ApplicationContext context = new AnnotationConfigApplicationContext(MediaFileConfig.class);

        // Getting singleton beans
        MediaFile mediaFileSingleton1 = (MediaFile)context.getBean("mediaFileSingleton");
        mediaFileSingleton1.setTitle("Singleton1");

        MediaFile mediaFileSingleton2 = (MediaFile)context.getBean("mediaFileSingleton");
        mediaFileSingleton2.setTitle("Singleton2");

        // Getting prototypes beans
        MediaFile mediaFilePrototype1 = (MediaFile)context.getBean("mediaFilePrototype");
        mediaFilePrototype1.setTitle("Prototype1");

        MediaFile mediaFilePrototype2 = (MediaFile)context.getBean("mediaFilePrototype");
        mediaFilePrototype2.setTitle("Prototype2");

        // Display beans name
        System.out.println("Bean mediaFileSingleton1 name is: " + mediaFileSingleton1.getTitle());
        System.out.println("Bean mediaFileSingleton2 name is: " + mediaFileSingleton2.getTitle());
        System.out.println("Bean mediaFilePrototype1 name is: " + mediaFilePrototype1.getTitle());
        System.out.println("Bean mediaFilePrototype2 name is: " + mediaFilePrototype2.getTitle());
    }
}
