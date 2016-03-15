package com.angel.present_say.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Angel on 2016/2/12.
 */
public class GuideAd implements Serializable {

    private int code;

    private GuideAdData data;

    private String message;

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(GuideAdData data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public GuideAdData getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public static class GuideAdData{

        private List<GuideBanners> banners;

        public GuideAdData(List<GuideBanners> banners) {
            this.banners = banners;
        }

        public GuideAdData() {
        }

        public void setBanners(List<GuideBanners> banners) {
            this.banners = banners;
        }

        public List<GuideBanners> getBanners() {
            return banners;
        }

        public static class GuideBanners{

            private String channel;

            private int id;

            private String image_url;

            private int order;

            private int status;

            private GuideAdTarget target;

            private String target_id;

            private String target_url;

            private String type;

            public void setChannel(String channel) {
                this.channel = channel;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setImage_url(String image_url) {
                this.image_url = image_url;
            }

            public void setOrder(int order) {
                this.order = order;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public void setTarget(GuideAdTarget target) {
                this.target = target;
            }

            public void setTarget_id(String target_id) {
                this.target_id = target_id;
            }

            public void setTarget_url(String target_url) {
                this.target_url = target_url;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getChannel() {
                return channel;
            }

            public int getId() {
                return id;
            }

            public String getImage_url() {
                return image_url;
            }

            public int getOrder() {
                return order;
            }

            public int getStatus() {
                return status;
            }

            public GuideAdTarget getTarget() {
                return target;
            }

            public String getTarget_id() {
                return target_id;
            }

            public String getTarget_url() {
                return target_url;
            }

            public String getType() {
                return type;
            }

            public static class GuideAdTarget{

                private String banner_image_url;

                private String cover_image_url;

                private int created_at;

                private int id;

                private int posts_count;

                private int status;

                private String subtitle;

                private String title;

                private int updated_at;

                public void setCreated_at(int created_at) {
                    this.created_at = created_at;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public void setPosts_count(int posts_count) {
                    this.posts_count = posts_count;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public void setSubtitle(String subtitle) {
                    this.subtitle = subtitle;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public void setUpdated_at(int updated_at) {
                    this.updated_at = updated_at;
                }

                public String getBanner_image_url() {
                    return banner_image_url;
                }

                public String getCover_image_url() {
                    return cover_image_url;
                }

                public int getCreated_at() {
                    return created_at;
                }

                public int getId() {
                    return id;
                }

                public int getPosts_count() {
                    return posts_count;
                }

                public int getStatus() {
                    return status;
                }

                public String getSubtitle() {
                    return subtitle;
                }

                public String getTitle() {
                    return title;
                }

                public int getUpdated_at() {
                    return updated_at;
                }
            }
        }
    }

}

