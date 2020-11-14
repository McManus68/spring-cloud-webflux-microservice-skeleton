package com.mcmanus.player.api.service;

import com.mcmanus.player.api.model.Post;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class JSONPlaceHolderServiceTest {

    @Autowired
    private JSONPlaceHolderService service;

    @Test
    public void should_be_able_to_bootstrap_spring_boot_feign() {
    }

    @Test
    public void should_be_able_to_get_posts_using_spring_boot_feign() {
        List<Post> posts = service.getPosts();
        assertFalse(posts.isEmpty());
    }

    @Test
    public void should_be_able_to_get_post_by_id_using_spring_boot_feign() {
        Post post = service.getPostById(1L);
        assertNotNull(post);
    }
}
