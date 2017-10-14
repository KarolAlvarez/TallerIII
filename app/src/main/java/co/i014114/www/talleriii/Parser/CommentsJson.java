package co.i014114.www.talleriii.Parser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import co.i014114.www.talleriii.Model.CommentsModel;

/**
 * Created by root on 12/10/17.
 */

public class CommentsJson {


    public static List<CommentsModel> getData(String content) throws JSONException {
        JSONArray jsonArray = new JSONArray(content);
        List<CommentsModel> commentsModelList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject item = jsonArray.getJSONObject(i);
            CommentsModel commentsModel = new CommentsModel();
            commentsModel.setPostId(item.getInt("postId"));
            commentsModel.setId(item.getInt("id"));
            commentsModel.setName(item.getString("name"));
            commentsModel.setEmail(item.getString("email"));
            commentsModel.setBody(item.getString("body"));

            commentsModelList.add(commentsModel);
        }
        return commentsModelList;
    }
}
