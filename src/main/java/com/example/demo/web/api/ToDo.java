package com.example.demo.web.api;

    public class ToDo {

        private long id;
        private String todo;
        private boolean done;

        public ToDo(long id, String todo, boolean done) {
            this.id = id;
            this.todo = todo;
            this.done = done;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getTodo() {
            return todo;
        }

        public void setTodo(String todo) {
            this.todo = todo;
        }

        public boolean isDone() {
            return done;
        }

        public void setDone(boolean done) {
            this.done = done;
        }
    }
