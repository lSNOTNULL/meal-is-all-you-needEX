package org.example.mealisallyouneedex.model.mapper;

import org.example.mealisallyouneedex.model.vo.Anime;

import java.util.List;

public interface AnimeMapper {
    int insertAnime(Anime anime);
    List<Anime> getAllAnimes();

}
