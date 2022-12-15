package com.jarod.controller;

import com.jarod.bean.Movie;
import com.jarod.dao.CollectDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@Controller
public class CollectionController {
@RequestMapping(value = "/collect/{str}", method = {RequestMethod.GET})
public String testPost(@PathVariable("str") String array1, HttpServletRequest req, HttpSession session,Model model) throws IOException, SQLException, ClassNotFoundException {
    String[] array = array1.split(",");
//    String[] array = req.getParameterValues("array[]");
    boolean checkcollect = false;
    CollectDao collectDao = new CollectDao();
    ArrayList<Movie> list = new ArrayList<>();
    for (String str : array) {
        System.out.println(str);
        if (str.contains("1")) {
            Movie movie = new Movie("1", "Black Panther", "Romance");
            list.add(movie);
        }
        if (str.contains("2")) {
            Movie movie = new Movie("2", "Ce Of Entro", "Romance");
            list.add(movie);
        }
        if (str.contains("3")) {
            Movie movie = new Movie("3", "Coming Soon", "Romance");
            list.add(movie);
        }
        if (str.contains("4")) {
            Movie movie = new Movie("4", "Handmaiden", "Romance");
            list.add(movie);
        }
        if (str.contains("5")) {
            Movie movie = new Movie("5", "The Silence of The Lamps", "Romance");
            list.add(movie);
        }
        if (str.contains("6")) {
            Movie movie = new Movie("6", "Monospaced", "Romance");
            list.add(movie);
        }
        if (str.contains("7")) {
            Movie movie = new Movie("7", "Secret Michael's Staff", "Romance");
            list.add(movie);
        }
        if (str.contains("8")) {
            Movie movie = new Movie("8", "Trolls: World Tour", "Romance");
            list.add(movie);
        }
        if (str.contains("9")) {
            Movie movie = new Movie("9", "Thrill Crazy", "Romance");
            list.add(movie);
        }
    }


    session.setAttribute("collection",list);
    model.addAttribute("collection",list);
    System.out.println(list.toString());
    checkcollect=collectDao.CollectData(list);
    if (checkcollect == false){
        return "index";
    }else {
        return "display";
    }
}

    @RequestMapping(value = "/deletecollect/{str}", method = {RequestMethod.GET})
    public String deletemovies(@PathVariable("str") String array2, HttpServletRequest req,HttpSession session, Model model) throws IOException, SQLException, ClassNotFoundException {
        String[] array = array2.split(",");
//    String[] array = req.getParameterValues("array[]");
        boolean checkcollect = false;
        CollectDao collectDao = new CollectDao();
        ArrayList<Movie> list = new ArrayList<>();
        for (String str : array) {
            System.out.println(str);
            if (str.contains("1")) {
                Movie movie = new Movie("1", "Black Panther", "Romance");
                list.add(movie);
            }
            if (str.contains("2")) {
                Movie movie = new Movie("2", "Ce Of Entro", "Romance");
                list.add(movie);
            }
            if (str.contains("3")) {
                Movie movie = new Movie("3", "Coming Soon", "Romance");
                list.add(movie);
            }
            if (str.contains("4")) {
                Movie movie = new Movie("4", "Handmaiden", "Romance");
                list.add(movie);
            }
            if (str.contains("5")) {
                Movie movie = new Movie("5", "The Silence of The Lamps", "Romance");
                list.add(movie);
            }
            if (str.contains("6")) {
                Movie movie = new Movie("6", "Monospaced", "Romance");
                list.add(movie);
            }
            if (str.contains("7")) {
                Movie movie = new Movie("7", "Secret Michael's Staff", "Romance");
                list.add(movie);
            }
            if (str.contains("8")) {
                Movie movie = new Movie("8", "Trolls: World Tour", "Romance");
                list.add(movie);
            }
            if (str.contains("9")) {
                Movie movie = new Movie("9", "Thrill Crazy", "Romance");
                list.add(movie);
            }
        }


//        session.setAttribute("deletecollection",list);
//        model.addAttribute("deletecollection",list);
        System.out.println(list.toString());
        checkcollect=collectDao.DeleteData(list);
        if (checkcollect == false){
            return "index";
        }else {
            return "collection";
        }
    }
}
