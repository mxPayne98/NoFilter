package com.bcpayne.nofilterapi.controller;

import com.bcpayne.nofilterapi.model.Photo;
import com.bcpayne.nofilterapi.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @PostMapping("/upload")
    public Map<String, String> addPhoto(@RequestParam("title") String title,
                                        @RequestParam("image") MultipartFile image,
                                        Model model) throws IOException {
        String id = photoService.addPhoto(title, image);
        Map<String, String> ret = new HashMap<>();
        ret.put("id", id);
        return ret;
    }

    @GetMapping("/photo/{id}")
    public Photo getPhoto(@PathVariable String id, Model model) {
        Photo photo = photoService.getPhoto(id);
        model.addAttribute("title", photo.getTitle());
        model.addAttribute("image",
                Base64.getEncoder().encodeToString(photo.getImage().getData()));
        return photo;
    }
}
