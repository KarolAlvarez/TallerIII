package co.i014114.www.talleriii.Parser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import co.i014114.www.talleriii.Model.PostsModel;


/**
 * Created by root on 12/10/17.
 */

public class PostsJson {

    public static List<PostsModel> getData(String content) throws JSONException {
        JSONArray jsonArray = new JSONArray(content);
        List<PostsModel> postsModelList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject item = jsonArray.getJSONObject(i);
            PostsModel postsModel = new PostsModel();
            postsModel.setUserId(item.getInt("userId"));
            postsModel.setId(item.getInt("id"));
            postsModel.setTitle(item.getString("title"));
            postsModel.setBody(item.getString("body"));

            postsModelList.add(postsModel);
        }
        return postsModelList;
    }

}
