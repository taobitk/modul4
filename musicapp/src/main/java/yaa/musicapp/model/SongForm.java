package yaa.musicapp.model;

import org.springframework.web.multipart.MultipartFile;

public class SongForm {
    private Long id;
    private String name;
    private String artist;
    private String genre;
    private MultipartFile filePath;

    // Constructors, Getters, and Setters
    public SongForm() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist = artist; }
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    public MultipartFile getFilePath() { return filePath; }
    public void setFilePath(MultipartFile filePath) { this.filePath = filePath; }
}
