package se.iths.converter;


import org.json.JSONException;
import org.json.JSONObject;

public class Converter {
    public static void main(String[] args){
        JSONObject obj = new JSONObject();

        obj.put("name", "foo");
        System.out.println(obj);

        try {
            JSONObject jsonObject = new JSONObject("{'text': 'I dident find'}");
            System.out.println(jsonObject);
        }catch (JSONException err){
            System.out.println(err.toString());
        }


    }
    public static JSONObject plaintextToJson(String jsonString) {
        JSONObject obj = new JSONObject();


        obj.put("name", jsonString);

        return obj;

    }
}
