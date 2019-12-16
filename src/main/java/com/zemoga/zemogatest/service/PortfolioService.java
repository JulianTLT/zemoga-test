package com.zemoga.zemogatest.service;

import com.zemoga.zemogatest.dto.PortfolioDto;

public interface PortfolioService {
    PortfolioDto getPortfolioById(Integer idPortfolio);
    PortfolioDto addPortfolio (PortfolioDto portfolioDto);
}
