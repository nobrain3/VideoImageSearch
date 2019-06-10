package kr.co.kjworld.videoimagesearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import kr.co.kjworld.videoimagesearch.view.adapter.ContentsPagerAdapter;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


       // tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_search));
        //tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_mylist));


        ViewPager viewPager = findViewById(R.id.pager_contents);
        ContentsPagerAdapter contentPageAdapter = new ContentsPagerAdapter(this, getSupportFragmentManager(), 2);
        viewPager.setAdapter(contentPageAdapter);

        TabLayout tabLayout = findViewById(R.id.tab_layou);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        boolean isSelected = false;
        switch (item.getItemId()) {
            case R.id.action_search_image:
                initSearchView();
                break;

            case R.id.action_select_item:
                break;

            default:
                isSelected = super.onOptionsItemSelected(item);
                break;
        }
        return isSelected;
    }

    public void initSearchView()
    {
        //Men
    }

}
