package com.zemoga.zemogatest.controller;

import com.zemoga.zemogatest.converter.PortfolioConverter;
import com.zemoga.zemogatest.dto.PortfolioDto;
import com.zemoga.zemogatest.entity.PortfolioDao;
import com.zemoga.zemogatest.repository.PortfolioRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/zemoga_portfolio_api")
public class PortfolioController {

    private PortfolioRepository portfolioRepository;
    private PortfolioConverter portfolioConverter;
    private static final Logger LOGGER = LogManager.getLogger(PortfolioController.class);

    public PortfolioController(PortfolioRepository portfolioRepository, PortfolioConverter portfolioConverter) {
        this.portfolioRepository = portfolioRepository;
        this.portfolioConverter = portfolioConverter;
    }

    @GetMapping(value = "/user_info/{idPortfolio}")
    public ResponseEntity getPortfolio(@PathVariable("idPortfolio") Integer idPortfolio){
        ResponseEntity response;
        try {
            LOGGER.info("Calling /user_info with idPortfolio [{}]", idPortfolio);
            PortfolioDao portfolioDao = portfolioRepository.findById(idPortfolio);
            if(portfolioDao == null) {
                response = new ResponseEntity("Theres no Portfolio with id "+ idPortfolio, HttpStatus.BAD_REQUEST);
            } else {
                PortfolioDto portfolioDto = portfolioConverter.convertToDto(portfolioDao);
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
            PortfolioDao portfolioDao = portfolioConverter.convertToDao(portfolioDto);
            PortfolioDao portfolioDaoResponse = portfolioRepository.save(portfolioDao);
            PortfolioDto convertedDto = portfolioConverter.convertToDto(portfolioDaoResponse);
            response = new ResponseEntity(convertedDto, HttpStatus.OK);
        }catch (Exception e){
            LOGGER.error("There was an exception calling PortfolioController#getPortfolio ",e);
            response = new ResponseEntity("Could not porcess your request", HttpStatus.BAD_REQUEST);
        }
        return response;
    }

}
