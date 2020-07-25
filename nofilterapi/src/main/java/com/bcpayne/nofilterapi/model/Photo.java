package com.bcpayne.nofilterapi.model;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Photo {
    @Id
    private String id;

    private String title;

    private Binary image;

    public Photo(String title) {
        this.title = title;
    }

    public void setImage(Binary image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Binary getImage() {
        return image;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", image=" + image +
                '}';
    }
}
