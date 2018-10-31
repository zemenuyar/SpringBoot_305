package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    ActoreRepository actoreRepository;

    @Autowired
    MovieRepository movieRepository;


    @RequestMapping("/")
    public String index(Model model){
        //first lets Create an Actor
        Actor actor = new Actor();
        actor.setName("Sandra Bullock");
        actor.setRealname("Sandra Mae bullowski");
        //Now let`s create a movie
        Movie movie = new Movie();
        movie.setTitle("Emoji Movie");
        movie.setYear(2017);
        movie.setDescription("About Emojis...");

        //Add the movies to an empty list
        Set<Movie>movies = new HashSet<Movie>();
        movies.add(movie);

        //add the list of movies to the actor`s movie list actorRepository.save(actor);
        actor.setMovieset(movies);

        //save the actors from the database
        actoreRepository.save(actor);

        //Grad all the actors from the database and send them to
        // the template
        model.addAttribute("Actors",actoreRepository.findAll());
        return "index";

    }
}
