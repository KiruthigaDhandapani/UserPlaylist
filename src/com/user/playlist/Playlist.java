package com.user.playlist;

import java.util.*;

public class Playlist {

	public static PlayListAction playlistAction;

	public static void main(String args[]) {
		
		playlistAction = new PlayListAction();
		
		Map<String, PlaylistPojo> userPlaylistMap = playlistAction.populateUserAndPlaylist();
		
		System.out.println("Available Users and Song PlaylistPojo:");
		userPlaylistMap.entrySet().forEach(entry -> {
			System.out.println(entry.getKey() + " -- " + Arrays.toString(entry.getValue().getSongs()));
		});
		
		try (
				// Get input from user
		Scanner sc = new Scanner(System.in)) {
			String moreInputs = "Y"; // default yes
			
			while (moreInputs.equals("Y")) {
				
				System.out.print("Enter user name- ");
				String userName = sc.nextLine();
				
				System.out.print("Enter song name to play- ");
				String songName = sc.nextLine();
				
				// Update recent playlist
				playlistAction.updateRecentPlaylist(userPlaylistMap, userName, songName);
				Queue<String> newPlayList = playlistAction.getRecentPlaylist(userPlaylistMap, userName);

				System.out.println("Recent PlaylistPojo for:" + userName + "  " + newPlayList);

				System.out.println("Would you like to try more inputs? Y or N");
				moreInputs = sc.nextLine();
			}
		}
		System.out.println("Thank you..");
	}

}
