// Song class to show a basic formation of a song and its characteristics - Title, Artist and Streams

class Song {
// Private fields to store the title, artist, and streams for a song
    private String title;
    private String artist;
    private long streams; 

 // Constructor to initialize the Song object with title, artist, and streams
    public Song(String title, String artist, long streams) {
        this.title = title;
        this.artist = artist;
        this.streams = streams;
    }
// Getter method to retrieve the title of the song
    public String getTitle() {
        return title;
    }
// Getter method to retrieve the artist of the song
    public String getArtist() {
        return artist;
    }
// Getter method to retrieve the number of streams for the song
    public long getStreams() {
        return streams;
    }
}
