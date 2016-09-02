package com.cafeapps.model;

public class Base {
    private String STATUS;
    private String STATUS_CODE;
    private Message MESSAGE;

    public class Message {

        private String PROD;
        private String DEVEL;

        public String getPROD() {
            return PROD;
        }

        public void setPROD(String PROD) {
            this.PROD = PROD;
        }

        public String getDEVEL() {
            return DEVEL;
        }

        public void setDEVEL(String DEVEL) {
            this.DEVEL = DEVEL;
        }
    }
}
