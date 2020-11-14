package com.mcmanus.player.api.service;

import com.mcmanus.player.api.model.Post;

import java.util.List;

public interface JSONPlaceHolderService {

    List<Post> getPosts();

    Post getPostById(Long id);
}
