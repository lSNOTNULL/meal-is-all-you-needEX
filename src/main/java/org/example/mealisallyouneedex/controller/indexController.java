package org.example.mealisallyouneedex.controller;

import org.apache.ibatis.session.SqlSession;
import org.example.mealisallyouneedex.config.MyBatisConfig;
import org.example.mealisallyouneedex.model.mapper.AnimeMapper;
import org.example.mealisallyouneedex.model.mapper.TestMapper;
import org.example.mealisallyouneedex.model.vo.Anime;
import org.example.mealisallyouneedex.model.vo.AnimeRequestDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Controller
@RequestMapping("/")
public class indexController {
    final Logger logger = Logger.getLogger(MyBatisConfig.class.getName());
    @GetMapping("/")
    public String index(Model model) {
        try (SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession()) {
//            TestMapper mapper = session.getMapper(TestMapper.class);
//            int result = mapper.selectOnePlusOne();
            AnimeMapper animeMapper = session.getMapper(AnimeMapper.class);
            List<Anime> result = animeMapper.getAllAnimes();
            model.addAttribute("result", result);
        }
        return "index";
    }

    @PostMapping("/vote")
    public String vote(@RequestParam("uuid") String uuid) {
        try (SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession()) {
            AnimeMapper animeMapper = session.getMapper(AnimeMapper.class);
            animeMapper.insertAnimeVote(uuid);
            session.commit();
        }

        return "redirect:/";
    }

    @PostMapping("/anime")
    public String anime(Model model, @ModelAttribute AnimeRequestDTO dto) {
        //@ModelAttribute -> AnumeRequestDTO에 form에서 입력한 내용이 자동으로 매핑됨
        try (SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession()) {
            AnimeMapper animeMapper = session.getMapper(AnimeMapper.class);
            int count = animeMapper.insertAnime(
                    new Anime(
                            UUID.randomUUID().toString(),
                            dto.title(), dto.description(),
                            // dto.%% 로 인해 form 입력값이 들어가게 되는 것
                            "" // default 라서
                            ,0 // JOIN 으로 생성될 것
                    ));
            logger.info(count + " anime inserted");
            // 커밋해주셔야해요... ㅠㅠ
            session.commit();
        }
//        return "index";
        return "redirect:/";
    }
}
