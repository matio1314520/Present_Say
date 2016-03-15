package com.angel.present_say.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Angel on 2016/2/15.
 */
public class GuideImgTab implements Serializable {

    private int code;

    private GuideImgTabData data;

    private String message;

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(GuideImgTabData data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public GuideImgTabData getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public class GuideImgTabData   {

        private List<GuideImgTabSecondaryBanners> secondary_banners;


        public void setSecondary_banners(List<GuideImgTabSecondaryBanners> secondary_banners) {
            this.secondary_banners = secondary_banners;
        }

        public List<GuideImgTabSecondaryBanners> getSecondary_banners() {
            return secondary_banners;
        }

        public class GuideImgTabSecondaryBanners   {

            private int id;

            private String image_url;

            private String target_url;

            public void setId(int id) {
                this.id = id;
            }

            public void setImage_url(String image_url) {
                this.image_url = image_url;
            }

            public void setTarget_url(String target_url) {
                this.target_url = target_url;
            }

            public int getId() {
                return id;
            }

            public String getImage_url() {
                return image_url;
            }

            public String getTarget_url() {
                return target_url;
            }
        }
    }

}
