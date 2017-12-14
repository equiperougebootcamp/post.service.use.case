
package com.bootcamp.helpers;


import com.bootcamp.client.UserClient;
import com.bootcamp.commons.ws.usecasepost.PostWS;
import com.bootcamp.entities.Post;
import com.bootcamp.entities.Region;
import com.bootcamp.entities.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ibrahim
 */
public class PostHelper {

    public static PostWS buildPostWSObject(Post post) throws IOException{
        UserClient userClient = new UserClient();
        User user = userClient.getById( post.getUserId() );
        PostWS postWS = new PostWS();
        postWS.setId( post.getId() );
        postWS.setPostDate( post.getDateCreation() );
        postWS.setUserAddress( user.getRegion() );
        postWS.setPostType( post.getTypePost() );
        postWS.setPostRegion( post.getRegion() );
        postWS.setPostMessage( post.getDescription());
        postWS.setPostedPrenom( user.getPrenom() );
        postWS.setPostedName( user.getNom() );
        postWS.setPostedEmail( user.getEmail() );
        postWS.setPostedContact( user.getContact() );

        return postWS;

    }

    public static  List<PostWS> getAllPost(List<Post> posts) throws Exception{
        List<PostWS> results = new ArrayList<>(  );
        for(Post current:posts){
            results.add( buildPostWSObject( current ) );
        }

        return results;
    }

}
