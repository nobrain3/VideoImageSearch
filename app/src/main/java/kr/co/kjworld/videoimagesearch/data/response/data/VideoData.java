package kr.co.kjworld.videoimagesearch.data.response.data;

import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.List;

public class VideoData {
    public List<VideoDocument> documents;
    public Meta meta;

    public VideoData() {
        documents = new ArrayList<>();
    }

}
