package com.mcmanus.player.api.hystrix;

import com.mcmanus.player.api.client.JSONPlaceHolderClient;
import com.mcmanus.player.api.model.Post;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class JSONPlaceHolderFallback implements JSONPlaceHolderClient {

    @Override
    public List<Post> getPosts() {
        return Collections.emptyList();
    }

    @Override
    public Post getPostById(Long postId) {
        return null;
    }
}