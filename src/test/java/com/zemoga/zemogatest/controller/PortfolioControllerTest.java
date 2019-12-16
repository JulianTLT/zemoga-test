package com.zemoga.zemogatest.controller;

import com.zemoga.zemogatest.dto.PortfolioDto;
import com.zemoga.zemogatest.service.PortfolioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static com.zemoga.zemogatest.Utils.createPortfolioDto;
import static org.junit.jupiter.api.Assertions.*;

class PortfolioControllerTest {
    private PortfolioService portfolioService;
    private PortfolioController portfolioController;

    @BeforeEach
    public void setUp(){
        portfolioService = Mockito.mock(PortfolioService.class);
        portfolioController = new PortfolioController(portfolioService);
    }

    @Test
    public void getPortfolioShouldReturnOkStatus(){
        Integer idToSearch = 1;
        PortfolioDto portfolioDto = createPortfolioDto();
        Mockito.when(portfolioService.getPortfolioById(idToSearch)).thenReturn(portfolioDto);

        ResponseEntity responseEntity = portfolioController.getPortfolio(idToSearch);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(portfolioDto, responseEntity.getBody());
    }

    @Test
    public void getPortfolioShouldReturnBadRequestWithNotValidId(){
        Integer idToSearch = 1;
        Mockito.when(portfolioService.getPortfolioById(idToSearch)).thenReturn(null);

        ResponseEntity responseEntity = portfolioController.getPortfolio(idToSearch);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Theres no Portfolio with id "+ idToSearch, responseEntity.getBody());
    }

    @Test
    public void getPortfolioShouldReturnBadRequestWithException(){
        Integer idToSearch = 1;
        Mockito.when(portfolioService.getPortfolioById(idToSearch)).thenThrow(new RuntimeException("Runtime Exception"));

        ResponseEntity responseEntity = portfolioController.getPortfolio(idToSearch);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Could not porcess your request", responseEntity.getBody());
    }

    @Test
    public void addPortfolioShouldReturnOkStatus() {
        PortfolioDto portfolioDto = createPortfolioDto();
        Mockito.when(portfolioService.addPortfolio(portfolioDto)).thenReturn(portfolioDto);
        ResponseEntity responseEntity = portfolioController.addPortfolio(portfolioDto);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(portfolioDto, responseEntity.getBody());
    }

    @Test
    public void addPortfolioShouldReturnBadRequest(){
        PortfolioDto portfolioDto = createPortfolioDto();
        Mockito.when(portfolioService.addPortfolio(portfolioDto)).thenThrow(new RuntimeException("Runtime Exception"));

        ResponseEntity responseEntity = portfolioController.addPortfolio(portfolioDto);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Could not porcess your request", responseEntity.getBody());
    }
}