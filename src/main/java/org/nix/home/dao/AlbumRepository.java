package org.nix.home.dao;

import org.nix.home.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album,Integer> {



}
