package com.angel.present_say.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Angel on 2016/2/12.
 */
public class GuideList implements Serializable {

    private String code;

    private GuideListData data;

    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public GuideListData getData() {
        return data;
    }

    public void setData(GuideListData data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class GuideListData {

        private List<GuideListItems> items;

        private GuideListPage paging;

        public List<GuideListItems> getItems() {
            return items;
        }

        public void setItems(List<GuideListItems> items) {
            this.items = items;
        }

        public GuideListPage getPaging() {
            return paging;
        }

        public void setPaging(GuideListPage paging) {
            this.paging = paging;
        }

        public static class GuideListItems {

            private int content_type;

            private String content_url;

            private String cover_image_url;

            private int created_at;

            private int editor_id;

            private int id;

            private boolean liked;

            private int likes_count;

            private int published_at;

            private String share_msg;

            private String short_title;

            private int status;

            private String template;

            private String title;

            private String type;

            private int updated_at;

            private String url;

            private List<?> feature_list;

            private List<?> labels;

            public void setContent_type(int content_type) {
                this.content_type = content_type;
            }

            public void setContent_url(String content_url) {
                this.content_url = content_url;
            }

            public void setCover_image_url(String cover_image_url) {
                this.cover_image_url = cover_image_url;
            }

            public void setCreated_at(int created_at) {
                this.created_at = created_at;
            }

            public void setEditor_id(int editor_id) {
                this.editor_id = editor_id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setLiked(boolean liked) {
                this.liked = liked;
            }

            public void setLikes_count(int likes_count) {
                this.likes_count = likes_count;
            }

            public void setPublished_at(int published_at) {
                this.published_at = published_at;
            }

            public void setShare_msg(String share_msg) {
                this.share_msg = share_msg;
            }

            public void setShort_title(String short_title) {
                this.short_title = short_title;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public void setTemplate(String template) {
                this.template = template;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setType(String type) {
                this.type = type;
            }

            public void setUpdated_at(int updated_at) {
                this.updated_at = updated_at;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public void setFeature_list(List<?> feature_list) {
                this.feature_list = feature_list;
            }

            public void setLabels(List<?> labels) {
                this.labels = labels;
            }

            public int getContent_type() {
                return content_type;
            }

            public String getContent_url() {
                return content_url;
            }

            public String getCover_image_url() {
                return cover_image_url;
            }

            public int getCreated_at() {
                return created_at;
            }

            public int getEditor_id() {
                return editor_id;
            }

            public int getId() {
                return id;
            }

            public boolean isLiked() {
                return liked;
            }

            public int getLikes_count() {
                return likes_count;
            }

            public int getPublished_at() {
                return published_at;
            }

            public String getShare_msg() {
                return share_msg;
            }

            public String getShort_title() {
                return short_title;
            }

            public int getStatus() {
                return status;
            }

            public String getTemplate() {
                return template;
            }

            public String getTitle() {
                return title;
            }

            public String getType() {
                return type;
            }

            public int getUpdated_at() {
                return updated_at;
            }

            public String getUrl() {
                return url;
            }

            public List<?> getFeature_list() {
                return feature_list;
            }

            public List<?> getLabels() {
                return labels;
            }
        }

        public static class GuideListPage {
            private String next_url;

            public String getNext_url() {
                return next_url;
            }

            public void setNext_url(String next_url) {
                this.next_url = next_url;
            }
        }

    }

}






