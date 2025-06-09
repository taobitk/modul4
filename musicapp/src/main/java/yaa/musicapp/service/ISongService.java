package yaa.musicapp.service;

import yaa.musicapp.model.Song;
import yaa.musicapp.model.SongForm;
import java.util.List;

public interface ISongService {
    List<Song> findAll();
    Song findById(Long id);
    void save(SongForm songForm);
    void remove(Long id);
}
