package com.choi.weplay.handler;


public class Constants {

    public enum ExceptionDomain {

        PRODUCT("product"), ORDER("Order"), PROVIDER("Provider");

        private String exceptionDomain;

        ExceptionDomain(String exceptionDomain) {
            this.exceptionDomain = exceptionDomain;
        }

        public String getExceptionDomain() {
            return exceptionDomain;
        }

        @Override
        public String toString() {
            return getExceptionDomain() + " Exception, ";
        }



    }

}
