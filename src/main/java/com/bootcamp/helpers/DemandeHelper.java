package com.bootcamp.helpers;

import com.bootcamp.client.ProduitClient;
import com.bootcamp.client.UserClient;
import com.bootcamp.commons.ws.usecasepost.DemandeWS;
import com.bootcamp.commons.ws.usecasepost.PostWS;
import com.bootcamp.entities.Post;
import com.bootcamp.entities.User;

import java.util.ArrayList;
import java.util.List;

public class DemandeHelper {


    public static DemandeWS buildDemandeWS(Post post) throws Exception{
        DemandeWS demandeWS = new DemandeWS();
        PostWS postWS= PostHelper.buildPostWSObject( post );
        int productId = post.getProduitId();
        List<Integer> userIdList = new ProduitClient().getById( productId ).getUsersId();
        /*List<User> users = new UserClient().findAll();*/
        List<User> productUsers = new ArrayList<>(  );

        for(int i:userIdList){
            productUsers.add( new UserClient().getById( i ) );
        }
        demandeWS.setPostWS( postWS );
        demandeWS.setUseList( productUsers );
        return demandeWS;
    }
}
