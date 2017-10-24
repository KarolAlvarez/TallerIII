package co.i014114.www.talleriii.Parser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import co.i014114.www.talleriii.Model.UsersModel;

/**
 * Created by root on 12/10/17.
 */

public class UsersJson {
    public static List<UsersModel> getData(String content) throws JSONException {
        JSONArray jsonArray = new JSONArray(content);
        List<UsersModel> usersModelList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject item = jsonArray.getJSONObject(i);
            UsersModel usersModel = new UsersModel();
            usersModel.setId(item.getInt("id"));
            usersModel.setName(item.getString("name"));
            usersModel.setEmail(item.getString("email"));
            usersModel.setUserName(item.getString("username"));

            JSONObject address = item.getJSONObject("address");
            usersModel.setAddress(address.getString("city"));

            JSONObject company = item.getJSONObject("company");
            usersModel.setCompany(company.getString("name"));

            usersModelList.add(usersModel);
        }
        return usersModelList;
    }


}
