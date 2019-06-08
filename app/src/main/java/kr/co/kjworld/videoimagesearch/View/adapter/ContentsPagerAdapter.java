package kr.co.kjworld.videoimagesearch.View.adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import kr.co.kjworld.videoimagesearch.R;
import kr.co.kjworld.videoimagesearch.View.MyListFragment;
import kr.co.kjworld.videoimagesearch.View.SearchDataFragment;

public class ContentsPagerAdapter extends FragmentPagerAdapter {
    private int pageCount;
    private Context mContext;

    public ContentsPagerAdapter(Context aContext, FragmentManager fragmentManager, int pageCount)
    {
        super(fragmentManager);
        mContext = aContext;
        this.pageCount = pageCount;
    }
    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;
        switch (position)
        {
            case 0:
                fragment = new SearchDataFragment();
                break;

            case 1:
                fragment = new MyListFragment();
                break;

            default:
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return pageCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getResources().getText(R.string.tab_search);

            case 1:
                return mContext.getResources().getText(R.string.tab_mylist);
        }
        return null;
    }
}
