package br.com.tech4music.musicws.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4music.musicws.service.MusicaService;
import br.com.tech4music.musicws.shared.MusicaDto;

@RestController
@RequestMapping(value = "/api/musicas")
public class MusicaController {
    @Autowired
    MusicaService service;

    @PostMapping
    public ResponseEntity<MusicaDto> postMusic(@RequestBody MusicaDto music) {
        return new ResponseEntity<>(service.createMusic(music), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MusicaDto> getById(@PathVariable String id) {
        Optional<MusicaDto> targetMusic = service.readMusicById(id);

        if (targetMusic.isPresent()) {
            return new ResponseEntity<>(targetMusic.get(), HttpStatus.FOUND);
        }
        
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping()
    public ResponseEntity<List<MusicaDto>> getAll() {
        return new ResponseEntity<>(service.readAllMusics(), HttpStatus.OK) ;
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MusicaDto> putMusic(@PathVariable String id, @RequestBody MusicaDto music) {
        Optional<MusicaDto> updateMusic = service.updateMusic(id, music);

        if (updateMusic.isPresent()) {
            return new ResponseEntity<>(updateMusic.get(), HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteMusic(@PathVariable String id) {

        if (service.deleteMusicById(id)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }

        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        
    }
    
}
