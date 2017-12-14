package com.bootcamp.services;

import com.bootcamp.client.PostClient;
import com.bootcamp.commons.ws.usecasepost.DemandeWS;
import com.bootcamp.commons.ws.usecasepost.PostWS;
import com.bootcamp.entities.Post;
import com.bootcamp.helpers.DemandeHelper;
import com.bootcamp.helpers.PostHelper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Ibrahim on 11/29/17.
 */

@Component
public class PostService {

    PostClient postClient;

    @PostConstruct
    public void init(){

        postClient = new PostClient();
    }

    public List<PostWS> getAll() throws Exception {
        List<Post> posts = postClient.findAll();
        List<PostWS> result = PostHelper.getAllPost( posts );

        return result;
    }

    public void createPost(Post post) throws Exception{
        new PostClient().create( post );
    }

    public PostWS getPostWS(int id) throws Exception{
        return PostHelper.buildPostWSObject( postClient.getById( id ) );
    }

    public DemandeWS getDemandeWS(Post post) throws Exception{
        return DemandeHelper.buildDemandeWS( post );
    }

}
