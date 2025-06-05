package yaa.musicupload.model;

import org.springframework.web.multipart.MultipartFile;

public class SongForm {
    private int id;
    private String name;
    private String artist;
    private String genre;
    private MultipartFile songFile;

    public SongForm() {
    }

    public SongForm(int id, String name, String artist, String genre, MultipartFile songFile) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.songFile = songFile;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public MultipartFile getSongFile() {
        return songFile;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setSongFile(MultipartFile songFile) {
        this.songFile = songFile;
    }
}