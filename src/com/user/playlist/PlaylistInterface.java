package com.user.playlist;

import java.util.Map;

public interface PlaylistInterface {

	public abstract Map<String, PlaylistPojo> populateUserAndPlaylist(); 
	public abstract void updateRecentPlaylist(Map<String, PlaylistPojo> userPlaylistMap, String userName, String songName);
	
}