package kr.co.daou.hc.gwonii.api.model;

public class FTPSettingModel {

    private int port;
    private String host;
    private String user;
    private String password;

    private FTPSettingModel(FTPModelBuilder ftpModelBuilder) {
        this.port = ftpModelBuilder.port;
        this.host = ftpModelBuilder.host;
        this.user = ftpModelBuilder.user;
        this.password = ftpModelBuilder.password;
    }

    public static class FTPModelBuilder {
        private int port;
        private String host;
        private String user;
        private String password;

        public FTPModelBuilder port(int port) {
            this.port = port;
            return this;
        }

        public FTPModelBuilder host(String host) {
            this.host = host;
            return this;
        }

        public FTPModelBuilder user(String user) {
            this.user = user;
            return this;
        }

        public FTPModelBuilder password(String password) {
            this.password = password;
            return this;
        }

        public FTPSettingModel build() {
            return new FTPSettingModel(this);
        }
    }

    public int getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "FTPModel{" +
                "port=" + port +
                ", host='" + host + '\'' +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
