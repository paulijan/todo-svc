package com.example.demo.web.api;

    public class ToDo {

        private long id;
        private String what;


        public ToDo(long id, String what) {
            this.id = id;
            this.what = what;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getWhat() {
            return what;
        }

        public void setWhat(String what) {
            this.what = what;
        }


    }
