package com.zemoga.zemogatest.service.impl;

import com.zemoga.zemogatest.converter.PortfolioConverter;
import com.zemoga.zemogatest.dto.PortfolioDto;
import com.zemoga.zemogatest.entity.PortfolioDao;
import com.zemoga.zemogatest.repository.PortfolioRepository;
import com.zemoga.zemogatest.service.PortfolioService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class PortfolioServiceImpl implements PortfolioService {
    private PortfolioRepository portfolioRepository;
    private PortfolioConverter portfolioConverter;

    private static final Logger LOGGER = LogManager.getLogger(PortfolioServiceImpl.class);

    public PortfolioServiceImpl(PortfolioRepository portfolioRepository, PortfolioConverter portfolioConverter){
        this.portfolioRepository = portfolioRepository;
        this.portfolioConverter = portfolioConverter;
    }

    @Override
    public PortfolioDto getPortfolioById(Integer idPortfolio){
        LOGGER.info("Executing PortfolioServiceImpl#getPortfolioById with idPortfolio [{}]", idPortfolio);
        PortfolioDao portfolioDao = portfolioRepository.findById(idPortfolio);
        PortfolioDto portfolioDto = null;
        if(portfolioDao != null){
            portfolioDto = portfolioConverter.convertToDto(portfolioDao);
        }
        LOGGER.info("PortfolioDto result [{}]", portfolioDto);
        return portfolioDto;
    }

    @Override
    public PortfolioDto addPortfolio(PortfolioDto portfolioDto) {
        LOGGER.info("Executing PortfolioServiceImpl#addPortfolio with PortfolioDto [{}]", portfolioDto);
        PortfolioDao portfolioDao = portfolioConverter.convertToDao(portfolioDto);
        PortfolioDao portfolioDaoResponse = portfolioRepository.save(portfolioDao);
        PortfolioDto convertedDto = portfolioConverter.convertToDto(portfolioDaoResponse);
        LOGGER.info("PortfolioDto result [{}]", convertedDto);
        return convertedDto;
    }

}
