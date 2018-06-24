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
public class PrototypeScopePersonTest {

    private static final String TITLE = "One Dance";
    private static final String ANOTHER_TITLE = "Hard Times";

    @Test
    public void should_verify_name_is_different_for_prototype_beans(){

        //Given
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MediaFileConfig.class);
        context.refresh();
        MediaFile mediaFilePrototype1 = (MediaFile)context.getBean("mediaFilePrototype");
        MediaFile mediaFilePrototype2 = (MediaFile)context.getBean("mediaFilePrototype");

        // When
        mediaFilePrototype1.setTitle(TITLE);
        mediaFilePrototype2.setTitle(ANOTHER_TITLE);

        // Then
        Assert.assertNotNull(mediaFilePrototype1);
        Assert.assertEquals(TITLE, mediaFilePrototype1.getTitle());

        Assert.assertNotNull(mediaFilePrototype2);
        Assert.assertEquals(ANOTHER_TITLE, mediaFilePrototype2.getTitle());

        context.close();
    }
}
