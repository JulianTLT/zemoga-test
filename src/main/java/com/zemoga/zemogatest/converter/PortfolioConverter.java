package com.zemoga.zemogatest.converter;

import com.zemoga.zemogatest.dto.PortfolioDto;
import com.zemoga.zemogatest.entity.PortfolioDao;

public interface PortfolioConverter {
    PortfolioDto convertToDto(PortfolioDao portfolioDao);
    PortfolioDao convertToDao(PortfolioDto portfolioDto);
}
