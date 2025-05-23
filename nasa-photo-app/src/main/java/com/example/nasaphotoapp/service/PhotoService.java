package com.example.nasaphotoapp.service;

import com.example.nasaphotoapp.model.Photo;
import com.example.nasaphotoapp.repository.PhotoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PhotoService {
    private final PhotoRepository photoRepository;
    private final RestTemplate restTemplate = new RestTemplate();
    private static final String NASA_API_KEY = "Upyvx2sAWQZjDCiRQ11cR1PXRieRyhCvG3kSwwKe";
    private static final String NASA_API_URL = "https://api.nasa.gov/planetary/apod?api_key=" + NASA_API_KEY;

    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public Photo getPhotoOfTheDay() {
        LocalDate today = LocalDate.now();
        Optional<Photo> existingPhoto = photoRepository.findByDate(today);

        if (existingPhoto.isPresent()) {
            return existingPhoto.get();
        }

        String response = restTemplate.getForObject(NASA_API_URL, String.class);
        JSONObject json = new JSONObject(response);

        Photo photo = new Photo(
                json.getString("title"),
                json.getString("url"),
                json.getString("explanation"),
                today
        );
        return photoRepository.save(photo);
    }
}
