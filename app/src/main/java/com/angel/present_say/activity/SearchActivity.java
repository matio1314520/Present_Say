package com.angel.present_say.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.angel.present_say.R;
import com.angel.present_say.base.BaseActivity;
import com.angel.present_say.fragment.SearchChildFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by Angel on 2016/3/15.
 */
@ContentView(R.layout.activity_search)
public class SearchActivity extends BaseActivity {

    @ViewInject(R.id.searchinput_activity_search)
    private EditText mSearchEdt;

    @ViewInject(R.id.lin_activity_search)
    private LinearLayout mSearchLin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Event({R.id.back_activity_search, R.id.search_activity_search})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_activity_search:
                finish();
                break;
            case R.id.search_activity_search:

                String content = mSearchEdt.getText().toString();
                if (!TextUtils.isEmpty(content)) {
                    mSearchLin.setVisibility(View.GONE);

                    getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.container_activity_search, SearchChildFragment.newInstance(content))
                            .commit();
                }

                break;
        }
    }
}
