package com.zemoga.zemogatest.controller;

import com.zemoga.zemogatest.dto.PortfolioDto;
import com.zemoga.zemogatest.service.PortfolioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PortFolioWebController {

    private PortfolioService portfolioService;

    public PortFolioWebController(PortfolioService portfolioService){
        this.portfolioService = portfolioService;
    }

    @GetMapping("/show/portfolio/{idPortfolio}")
    public String showPortfolio(@PathVariable("idPortfolio") Integer idPortfolio, Model model){
        PortfolioDto portfolioDto = portfolioService.getPortfolioById(idPortfolio);
        model.addAttribute("portfolioDto", portfolioDto);
        return "show-user";
    }
}
