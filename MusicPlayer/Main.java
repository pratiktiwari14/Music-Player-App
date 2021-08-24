package MusicPlayer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;


public class Main {
	private static ArrayList<Album> albums=new ArrayList<>();
	
	public static void main (String[] args) {
		
		Album album=new Album("Album1","AC/DC");
	
		album.addSong("TNT",4.50);
		album.addSong("Highway to hell",3.50);
		album.addSong("ThunderStruck",5.0);
		albums.add(album);
		
		album=new Album("Album2","Eminem");
	
		album.addSong("Rap God",4.50);
		album.addSong("Not Afraid",3.50);
		album.addSong("Loose yourself",4.50);
		albums.add(album);
		
		LinkedList<Song> playList_1=new LinkedList<>();
		
		albums.get(0).addToPlayList("TNT",playList_1);
		albums.get(0).addToPlayList("Highway to hell",playList_1);	
		albums.get(1).addToPlayList("Rap God",playList_1);
		albums.get(1).addToPlayList("Loose yourself",playList_1);
		
		play(playList_1);
		
	}
	
	private static void play(LinkedList<Song> playList) {
		Scanner sc=new Scanner(System.in);
		boolean quit=false;
		boolean forward=true;
		ListIterator<Song> listIterator=playList.listIterator();
		
		if(playList.size()==0) {
			System.out.println("This PlayList have no song");
		}
		else {
			System.out.println("Now Playing "+ listIterator.next().toString());
			printMenu();
		}
		
		while(!quit) {
			int action=sc.nextInt();
			sc.nextLine();
			
			switch(action) {
			case 0:
				System.out.println("Playlist complete");
				quit=true;
				break;
				
			case 1:
				if(!forward) {
					if(listIterator.hasNext()) {
						listIterator.next();
					}
					forward=true;
				}
				if(listIterator.hasNext()) {
					System.out.println("Now Playing "+listIterator.next().toString());
				}
				else {
					System.out.println("No song available, reached to the end of the list");
					forward=false;
				}
				break;
				
			case 2:
				if(forward) {
					if(listIterator.hasPrevious()) {
						listIterator.previous();
					}
					forward=false;
				}
				if(listIterator.hasPrevious()) {
					System.out.println("Now Playing "+listIterator.previous().toString());
				}
				else {
					System.out.println("we are at 1st song");
					forward=false ;
				}
				break;
				
			case 3:
				if(forward) {
					if(listIterator.hasPrevious()) {
						System.out.println("Now Playing "+listIterator.previous().toString());
						forward=false;
					}
					else {
						System.out.println("we are at start of the list");
					}
				}
				else {
					if(listIterator.hasNext()) {
						System.out.println("Now Playing "+listIterator.next().toString());
						forward=true;
					}
					else {
						System.out.println("we have reached to thr end of playlist");
						}
					}
				break;
				
			case 4:
				printList(playList);
				break;
				
			case 5:
				printMenu();
				break;
				
			case 6:
				if(playList.size()>0) {
					listIterator.remove();
					if(listIterator.hasNext()) {
						System.out.println("Now playing "+listIterator.next().toString());
					}
					else {
						if(listIterator.hasPrevious()) {
							System.out.println("Now playing "+listIterator.previous().toString());
						}
					}
				}
				break;
			}
		}
	}
	
	private static void printMenu() {
		System.out.println("Available options \n press");
		System.out.println("0 - to quit\n"+
		
				"1 - to play next song\n"+
				"2 - to play previous song\n"+
				"3 - to replay the current song\n"+
				"4 - list of all song\n"+
				"5 - print all available options\n"+
				"6 - delete current song");
	}
	
	private static void printList(LinkedList<Song> playList) {
		Iterator<Song> iterator=playList.iterator();
		System.out.println("--------------------------------");
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("--------------------------------");
	}
}
