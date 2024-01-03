
import java.util.List;
import java.util.Scanner;
// SelectOption class for user interaction of the SongAdd class
public class SelectOption {
    public static void main(String[] args) {
// Instance of SongAdd class to access and manage songs
        SongAdd songAdd = new SongAdd();
        
// Scanner for user interation/ input      
        try (Scanner scanner = new Scanner(System.in)) {
            int songChoice;
            String answer;
// Main loop for user interaction
            do {
                System.out.println("Please select an option");
                System.out.println("Press 1 to add a song");
                System.out.println("Press 2 to remove a song");
                System.out.println("Press 3 to view the full song list");
                System.out.println("Press 4 to view songs over a certain stream count");
                System.out.println("Press 5 to exit");
// Get user input for the chosen option
                songChoice = scanner.nextInt();
                scanner.nextLine(); 
// Switch statement for different options that user has selected
                switch (songChoice) {
                    case 1:
// Option to add a song                 
                        do {
                            System.out.println("Enter the song name: ");
                            String songName = scanner.nextLine();

                            System.out.println("Enter the artist name: ");
                            String artistName = scanner.nextLine();

                            System.out.println("Enter the stream count: ");
                            int streamCount = scanner.nextInt();
                            scanner.nextLine(); 

                            Song newSong = new Song(songName, artistName, streamCount);
                            songAdd.addSong(newSong);

                            System.out.println("Do you want to add another song? (yes/no)");
                            answer = scanner.nextLine();
                        } while (answer.equalsIgnoreCase("yes"));
                        break;

                    case 2:
// Option to remove a song
                        System.out.println("Enter the name of the song to remove from the playlist: ");
                        String titleToRemove = scanner.nextLine();
                        
                        Song songToRemove = songAdd.findByTitle(titleToRemove);

                        if (songToRemove != null) {
                            songAdd.removeSong(titleToRemove);
                            System.out.println("Song removed");
                        } else {
                            System.out.println("Song not found");
                        }
                        break;


                    case 3:
 // Option to view the full song list including any songs that have been added
                    List<Song> allSongsAfterAdding = songAdd.getAllSongs();
                    System.out.println("All songs after adding:");
                    for (Song song : allSongsAfterAdding) {
                        System.out.println(song.getTitle() + " by " + song.getArtist());
                        System.out.println("Streams: " + String.format("%,d", song.getStreams()));
                    }
                        break;

                        case 4:
// Option to view songs over a certain stream count
                        System.out.println("Enter the stream count threshold:");
                        int threshold = scanner.nextInt();
                        scanner.nextLine(); 
                    
                        List<Song> streamThreshold = songAdd.getAllSongs();
                    
                        System.out.println("Songs with stream count over " + threshold + ": ");
                        for (Song song : streamThreshold) {
                            if (song.getStreams() > threshold) {
                                System.out.println(song.getTitle() + " by " + song.getArtist());
                                System.out.println("Streams: " + String.format("%,d", song.getStreams()));
                            }
                        }
                        break;
                    

                    case 5:
// Option to exit the program
                        System.out.println("Exiting the program. Goodbye!");
                        break;
                }
// Continue the loop until the user chooses to exit
            } while (songChoice != 5);
        }
    }
}