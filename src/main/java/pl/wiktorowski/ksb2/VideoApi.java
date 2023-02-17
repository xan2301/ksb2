package pl.wiktorowski.ksb2;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/videos")

public class VideoApi {

    private List<Video1> videoList;

    public VideoApi() {
        this.videoList = new ArrayList<>();
        videoList.add(new Video1(1L, "Wyjaśniam Gdzie Przepadłem i Przedstawiam Propozycje Wspólnego Zaangażowania Się w WOŚP [Daily Vlog]", "https://youtu.be/1ZAF9WQuv6Y"));
        videoList.add(new Video1(2L, "Spring Boot We Współpracy Z JDBC", "https://youtu.be/2xmxYBJdOfA"));
    }

    @GetMapping
    public ResponseEntity<List<Video1>> getVideos() {

        return new ResponseEntity<>(videoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Video1> getVideoByID(@PathVariable long id) {

        Optional<Video1> first = videoList.stream().filter(video -> video.getId() == id).findFirst();
        if (first.isPresent()) {


            return new ResponseEntity<>(first.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping

    public ResponseEntity addVideo(@RequestBody Video1 video) {
        boolean add = videoList.add(video);

        if (add) {
            return new ResponseEntity<>(HttpStatus.CREATED);

        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @PutMapping

    public ResponseEntity modVideo(@RequestBody Video1 newVideo) {

        Optional<Video1> first = videoList.stream().filter(video -> video.getId() == newVideo.getId()).findFirst();
        if (first.isPresent()) {

            videoList.remove(first.get());
            videoList.add(newVideo);

            return new ResponseEntity(HttpStatus.OK);

        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")

    public ResponseEntity removeVideo(@PathVariable long id) {

        Optional<Video1> first = videoList.stream().filter(video -> video.getId() == id).findFirst();
        if (first.isPresent()) {
            videoList.remove(first.get());

            return new ResponseEntity<>(first.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
