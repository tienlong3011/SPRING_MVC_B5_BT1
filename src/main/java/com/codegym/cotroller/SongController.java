package com.codegym.cotroller;

import com.codegym.model.Song;
import com.codegym.model.SongForm;
import com.codegym.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("songs")
public class SongController {
    @Autowired
    private SongService songService;
    @Value("${file-upload}")
    private String fileUpload;
    @GetMapping("")
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("song/list");
        List<Song> songs = songService.findAll();
        modelAndView.addObject("songs",songs);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/song/create");
        modelAndView.addObject("songForm", new SongForm());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute SongForm songForm){
        MultipartFile multipartFile = songForm.getSongFilePath();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(songForm.getSongFilePath().getBytes(), new File(fileUpload +fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Song song = new Song(songForm.getId(),songForm.getNameSong(),songForm.getSinger(),songForm.getMusicGenre(),fileName);
        songService.save(song);
        ModelAndView modelAndView = new ModelAndView("song/create");
        modelAndView.addObject("songForm", songForm);
        modelAndView.addObject("message", "Created new product successfully !");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showViewEdit(@PathVariable ("id") long id){
        ModelAndView modelAndView = new ModelAndView("/song/edit");
        Song song = songService.findOne(id);
        songService.delete(song);
        modelAndView.addObject("songForm", new SongForm());
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute SongForm songForm){
        MultipartFile multipartFile = songForm.getSongFilePath();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(songForm.getSongFilePath().getBytes(), new File(fileUpload +fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Song song = new Song(songForm.getId(),songForm.getNameSong(),songForm.getSinger(),songForm.getMusicGenre(),fileName);
        songService.save(song);
        ModelAndView modelAndView = new ModelAndView("song/edit");
        modelAndView.addObject("songForm", songForm);
        modelAndView.addObject("message", "Created new product successfully !");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView remove(@PathVariable ("id") long id){
        ModelAndView modelAndView = new ModelAndView("redirect:/songs");
        Song song = songService.findOne(id);
        songService.delete(song);
        return modelAndView;
    }
}
