package com.kwetter.frits.wsservice.entity;

import java.util.List;

public class NotifyFollowersDTO {

    private List<String> followers;

    public NotifyFollowersDTO() {
    }

    public NotifyFollowersDTO(List<String> followers) {
        this.followers = followers;
    }

    public List<String> getFollowers() {
        return followers;
    }

    public void setFollowers(List<String> followers) {
        this.followers = followers;
    }
}
