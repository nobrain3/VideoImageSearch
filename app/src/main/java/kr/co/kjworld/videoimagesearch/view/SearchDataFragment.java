package kr.co.kjworld.videoimagesearch.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kr.co.kjworld.videoimagesearch.R;
import kr.co.kjworld.videoimagesearch.data.response.data.Document;
import kr.co.kjworld.videoimagesearch.view.adapter.ImageSearchAdapter;
import kr.co.kjworld.videoimagesearch.data.response.KakoSearchService;
import kr.co.kjworld.videoimagesearch.data.network.RetrofitCreator;

public class SearchDataFragment extends Fragment {

    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
       // initListView(view.getContext());

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        initListView(getContext());
    }



    public void initListView(Context context) {
        View view = getView();
        recyclerView = view.findViewById(R.id.search_listView);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(context, 3);
        recyclerView.setLayoutManager(layoutManager);
        final ImageSearchAdapter adapter = new ImageSearchAdapter(context, new ArrayList<Document>());
        recyclerView.setAdapter(adapter);


        RetrofitCreator.getInstance().create(KakoSearchService.class)
                .getImageData("KakaoAK f3a3676ce605a55fa482f111aa67e2b4", "설현", "recency", 1, 10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(item -> adapter.updateImageAdapter(item));


        RetrofitCreator.getInstance().create(KakoSearchService.class)
                .getVideoData("KakaoAK f3a3676ce605a55fa482f111aa67e2b4", "설현", "recency", 1, 10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(item -> adapter.updateVideoAdapter(item));

    }
}
