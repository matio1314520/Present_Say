package com.angel.present_say.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Angel on 2016/2/12.
 */
public class GuideShow implements Serializable {

    private int code;

    private DataEntity data;

    private String message;

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public DataEntity getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public static class DataEntity {

        private List<SecondaryBannersEntity> secondary_banners;

        public void setSecondary_banners(List<SecondaryBannersEntity> secondary_banners) {
            this.secondary_banners = secondary_banners;
        }

        public List<SecondaryBannersEntity> getSecondary_banners() {
            return secondary_banners;
        }

        public static class SecondaryBannersEntity {

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
