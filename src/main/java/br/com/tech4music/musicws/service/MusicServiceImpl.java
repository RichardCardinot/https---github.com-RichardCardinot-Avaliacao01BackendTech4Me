package br.com.tech4music.musicws.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4music.musicws.model.Musica;
import br.com.tech4music.musicws.repository.MusicaRepository;
import br.com.tech4music.musicws.shared.MusicaDto;

@Service
public class MusicServiceImpl implements MusicaService {
    ModelMapper mapper = new ModelMapper();
    
    @Autowired
    MusicaRepository repo;

    @Override
    public MusicaDto createMusic(MusicaDto music) {
        Musica musicaParaSalvar = mapper.map(music, Musica.class);
        musicaParaSalvar = repo.save(musicaParaSalvar);
        return mapper.map(musicaParaSalvar, MusicaDto.class);

        //return mapper.map(repo.save(mapper.map(music, Musica.class)), MusicaDto.class);
    }

    @Override
    public List<MusicaDto> readAllMusics() {   
        List<Musica> musics = repo.findAll();

        return musics.stream().
            map(m -> mapper.map(m, MusicaDto.class)).
            collect(Collectors.toList());
    }

    @Override
    public Optional<MusicaDto> readMusicById(String id) {
        Optional<Musica> targetMusic = repo.findById(id);

        if (targetMusic.isPresent()) {
            return Optional.of(mapper.map(targetMusic.get(), MusicaDto.class));
        }

        return Optional.empty();
    }

    @Override
    public Optional<MusicaDto> updateMusic(String id, MusicaDto music) {
        Optional<Musica> targetMusic = repo.findById(id);
        Musica updateMusic = mapper.map(music, Musica.class);

        if (targetMusic.isPresent()) {
            updateMusic.setId(id);
            return Optional.of(mapper.map(repo.save(updateMusic), MusicaDto.class));
        }

        return Optional.empty();
    }

    @Override
    public Boolean deleteMusicById(String id) {
        Optional<Musica> targetMusic = repo.findById(id);

        if (targetMusic.isPresent()) {
            repo.deleteById(id);
            return true;
            
        }

        return false;
    }
    
}
