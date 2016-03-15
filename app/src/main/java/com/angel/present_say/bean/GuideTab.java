package com.angel.present_say.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Angel on 2016/2/12.
 */
public class GuideTab implements Serializable {

    private int code;

    private GuideTabData data;

    private String message;

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(GuideTabData data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public GuideTabData getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public static class GuideTabData {

        private List<GuideCandidates> candidates;

        private List<GuideChannels> channels;

        public void setCandidates(List<GuideCandidates> candidates) {
            this.candidates = candidates;
        }

        public void setChannels(List<GuideChannels> channels) {
            this.channels = channels;
        }

        public List<GuideCandidates> getCandidates() {
            return candidates;
        }

        public List<GuideChannels> getChannels() {
            return channels;
        }

        public static class GuideCandidates {

            private boolean editable;

            private int id;

            private String name;

            public void setEditable(boolean editable) {
                this.editable = editable;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setName(String name) {
                this.name = name;
            }

            public boolean isEditable() {
                return editable;
            }

            public int getId() {
                return id;
            }

            public String getName() {
                return name;
            }
        }

        public static class GuideChannels {

            private boolean editable;

            private int id;

            private String name;

            public void setEditable(boolean editable) {
                this.editable = editable;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setName(String name) {
                this.name = name;
            }

            public boolean isEditable() {
                return editable;
            }

            public int getId() {
                return id;
            }

            public String getName() {
                return name;
            }
        }
    }
}


