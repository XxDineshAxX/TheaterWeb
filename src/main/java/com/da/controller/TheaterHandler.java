package com.da.controller;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.da.dao.TheaterDAO;
import com.da.theater.RegScreen;
import com.da.theater.XDScreen;

@Controller
public class TheaterHandler {

	@RequestMapping("/create")
	public synchronized ModelAndView createTheater(
			@RequestParam("tName") String tName,
			@RequestParam("numOfScreens") int numOfScreens,
			@RequestParam("address") String address,
			@RequestParam("tId") String tId,
			@RequestParam("numOfRows") int numOfRows,
			@RequestParam("numOfSeatsPerRow") int numOfSeatsPerRow)
			throws ClassNotFoundException, SQLException {
		ModelAndView ms = new ModelAndView();
		TheaterDAO td = new TheaterDAO();
		int total = numOfRows * numOfSeatsPerRow;
		td.addTheater(tName, address, tId, numOfScreens);
		
		for (int i = 0; i < numOfScreens; i++)
		{
			td.addScreen(i+1, tId, "xd", numOfRows, numOfSeatsPerRow, total);
			// Add tickets for each row and seat
			for(int x = 0; x < numOfRows; x++){
				char rowId = (char) ('A' + x);
				for(int y = 0; y < numOfSeatsPerRow; y ++){
					td.addTicket(i+1, rowId, y+1);
				}
			}
			
			
		}

		ms.setViewName("theaterMade");
		ms.addObject("tName", tName);
		ms.addObject("numOfScreens", numOfScreens);
		ms.addObject("address", address);
		ms.addObject("tID", tId);
		ms.addObject("numOfRows", numOfRows);
		ms.addObject("numOfSeatsPerRow", numOfSeatsPerRow);
		ms.addObject("total", total);
		return ms;

	}

	@RequestMapping("/goToCreation")
	public String goToCreation() {
		String t = "theaterCreator";
		return t;

	}
	
	@RequestMapping("/home")
	public String home(){
		String home = "home";
		return home;
		
	}
	
	@RequestMapping("/reserveScreen")
	public String rs(){
		String rs = "reserveScreen";
		return rs;
		
	}
	
	@RequestMapping("/reserve")
	public ModelAndView reserve(@RequestParam("screenID") int screenId) throws ClassNotFoundException, SQLException {
		ModelAndView mv = new ModelAndView("reserve");
		TheaterDAO tDao = new TheaterDAO();
		mv.addObject("seatsList",tDao.getSeatsList(screenId));
		mv.addObject("screenID", screenId);
		return mv;

	}
	
	@RequestMapping("/cancelScreen")
	public String cs(){
		String cs = "cancelScreen";
		return cs;
		
	}
	
	@RequestMapping("/cancel")
	public ModelAndView cancel(@RequestParam("screenID") int screenId) throws ClassNotFoundException, SQLException {
		ModelAndView mv = new ModelAndView("cancel");
		TheaterDAO tDao = new TheaterDAO();
		mv.addObject("seatsList",tDao.getSeatsList(screenId));
		return mv;

	}
	
	
	
	

}
