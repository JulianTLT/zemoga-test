package com.zemoga.zemogatest.service.impl;

import com.zemoga.zemogatest.converter.PortfolioConverter;
import com.zemoga.zemogatest.converter.impl.PortfolioConverterImpl;
import com.zemoga.zemogatest.dto.PortfolioDto;
import com.zemoga.zemogatest.entity.PortfolioDao;
import com.zemoga.zemogatest.repository.PortfolioRepository;
import com.zemoga.zemogatest.service.PortfolioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static com.zemoga.zemogatest.Utils.*;

class PortfolioServiceImplTest {
    private PortfolioRepository portfolioRepository;
    private PortfolioConverter portfolioConverter;
    private PortfolioService portfolioService;

    @BeforeEach
    public void setUp(){
        portfolioRepository = Mockito.mock(PortfolioRepository.class);
        portfolioConverter = new PortfolioConverterImpl();
        portfolioService = new PortfolioServiceImpl(portfolioRepository, portfolioConverter);
    }

    @Test
    public void getPortfolioByIdShouldReturnAPortfolioDtoObject(){
        Integer idToSearch = 1;
        PortfolioDto portfolioDto = createPortfolioDto();
        PortfolioDao portfolioDao = createPortfolioDao();
        Mockito.when(portfolioRepository.findById(idToSearch)).thenReturn(portfolioDao);

        PortfolioDto resultDto = portfolioService.getPortfolioById(idToSearch);

        assertEquals(portfolioDto.getTwitterUserName(), resultDto.getTwitterUserName());
        assertEquals(portfolioDto.getDescription(), resultDto.getDescription());
        assertEquals(portfolioDto.getImageUrl(), resultDto.getImageUrl());
        assertEquals(portfolioDto.getTitle(), resultDto.getTitle());
    }

    @Test
    public void getPortfolioByIdShouldReturnNull(){
        Integer idToSearch = 1;
        Mockito.when(portfolioRepository.findById(idToSearch)).thenReturn(null);

        PortfolioDto resultDto = portfolioService.getPortfolioById(idToSearch);
        assertNull(resultDto);
    }

    @Test
    public void addPortfolioShouldReturnDto(){
        PortfolioDto portfolioDto = createPortfolioDto();
        PortfolioDao portfolioDao = createPortfolioDao();

        Mockito.when(portfolioRepository.save(Mockito.any())).thenReturn(portfolioDao);
        PortfolioDto resultDto = portfolioService.addPortfolio(portfolioDto);

        assertEquals(portfolioDto.getTwitterUserName(), resultDto.getTwitterUserName());
        assertEquals(portfolioDto.getDescription(), resultDto.getDescription());
        assertEquals(portfolioDto.getImageUrl(), resultDto.getImageUrl());
        assertEquals(portfolioDto.getTitle(), resultDto.getTitle());
    }

}