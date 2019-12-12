package kr.co.daou.hc.gwonii.api.model;

public class ParsingLogModel {

    private String ip;
    private String email;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int second;
    private String httpMethod;
    private String requestUri;

    private ParsingLogModel (ParsingLogModelBuilder parsingLogModelBuilder) {
        this.ip = parsingLogModelBuilder.ip;
        this.email = parsingLogModelBuilder.email;
        this.year = parsingLogModelBuilder.year;
        this.month = parsingLogModelBuilder.month;
        this.day = parsingLogModelBuilder.day;
        this.hour = parsingLogModelBuilder.hour;
        this.minute = parsingLogModelBuilder.minute;
        this.second = parsingLogModelBuilder.second;
        this.httpMethod = parsingLogModelBuilder.httpMethod;
        this.requestUri = parsingLogModelBuilder.requestUri;
    }

    public static class ParsingLogModelBuilder {
        private String ip;
        private String email;
        private int year;
        private int month;
        private int day;
        private int hour;
        private int minute;
        private int second;
        private String httpMethod;
        private String requestUri;

        public ParsingLogModelBuilder ip(String ip) {
            this.ip = ip;
            return this;
        }

        public ParsingLogModelBuilder email(String email) {
            this.email = email;
            return this;
        }

        public ParsingLogModelBuilder year(String year) {
            this.year = Integer.parseInt(year);
            return this;
        }

        public ParsingLogModelBuilder month(String month) {
            this.month = Integer.parseInt(month);
            return this;
        }

        public ParsingLogModelBuilder day(String day) {
            this.day = Integer.parseInt(day);
            return this;
        }

        public ParsingLogModelBuilder hour(String hour) {
            this.hour = Integer.parseInt(hour);
            return this;
        }

        public ParsingLogModelBuilder minute(String minute) {
            this.minute = Integer.parseInt(minute);
            return this;
        }

        public ParsingLogModelBuilder second(String second) {
            this.second = Integer.parseInt(second);
            return this;
        }

        public ParsingLogModelBuilder httpMethod(String httpMethod) {
            this.httpMethod = httpMethod;
            return this;
        }

        public ParsingLogModelBuilder requestUri(String requestUri) {
            this.requestUri = requestUri;
            return this;
        }

        public ParsingLogModel build() {
            return new ParsingLogModel(this);
        }
    }

    public String getIp() {
        return ip;
    }

    public String getEmail() {
        return email;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public String getRequestUri() {
        return requestUri;
    }

    @Override
    public String toString() {
        return "ParsingLogModel{" +
                "ip='" + ip + '\'' +
                ", email='" + email + '\'' +
                ", httpMethod='" + httpMethod + '\'' +
                ", requestUri='" + requestUri + '\'' +
                '}';
    }
}
