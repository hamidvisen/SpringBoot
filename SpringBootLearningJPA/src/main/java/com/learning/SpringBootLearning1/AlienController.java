package com.learning.SpringBootLearning1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.learning.SpringBootLearning1.dao.AlienRepo;
import com.learning.SpringBootLearning1.model.Alien;


@Controller
public class AlienController {
	
	@Autowired
	AlienRepo repo;

	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
//	@RequestMapping("/addAlien")
//	public String addAlien(Alien alien) {
//		repo.save(alien);
//		return "home.jsp";
//	}
	
//	@RequestMapping("/getAlien")
//	public ModelAndView getAlien(@RequestParam int aid) {
//		ModelAndView mv = new ModelAndView("showAlien.jsp");
//		Alien alien = repo.findById(aid).orElse(new Alien());
//		System.out.println(repo.findByTech("java"));
//		System.out.println(repo.findByAidGreaterThan(aid))
//		mv.addObject(alien);	
//		
//		
//		return mv;
//	}
	
//	defaul return view page hota h spring m pr body ke data ko print karane k liye responsebody ko use krte h
	
//	@RequestMapping("/aliens")
//	@ResponseBody
//	public String getAlien() {
//		return repo.findAll().toString();
//		
//		
//	
//	}
//	
//	@RequestMapping("/aliens/{aid}")
//	@ResponseBody
//	public String getAlien(@PathVariable("aid") int aid) {
//		
//		return repo.findById(aid).toString();
//		
//		
//	
//	}
	
//	produces mtlb get krna data vs consumes mtlb data ko post krna 
	//mtlb post man kya produces krege and postman kya consume krega
	
//	@RequestMapping(path="/aliens", produces= {"application/xml"})
	@RequestMapping("/aliens")
//	@ResponseBody
	public List<Alien> getAlien() {
		Iterable<Alien> aliens = repo.findAll();
		List<Alien> alienList = StreamSupport.stream(aliens.spliterator(), false)
		                                     .collect(Collectors.toList());
		return alienList;
		
		
	
	}
	
//	Responsebody ko hr jagah n likhna pde uske liye hum controller ko rest controller likhte h jo json or xml data pr kaam krta h
	
	@RequestMapping("/aliens/{aid}")
//	@ResponseBody 
	public Optional<Alien> getAlien(@PathVariable("aid") int aid) {
		
		return repo.findById(aid);
		
		
	
	}
	
//	jb hum body ka raw data send krte h requestbody annotation k use krte h 
	
	@PostMapping(path="/addAlien", consumes= {"application/json"})
	public Alien addAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}

	@PostMapping(path="/alien", consumes= {"application/json"})
	public Alien saveOrUpdateAlien(@RequestBody Alien alien) {
		
		return repo.save(alien);
		
	}


	@DeleteMapping("/alien/{aid}")
public String deleteAlien(@PathVariable int aid) {
	
	Optional<Alien> a = repo.findById(aid);
	repo.delete(a.get());
	return "deleted..";
	}
}
