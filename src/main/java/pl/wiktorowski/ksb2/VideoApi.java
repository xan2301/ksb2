package pl.wiktorowski.ksb2;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/videos")

public class VideoApi {

    private List<Video> videoList;

    public VideoApi() {
        this.videoList = new ArrayList<>();
        videoList.add( new Video(1L,"Wyjaśniam Gdzie Przepadłem i Przedstawiam Propozycje Wspólnego Zaangażowania Się w WOŚP [Daily Vlog]", "https://youtu.be/1ZAF9WQuv6Y"));
        videoList.add( new Video(2L,"Spring Boot We Współpracy Z JDBC", "https://youtu.be/2xmxYBJdOfA"));
    }

    @GetMapping
    public ResponseEntity<List<Video>> getVideos(){

        return new ResponseEntity<>(videoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Video> getVideoByID(@PathVariable long id){

        Optional<Video> first = videoList.stream().filter(video -> video.getId() == id).findFirst();
        if(first.isPresent()) {


            return new ResponseEntity<>(first.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }





}
