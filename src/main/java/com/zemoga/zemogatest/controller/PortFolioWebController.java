package com.zemoga.zemogatest.controller;

import com.zemoga.zemogatest.dto.PortfolioDto;
import com.zemoga.zemogatest.service.PortfolioService;
import com.zemoga.zemogatest.service.TwitterService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class PortFolioWebController {

    private PortfolioService portfolioService;
    private TwitterService twitterService;

    private static final Logger LOGGER = LogManager.getLogger(PortFolioWebController.class);

    public PortFolioWebController(PortfolioService portfolioService, TwitterService twitterService){
        this.portfolioService = portfolioService;
        this.twitterService = twitterService;
    }

    @GetMapping("/show/portfolio/{idPortfolio}")
    public String showPortfolio(@PathVariable("idPortfolio") Integer idPortfolio, Model model){
        PortfolioDto portfolioDto = portfolioService.getPortfolioById(idPortfolio);
        List<String> tweets = null;
        if(portfolioDto.getTwitterUserName() !=null ) {
            tweets = twitterService.getTopFiveTweets(portfolioDto.getTwitterUserName());
        }
        model.addAttribute("portfolioDto", portfolioDto);
        model.addAttribute("tweets", tweets);
        LOGGER.info("Attributes added to model [{}], [{}]", portfolioDto, tweets);
        return "show-user";
    }
}
