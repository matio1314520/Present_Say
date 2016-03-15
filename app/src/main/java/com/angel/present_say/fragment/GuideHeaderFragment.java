package com.angel.present_say.fragment;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.alibaba.fastjson.JSONObject;
import com.angel.present_say.R;
import com.angel.present_say.adapter.GuideRecyAdapter;
import com.angel.present_say.base.BaseFragment;
import com.angel.present_say.bean.GuideAd;
import com.angel.present_say.bean.GuideImgTab;
import com.angel.present_say.common.GuideConstant;
import com.angel.present_say.utils.xHttpUtils;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Angel on 2016/2/15.
 */
@ContentView(R.layout.fragment_header_guide)
public class GuideHeaderFragment extends BaseFragment implements CBViewHolderCreator {


    @ViewInject(R.id.convenientBanner_header_guide)
    private ConvenientBanner headerBanner;

    @ViewInject(R.id.recyclerview_fragment_guideheader)
    private RecyclerView mHeaderRecyView;

    private ArrayList<String> mRecyList = new ArrayList<>();

    private ArrayList<String> adUrlList = new ArrayList<>();

    public static GuideHeaderFragment newInstance() {
        GuideHeaderFragment fragment = new GuideHeaderFragment();
        return fragment;
    }

    @Override
    public void requestNetData() {
        //获取广告头数据
        getBannerData();

        //获取TabLayout数据
        getTabData();
    }

    @Override
    public void initData() {

    }

    @Override
    public void setAdapter() {

    }

    /**
     * 获取TabLayout数据
     */
    private void getTabData() {
        xHttpUtils.get(GuideConstant.TAB_GET_URL, this);
    }

    /**
     * 获取广告头数据
     */
    private void getBannerData() {
        xHttpUtils.get(GuideConstant.AD_GET_URL, new xHttpUtils.Callback() {
            @Override
            public void get(String s) {

                if (s != null) {
                    List<GuideAd.GuideAdData.GuideBanners> bannerses = JSONObject.parseObject(s, GuideAd.class).getData().getBanners();
                    if (bannerses != null && bannerses.size() > 0) {
                        for (GuideAd.GuideAdData.GuideBanners banner : bannerses) {
                            adUrlList.add(banner.getImage_url());
                        }
                        //设置广告头效果
                        setAdHeader();
                    }
                }
            }
        });
    }


    @Override
    public void get(String result) {
        List<GuideImgTab.GuideImgTabData.GuideImgTabSecondaryBanners> secondary_banners = JSONObject.parseObject(result, GuideImgTab.class).getData().getSecondary_banners();

        if (secondary_banners != null) {

            for (int i = 0, bannerSize = secondary_banners.size(); i < bannerSize; i++) {

                mRecyList.add(secondary_banners.get(i).getImage_url());

            }
            mHeaderRecyView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

            mHeaderRecyView.setAdapter(new GuideRecyAdapter(getActivity(),mRecyList));
        }
    }

    /**
     * 设置广告头效果
     */
    private void setAdHeader() {
        ConvenientBanner banner = headerBanner.setPages(this, adUrlList);

        banner.setPageIndicator(new int[]{R.mipmap.btn_check_disabled_nightmode, R.mipmap.btn_check_disabled});

        banner.setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);
    }

    @Override
    public Object createHolder() {
        return new CbHolder();
    }

    class CbHolder implements Holder<String> {

        private ImageView imageView;

        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, String data) {
            x.image().bind(imageView, data);
        }
    }

}