import java.util.ArrayList;
import java.util.List;
// SongAdd class to hold and manage playlist
public class SongAdd {
// List where the songs will be stored
    private ArrayList<Song> songs;

    public SongAdd() {
        songs = new ArrayList<>();
// Addition of songs to the playlist with title, artist and stream count
        songs.add(new Song("Blinding Lights", "The Weekend", 2106158897));
        songs.add(new Song("22", "Taylor Swift", 207124019));
        songs.add(new Song("Runaway", "Kanye West", 507008104));
        songs.add(new Song("Someone Like You", "Adele", 1733304688));
        songs.add(new Song("Cruel Summer", "Taylor Swift", 1373883855));
        songs.add(new Song("Water", "Tyla", 185514344));
        songs.add(new Song("I Wanna Be Yours", "Arctic Monkeys", 1616355875));
        songs.add(new Song("As It Was", "Harry Styles", 2125940601));
        songs.add(new Song("Kill Bill", "SZA", 1467408691));
        songs.add(new Song("Another Love", "Tom Odell", 2046540297));
    }
// Method to add a new song to the playlist
    public boolean addSong(Song song) {
        return songs.add(song);
    }
// Method to remove song from the playlist by title 
    public void removeSong(String title) {
        Song songToRemove = findByTitle(title);
        if (songToRemove != null) {
            songs.remove(songToRemove);
// Song will be removed if found 
            System.out.println("Song removed successfully.");
        } else {
// If title is not in playlist song will not be removed 
            System.out.println("Song not found in the list.");
        }
    }
// Method to get a list of songs
    public List<Song> getAllSongs() {
// Method to create new list due to adding and removing of songs
        List<Song> allSongs = new ArrayList<>();
        for (Song song : songs) {
            allSongs.add(song);
        }
// Returns new list 
        return allSongs;
    }
// Method to find song by title
    Song findByTitle(String title) {
        for (Song song : songs) {
// Case is ignore 
            if (song.getTitle().equalsIgnoreCase(title)) {
// Song is returned if found
                return song;
            }
        }
// Return null if song isn't found
        return null;
    }
    
// Method to test functionality
    public static void main(String[] args) {
// Instance of SongAdd
        SongAdd songAdd = new SongAdd();
// Add a new song with title, artist and stream count
        songAdd.addSong(new Song("New Song", "New Artist", 100000));
// Get list of all songs
        songAdd.getAllSongs();
// Remove song through title
        songAdd.removeSong("New Song");
// Get list of all songs
        songAdd.getAllSongs();
    }
}
