package kr.co.kjworld.videoimagesearch.View.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import kr.co.kjworld.videoimagesearch.R;
import kr.co.kjworld.videoimagesearch.data.response.data.ImageDocument;
import kr.co.kjworld.videoimagesearch.data.response.data.ImageData;
import kr.co.kjworld.videoimagesearch.data.response.data.VideoData;

public class ImageSearchAdapter extends RecyclerView.Adapter<ImageSearchAdapter.ImageDataViewHolder> {
    List<ImageDocument> mImageList;
    Context mContext;


    public ImageSearchAdapter(Context aContext, List<ImageDocument> imageList) {
        mContext = aContext;
        mImageList = imageList;
    }


    public void  updateImageAdapter(ImageData aData)
    {
        Toast.makeText(mContext, "kkk", Toast.LENGTH_LONG).show();

    }

    public void updateVideoAdapter(VideoData aData)
    {
        Toast.makeText(mContext, "video", Toast.LENGTH_LONG).show();
    }



    public void  updateImageAdapter(List<ImageData> aDataList)
    {
        Toast.makeText(mContext, aDataList.size(), Toast.LENGTH_LONG).show();
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
        ImageDocument imageData = mImageList.get(position);
        Glide.with(mContext)
                .load(imageData.image_url)
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
        }
    }

}
