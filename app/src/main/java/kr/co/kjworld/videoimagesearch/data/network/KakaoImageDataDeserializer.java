package kr.co.kjworld.videoimagesearch.data.network;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;


import java.lang.reflect.Type;

import kr.co.kjworld.videoimagesearch.data.response.data.ImageDocument;
import kr.co.kjworld.videoimagesearch.data.response.data.ImageData;

public class KakaoImageDataDeserializer implements JsonDeserializer<ImageData> {
    @Override
    public ImageData deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        ImageData imageData = new ImageData();

        JsonObject imageJsonObject =  json.getAsJsonObject();
        JsonArray documentArray = imageJsonObject.getAsJsonArray("documents");

        for (int i = 0; i < documentArray.size(); i++)
        {
            ImageDocument document = new ImageDocument();
            JsonObject ownerJsonObject = documentArray.get(i).getAsJsonObject();
            document.image_url = ownerJsonObject.get("image_url").getAsString();
            document.thumbnail_url = ownerJsonObject.get("thumbnail_url").getAsString();
            document.datetime = ownerJsonObject.get("datetime").getAsString();
            imageData.documents.add(document);
        }

        return imageData;
    }
}
