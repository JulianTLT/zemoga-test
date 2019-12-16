package com.zemoga.zemogatest;

import com.zemoga.zemogatest.dto.PortfolioDto;
import com.zemoga.zemogatest.entity.PortfolioDao;
import twitter4j.Status;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static PortfolioDto createPortfolioDto(){
        PortfolioDto portfolioDto = new PortfolioDto();
        portfolioDto.setTitle("Julian Sanchez");
        portfolioDto.setTwitterUserName("jsanhcez");
        portfolioDto.setImageUrl("http://testurl.com");
        portfolioDto.setDescription("Software developer");
        return portfolioDto;
    }

    public static PortfolioDao createPortfolioDao(){
        PortfolioDao portfolioDao = new PortfolioDao();
        portfolioDao.setTitle("Julian Sanchez");
        portfolioDao.setTwitterUserName("jsanhcez");
        portfolioDao.setImageUrl("http://testurl.com");
        portfolioDao.setDescription("Software developer");
        return  portfolioDao;
    }

}
