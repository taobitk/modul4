package yaa.musicupload.service;

import org.springframework.stereotype.Service;
import yaa.musicupload.model.Song;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service // Đánh dấu đây là một Spring service component
public class SongService implements ISongService {
    private final List<Song> songs = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger(); // Để tự động tạo ID đơn giản

    public SongService() {
          }

    @Override
    public List<Song> findAll() {
        return new ArrayList<>(songs); // Trả về một bản copy để tránh sửa đổi từ bên ngoài
    }

    @Override
    public void save(Song song) {
        if (song.getId() == 0) { // Nếu là bài hát mới (chưa có ID)
            song.setId(idCounter.incrementAndGet()); // Gán ID tự tăng
            songs.add(song);
        } else {
            int index = -1;
            for (int i = 0; i < songs.size(); i++) {
                if (songs.get(i).getId() == song.getId()) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                songs.set(index, song);
            } else {
                  song.setId(idCounter.incrementAndGet()); // Gán ID mới nếu ID cũ không hợp lệ
                songs.add(song);
            }
        }
    }

    @Override
    public Song findById(int id) {
        for (Song song : songs) {
            if (song.getId() == id) {
                return song;
            }
        }
        return null; // Hoặc ném ra một Exception nếu không tìm thấy
    }
}