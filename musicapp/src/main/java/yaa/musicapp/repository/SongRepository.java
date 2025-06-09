package yaa.musicapp.repository;

import org.springframework.stereotype.Repository;
import yaa.musicapp.model.Song;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional // Giao cho Spring quản lý các transaction
public class SongRepository implements ISongRepository {

    // EntityManager được Spring tự động inject vào
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Song> findAll() {
        TypedQuery<Song> query = entityManager.createQuery("SELECT s FROM Song s", Song.class);
        return query.getResultList();
    }

    @Override
    public Song findById(Long id) {
        return entityManager.find(Song.class, id);
    }

    @Override
    public void save(Song song) {
        if (song.getId() != null) {
            entityManager.merge(song); // Cập nhật
        } else {
            entityManager.persist(song); // Thêm mới
        }
    }

    @Override
    public void remove(Long id) {
        Song song = findById(id);
        if (song != null) {
            entityManager.remove(song);
        }
    }
}