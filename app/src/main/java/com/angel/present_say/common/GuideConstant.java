package com.angel.present_say.common;

/**
 * Created by Angel on 2016/2/4.
 */
public class GuideConstant {

    /**
     * TabLayout
     */
    public static final String CHANNEL_GET_URL = "http://api.liwushuo.com/v2/channels/preset?gender=1&generation=4";

    /**
     * ad
     */
    public static final String AD_GET_URL = "http://api.liwushuo.com/v2/banners";

    /**
     * 头部中的TabLayout
     */
    public static final String TAB_GET_URL = "http://api.liwushuo.com/v2/secondary_banners?gender=1&generation=4";

    /**
     * list
     */
    public static final String LIST_GET_URL = "http://api.liwushuo.com/v2/channels/108/items?limit=20&ad=2&gender=1&offset=0&generation=4";

    public static final String LIST_HEADER_URL = "http://api.liwushuo.com/v2/channels/";

    public static final String LIST_LAST_URL = "/items?limit=20&ad=2&gender=1&offset=0&generation=4";



    //http://api.liwushuo.com/v2/search/post?limit=20&offset=0&sort=&keyword=%E7%A4%BC%E7%89%A9
}
