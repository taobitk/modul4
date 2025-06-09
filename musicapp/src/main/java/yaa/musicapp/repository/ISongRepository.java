package yaa.musicapp.repository;

import yaa.musicapp.model.Song;
import java.util.List;

public interface ISongRepository {
    List<Song> findAll();
    Song findById(Long id);
    void save(Song song);
    void remove(Long id);
}