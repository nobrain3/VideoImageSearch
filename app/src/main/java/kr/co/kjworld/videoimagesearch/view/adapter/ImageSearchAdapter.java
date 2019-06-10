package kr.co.kjworld.videoimagesearch.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import kr.co.kjworld.videoimagesearch.R;
import kr.co.kjworld.videoimagesearch.data.response.data.Document;
import kr.co.kjworld.videoimagesearch.data.response.data.ImageData;
import kr.co.kjworld.videoimagesearch.data.response.data.ImageDocument;
import kr.co.kjworld.videoimagesearch.data.response.data.VideoData;
import kr.co.kjworld.videoimagesearch.data.response.data.VideoDocument;

public class ImageSearchAdapter extends RecyclerView.Adapter<ImageSearchAdapter.ImageDataViewHolder> {
    List<Document> mImageList;
    Context mContext;

    ImageButton imageButton;


    public ImageSearchAdapter(Context aContext, List<Document> imageList) {
        mContext = aContext;
        mImageList = imageList;
    }


    public void  updateImageAdapter(ImageData aData)
    {
        Toast.makeText(mContext, "image Success", Toast.LENGTH_LONG).show();
        for (ImageDocument imageDocument : aData.documents)
        {
            Document newDocument = new Document();
            newDocument.url = imageDocument.image_url;
            newDocument.dateTime = imageDocument.dateTime;
            newDocument.thumbnail_url = imageDocument.thumbnail_url;
            mImageList.add(newDocument);
        }

        notifyDataSetChanged();

    }

    public void updateVideoAdapter(VideoData aData)
    {
        Toast.makeText(mContext, "Video Success", Toast.LENGTH_LONG).show();
        for (VideoDocument videoDocument : aData.documents)
        {
            Document newDocument = new Document();
            newDocument.url = videoDocument.url;
            newDocument.dateTime = videoDocument.dateTime;
            newDocument.thumbnail_url = videoDocument.thumbnail;
            newDocument.play_time = videoDocument.play_time;
            mImageList.add(newDocument);
        }


        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public ImageDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutinflater = LayoutInflater.from(parent.getContext());
        View view = layoutinflater.inflate(R.layout.image_item, parent, false);
        return new ImageDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImageDataViewHolder holder, int position) {
        Document imageData = mImageList.get(position);
        if (imageData.play_time > 0) {
            if (imageButton != null)
                imageButton.setVisibility(View.VISIBLE);
        }

        Glide.with(mContext)
                .load(imageData.thumbnail_url)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mImageList.size();
    }

    class ImageDataViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ImageDataViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_image_view);
            imageButton = itemView.findViewById(R.id.item_image_button);
        }
    }

}
