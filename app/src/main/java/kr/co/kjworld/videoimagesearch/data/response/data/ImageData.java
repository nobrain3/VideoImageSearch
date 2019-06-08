package kr.co.kjworld.videoimagesearch.data.response.data;

import java.util.ArrayList;
import java.util.List;

import kr.co.kjworld.videoimagesearch.data.response.data.ImageDocument;
import kr.co.kjworld.videoimagesearch.data.response.data.Meta;


public class ImageData {
    public List<ImageDocument> documents;
    public Meta meta;

    public ImageData() {
        documents = new ArrayList<>();
    }
}
