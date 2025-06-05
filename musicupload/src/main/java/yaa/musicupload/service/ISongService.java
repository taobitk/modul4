package yaa.musicupload.service;

import yaa.musicupload.model.Song;
import java.util.List;

public interface ISongService {
    List<Song> findAll();
    void save(Song song);
    Song findById(int id); // Có thể cần sau này, ví dụ để xem chi tiết hoặc xóa
}