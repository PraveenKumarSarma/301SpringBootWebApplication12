package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IplController
{
	@RequestMapping("/")
	public String matchForm()
	{
		return "match";
	}
	
	@RequestMapping("/req1")
	public String resultInfo(@RequestParam int pos,@RequestParam String teamName,@RequestParam int played,@RequestParam int win,@RequestParam int lost,@RequestParam int winnerRuns,@RequestParam int loserRuns,@RequestParam double winOvers,@RequestParam double lostOvers,ModelMap model)
	{
		model.put("pos", pos);
		model.put("teamName",teamName);
		model.put("played", played);
		model.put("win", win);
		model.put("lost", lost);
		model.put("winnerRuns", winnerRuns);
		model.put("loserRuns", loserRuns);
		model.put("winOvers", winOvers);
		model.put("lostOvers", lostOvers);
		
		int nr=0; //nr means tie
		nr=played-(win+lost);
		
		model.put("nr", nr);
		
		double runsfor=0.0,runsagainst=0.0;
		runsfor=winnerRuns/winOvers;
		runsagainst=loserRuns/lostOvers;

		String rf=winnerRuns+"/"+winOvers;
		String ra=loserRuns+"/"+lostOvers;
		double nrr=0.0;
		nrr=runsfor-runsagainst;
		model.put("nrr", nrr);
		model.put("rf", rf);
		model.put("ra", ra);
		
		
		int pts=0;
		pts=(win*2)+(lost*0)+(nr*1);
		model.put("pts", pts);
		return "result";
	}
}
