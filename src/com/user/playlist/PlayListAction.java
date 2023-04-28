package com.user.playlist;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class PlayListAction implements  PlaylistInterface {

	public static String user1 = "U1";
	public static PlaylistPojo userPlaylist;
	public static String[] user1Songs = { "S1", "S2", "S3", "S4" };
	public static String user2 = "U2";
	public static String[] user2Songs = { "S1", "S3", "S4", "S5" };
	public static final int RECENT_PALYLIST_CAPACITY = 2;
	public static Queue<String> recentPlaylist ;


	// Populate user and PlaylistPojo
	@Override
	public Map<String, PlaylistPojo> populateUserAndPlaylist() {

		userPlaylist = new PlaylistPojo();
		Map<String, PlaylistPojo> userPlaylistMap = new HashMap<String, PlaylistPojo>();

		// Populate playlist for user 1
		userPlaylist.setSongs(user1Songs);
		userPlaylistMap.put(user1, userPlaylist);

		// Populate playlist for user 2
		userPlaylist.setSongs(user2Songs);
		userPlaylistMap.put(user2, userPlaylist);

		return userPlaylistMap;
	}

	// update recent playlist
	@Override
	public void updateRecentPlaylist(Map<String, PlaylistPojo> userPlaylistMap, String userName, String songName) {

		userPlaylist = userPlaylistMap.get(userName);
		recentPlaylist = userPlaylist.getRecentPlaylist();

		if (recentPlaylist == null || recentPlaylist.isEmpty()) {
			recentPlaylist = new LinkedList<String>();
			recentPlaylist.add(songName);
		} else {

			if (recentPlaylist.size() >= RECENT_PALYLIST_CAPACITY) {
				System.out.println("inside if..");
				recentPlaylist.poll(); // removes first element
			}
			recentPlaylist.add(songName); // adds at last
		}
		userPlaylist.setRecentPlaylist(recentPlaylist);
	}

	public Queue<String> getRecentPlaylist(Map<String, PlaylistPojo> userPlaylistMap, String userName) {
		
		PlaylistPojo userPlaylist = userPlaylistMap.get(userName);
		return userPlaylist.getRecentPlaylist();
	}
}
