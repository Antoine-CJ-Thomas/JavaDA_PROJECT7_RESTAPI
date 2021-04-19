package com.nnk.springboot.controller;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.service.RatingService;
import com.nnk.springboot.service.RatingServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class RatingController {
    // TODO: Inject Rating service
	
	@Autowired
	private RatingServiceInterface ratingServiceInterface;
	
	public RatingController() {
		
		ratingServiceInterface = new RatingService();
	}

    @RequestMapping("/rating/list")
    public String home(Model model) {
        // TODO: find all Rating, add to model
    	
    	model.addAttribute("ratingList", ratingServiceInterface.readRatingList());
    	
        return "rating/list";
    }

    @GetMapping("/rating/add")
    public String addRatingForm(Rating rating) {
    	
        return "rating/add";
    }

    @PostMapping("/rating/validate")
    public String validate(@Valid Rating rating, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return Rating list
    	
    	ratingServiceInterface.createRating(rating);
    	
        return "rating/add";
    }

    @GetMapping("/rating/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get Rating by Id and to model then show to the form

    	model.addAttribute("rating", ratingServiceInterface.readRating(id));
    	
        return "rating/update";
    }

    @PostMapping("/rating/update/{id}")
    public String updateRating(@PathVariable("id") Integer id, @Valid Rating rating, BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update Rating and return Rating list
    	
    	ratingServiceInterface.updateRating(id, rating);
    	
        return "redirect:/rating/list";
    }

    @GetMapping("/rating/delete/{id}")
    public String deleteRating(@PathVariable("id") Integer id, Model model) {
        // TODO: Find Rating by Id and delete the Rating, return to Rating list
    	
    	ratingServiceInterface.deleteRating(id);
    	
        return "redirect:/rating/list";
    }
}
