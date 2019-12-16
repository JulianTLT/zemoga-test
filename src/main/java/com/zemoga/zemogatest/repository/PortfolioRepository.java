package com.zemoga.zemogatest.repository;

import com.zemoga.zemogatest.entity.PortfolioDao;

public interface PortfolioRepository {
    PortfolioDao findById(Integer id);
    PortfolioDao save(PortfolioDao portfolioDao);
}
