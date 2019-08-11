package org.nix.home.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nix.home.HomeApplication;
import org.nix.home.entity.Album;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HomeApplication.class)
public class AlbumRepositoryTest {

    @Resource
    private AlbumRepository albumRepository;

    @Test(expected = RuntimeException.class)
    @Transactional(rollbackFor = RuntimeException.class)
    public void test() {
        testAlbum();
    }

    public void testAlbum() {
        Album album = new Album();
        album.setCover("封面");
        album.setName("测试相册");
        album.setPhotoNumber(12);

        albumRepository.saveAndFlush(album);

        Optional<Album> byId = albumRepository.findById(album.getId());
        Album album1 = byId.get();
        assertNotNull(album1);
        throw new RuntimeException("aaaa");
    }
}
