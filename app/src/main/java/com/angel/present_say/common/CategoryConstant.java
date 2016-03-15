package com.angel.present_say.common;

/**
 * Created by Angel on 2016/2/6.
 */
public class CategoryConstant {

    //strategy
    /**
     * 专题
     */
    public static final String AD_URL_GET = "http://api.liwushuo.com/v2/collections?limit=10&offset=0";

    /**
     * list
     */
    public static final String LIST_GET_URL = "http://api.liwushuo.com/v2/channel_groups/all";

    /**
     * gift
     */
    public static final String GIFT_GET_URL = "http://api.liwushuo.com/v2/item_categories/tree";

    /**
     *
     */
    public static final String HEADER_URL_GET = "http://api.liwushuo.com/v2/channels/";
    public static final String FOOTER_URL_GET = "/items?limit=20&gender=1&offset=0&generation=4&order_by=now";


    /**
     *
     */
    public static final String HEADER_CATEGORYDETAIL_URL_GET = "http://api.liwushuo.com/v2/posts/";

}
