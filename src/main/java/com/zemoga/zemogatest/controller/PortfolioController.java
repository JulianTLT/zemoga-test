package com.zemoga.zemogatest.controller;

import com.zemoga.zemogatest.dto.PortfolioDto;
import com.zemoga.zemogatest.service.PortfolioService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/zemoga_portfolio_api")
public class PortfolioController {
    private PortfolioService portfolioService;

    private static final Logger LOGGER = LogManager.getLogger(PortfolioController.class);

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @GetMapping(value = "/user_info/{idPortfolio}")
    public ResponseEntity getPortfolio(@PathVariable("idPortfolio") Integer idPortfolio){
        ResponseEntity response;
        try {
            LOGGER.info("Calling /user_info with idPortfolio [{}]", idPortfolio);
            PortfolioDto portfolioDto = portfolioService.getPortfolioById(idPortfolio);
            if(portfolioDto == null) {
                response = new ResponseEntity("Theres no Portfolio with id "+ idPortfolio, HttpStatus.BAD_REQUEST);
            } else {
                response = new ResponseEntity(portfolioDto, HttpStatus.OK);
            }
        } catch (Exception e){
            LOGGER.error("There was an exception calling PortfolioController#getPortfolio ",e);
            response = new ResponseEntity("Could not porcess your request", HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @PutMapping(value = "/modify_user_info")
    public ResponseEntity addPortfolio(@RequestBody PortfolioDto portfolioDto){
        ResponseEntity response;
        try {
            LOGGER.info("Calling /modify_user_info with PortfolioDto [{}]", portfolioDto);
            PortfolioDto convertedDto = portfolioService.addPortfolio(portfolioDto);
            response = new ResponseEntity(convertedDto, HttpStatus.OK);
        }catch (Exception e){
            LOGGER.error("There was an exception calling PortfolioController#getPortfolio ",e);
            response = new ResponseEntity("Could not porcess your request", HttpStatus.BAD_REQUEST);
        }
        return response;
    }

}
