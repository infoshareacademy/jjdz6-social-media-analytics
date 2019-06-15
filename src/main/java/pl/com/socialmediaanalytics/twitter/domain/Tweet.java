package pl.com.socialmediaanalytics.twitter.domain;

import pl.com.socialmediaanalytics.twitter.dto.UserDTO;

public class Tweet {

        String createdAt;
        Long id;
        String text;
        UserDTO user;

        public String getCreatedAt() {
            return createdAt;
        }

        public Long getId() {
            return id;
        }

        public String getText() {
            return text;
        }

        public UserDTO getUser() {
            return user;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public void setText(String text) {
            this.text = text;
        }

        public void setUser(UserDTO user) {
            this.user = user;
        }

        @Override
        public String toString() {
            return "createdAt='" + createdAt + '\'' +
                    ", id=" + id +
                    ", text='" + text + '\'' +
                    ", user=" + user;
        }

}
