package com.viseo.formation.domain;

import com.viseo.formation.config.MediaFileConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MediaFileConfig.class)
public class SingletonScopeMediaFileTest {

    private static final String NAME = "John Smith";
    private static final String ANOTHER_NAME = "Anna Jones";

    @Test
    public void should_verify_name_is_same_for_singleton_beans(){

        //Given
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MediaFileConfig.class);
        context.refresh();
        MediaFile mediaFileSingleton1 = (MediaFile)context.getBean("mediaFileSingleton");
        MediaFile mediaFileSingleton2 = (MediaFile)context.getBean("mediaFileSingleton");

        // When
        mediaFileSingleton1.setTitle(NAME);
        mediaFileSingleton2.setTitle(ANOTHER_NAME);

        // Then
        Assert.assertNotNull(mediaFileSingleton1);
        Assert.assertEquals(ANOTHER_NAME, mediaFileSingleton1.getTitle());

        Assert.assertNotNull(mediaFileSingleton2);
        Assert.assertEquals(ANOTHER_NAME, mediaFileSingleton2.getTitle());

        context.close();
    }

}
