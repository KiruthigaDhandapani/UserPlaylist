package com.user.playlist;

import java.util.Queue;

public class PlaylistPojo {


    private String[] songs;

    private Queue<String> recentPlaylist;


    public Queue<String> getRecentPlaylist() {
        return recentPlaylist;
    }

    public void setRecentPlaylist(Queue<String> recentPlaylist) {
        this.recentPlaylist = recentPlaylist;
    }

    public String[] getSongs() {
        return songs;
    }

    public void setSongs(String[] songs) {
        this.songs = songs;
    }
}
