package com.bcpayne.nofilterapi.dao;

import com.bcpayne.nofilterapi.model.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PhotoRepository extends MongoRepository<Photo, String> {
}
