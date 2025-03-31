package org.example.mealisallyouneedex.model.mapper;

import org.example.mealisallyouneedex.model.vo.Anime;

import java.util.List;
import java.util.UUID;

public interface AnimeMapper {
    int insertAnime(Anime anime);
    List<Anime> getAllAnimes();
    int insertAnimeVote(String uuid);

}
