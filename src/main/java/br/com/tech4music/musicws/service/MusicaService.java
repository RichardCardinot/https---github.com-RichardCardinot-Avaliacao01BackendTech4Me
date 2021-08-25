package br.com.tech4music.musicws.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4music.musicws.shared.MusicaDto;

public interface MusicaService {
    MusicaDto createMusic(MusicaDto music);
    List<MusicaDto> readAllMusics();
    Optional<MusicaDto> readMusicById(String id);
    Optional<MusicaDto> updateMusic(String id, MusicaDto music);
    Boolean deleteMusicById(String id);   
}
