package com.zemoga.zemogatest.controller;

import com.zemoga.zemogatest.converter.PortfolioConverter;
import com.zemoga.zemogatest.dto.PortfolioDto;
import com.zemoga.zemogatest.entity.PortfolioDao;
import com.zemoga.zemogatest.repository.PortfolioRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    public PortfolioDto getPortfolio(@PathVariable("idPortfolio") Integer idPortfolio){
        LOGGER.info("Calling /user_info with idPortfolio [{}]", idPortfolio);
        PortfolioDao portfolioDao = portfolioRepository.findById(idPortfolio);
        return portfolioConverter.convertToDto(portfolioDao);
    }

    @PutMapping(value = "/modify_user_info")
    public PortfolioDto addPortfolio(@RequestBody PortfolioDto portfolioDto){
        LOGGER.info("Calling /modify_user_info with PortfolioDto [{}]", portfolioDto);
        PortfolioDao portfolioDao = portfolioConverter.convertToDao(portfolioDto);
        PortfolioDao response = portfolioRepository.save(portfolioDao);
        return portfolioConverter.convertToDto(response);
    }

}
