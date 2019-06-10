package kr.co.kjworld.videoimagesearch.data.network;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import kr.co.kjworld.videoimagesearch.data.response.data.VideoDocument;
import kr.co.kjworld.videoimagesearch.data.response.data.VideoData;

public class KakaoVideoDataDeserializer implements JsonDeserializer<VideoData> {
    @Override
    public VideoData deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        VideoData videoData = new VideoData();

        JsonObject videoJsonObject = json.getAsJsonObject();
        JsonArray documentArray = videoJsonObject.getAsJsonArray("documents");

        for (int i = 0; i < documentArray.size(); i++)
        {
            VideoDocument document = new VideoDocument();
            JsonObject ownerJsonObject = documentArray.get(i).getAsJsonObject();
            document.url= ownerJsonObject.get("url").getAsString();
            document.dateTime = ownerJsonObject.get("datetime").getAsString();
            document.thumbnail = ownerJsonObject.get("thumbnail").getAsString();
            document.play_time = ownerJsonObject.get("play_time").getAsInt();
            videoData.documents.add(document);
        }
        return null;
    }
}
