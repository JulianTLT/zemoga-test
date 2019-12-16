package com.zemoga.zemogatest.converter.impl;

import com.zemoga.zemogatest.converter.PortfolioConverter;
import com.zemoga.zemogatest.dto.PortfolioDto;
import com.zemoga.zemogatest.entity.PortfolioDao;
import org.springframework.stereotype.Component;

@Component
public class PortfolioConverterImpl implements PortfolioConverter {
    public PortfolioDto convertToDto(PortfolioDao portfolioDao){
        PortfolioDto portfolioDto = new PortfolioDto();
        portfolioDto.setIdPortFolio(portfolioDao.getIdPortfolio());
        portfolioDto.setImageUrl(portfolioDao.getImageUrl());
        portfolioDto.setTitle(portfolioDao.getTitle());
        portfolioDto.setDescription(portfolioDao.getDescription());
        portfolioDto.setTwitterUserName(portfolioDao.getTwitterUserName());
        return portfolioDto;
    }

    public PortfolioDao convertToDao(PortfolioDto portfolioDto){
        PortfolioDao portfolioDao = new PortfolioDao();
        portfolioDao.setImageUrl(portfolioDto.getImageUrl());
        portfolioDao.setTitle(portfolioDto.getTitle());
        portfolioDao.setDescription(portfolioDto.getDescription());
        portfolioDao.setTwitterUserName(portfolioDto.getTwitterUserName());
        return portfolioDao;
    }
}
