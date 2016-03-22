package harman.musicplayer;


// data for single audio file
public class Song {

    private long id;
    private String title;
    private String artist;
    private String duration;

    public Song (long songID, String songTitle, String songArtist,String songDuration) {
        this.id = songID;
        this.title = songTitle;
        this.artist = songArtist;
        this.duration = songDuration;
    }

    public long getID() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getArtist() {
        return this.artist;
    }

    public String getDuration() {
        return this.duration;
    }


}
