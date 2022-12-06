public class PlayListRunner {
	public static void main(String[] args) {
		
		
		// create object using default constructor
		PlayList test1 = new PlayList();
		// test the default constructor which also tests the toString() method
		System.out.println(test1);
		// create object using the initialization constructor
		PlayList test2 = new PlayList(2);
		// test the initilization constructor which also tests the toString() method
		System.out.println(test2);
		// create extra playlist for equality testing later
		PlayList test3 = test2;
		// call the setList() method
		test1.setList(2);
		// test the setList() method
		System.out.println(test1);
		// call the addSong() method
		test2.addSong(0, new Song("song1", "album1", "artist1", 250));
		test2.addSong(1, new Song("song2", "album2", "artist2", 350));
		// call the getSong() method which also tests the addSong() method
		System.out.println(test2.getSong(0));
		// call the numSongs() method
		System.out.println(test2.numSongs());
		// call the totalLength() method
		System.out.println(test2.totalLength());
		// call the removeArtist() method
		test2.removeArtist("artist1");
		// display updated list
		System.out.println(test2);
		// add song back
		test2.addSong(1, new Song("song1", "album1", "artist1", 250));
		// call the removeLength() method
		test2.removeLength(300);
		// display updated list
		System.out.println(test2);
		// add song back
		test2.addSong(1, new Song("song2", "album2", "artist2", 350));
		// display updated list
		System.out.println(test2);
		// call shuffle() method
		test2.shuffle();
		// display updated list
		System.out.println(test1);
		System.out.println(test2);
		System.out.println(test3);
		// call the equals method on non-equal objects
		System.out.println(test1.equals(test2));
		//call the equals method on equal objects
		System.out.println(test2.equals(test3));

		
	}
}