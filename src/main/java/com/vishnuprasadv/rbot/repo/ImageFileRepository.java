package com.vishnuprasadv.rbot.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.vishnuprasadv.rbot.models.ImageFile;

public interface ImageFileRepository extends CrudRepository<ImageFile, Long> {
	Page<ImageFile> findAll(Pageable pageable);

	ImageFile findByImageUrl(String imageUrl);
}
