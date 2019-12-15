package com.zemoga.zemogatest.repository.impl;

import com.zemoga.zemogatest.entity.PortfolioDao;
import com.zemoga.zemogatest.repository.PortfolioRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class PortfolioRepositoryImpl implements PortfolioRepository {

    private SessionFactory sessionFactory;
    private static final Logger LOGGER = LogManager.getLogger(PortfolioRepositoryImpl.class);

    private static final String ID_PORTFOLIO_ATTRIBUTE = "idportfolio";
    private static final String TITLE_ATTRIBUTE = "title";

    public PortfolioRepositoryImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    @Override
    public PortfolioDao findById(Integer id) {
        return findOneByAttribute(ID_PORTFOLIO_ATTRIBUTE, id.toString());
    }

    private PortfolioDao findByTitle(String title){
        return findOneByAttribute(TITLE_ATTRIBUTE, title);
    }

    @Transactional(readOnly = true)
    public PortfolioDao findOneByAttribute( String attribute, String value) {

        StringBuilder stringQuery = new StringBuilder();
        stringQuery.append("from PortfolioDao where ")
                .append(attribute)
                .append(" = :parameter");
        LOGGER.info("The query which is going to be executed is [{}]", stringQuery.toString());
        Query<PortfolioDao> query = sessionFactory
                .getCurrentSession()
                .createQuery(stringQuery.toString(), PortfolioDao.class)
                .setParameter("parameter", value);
        return query.uniqueResult();
    }

    public PortfolioDao save(PortfolioDao portfolioDao) {

        PortfolioDao entity = findByTitle(portfolioDao.getTitle());
        PortfolioDao response;
        if(entity == null){
            sessionFactory.getCurrentSession().saveOrUpdate(portfolioDao);
            LOGGER.info("Portfolio [{}] saved!",portfolioDao );
            response = portfolioDao;
        }else{
            LOGGER.info("Found an entity with title [{}], updating entity with id [{}]",
                    entity.getTitle(), entity.getIdPortfolio() );
            copyValues(portfolioDao, entity);
            sessionFactory.getCurrentSession().saveOrUpdate(entity);
            LOGGER.info("Portfolio [{}] saved!",entity );
            response = entity;
        }

        return response;
    }
     private void copyValues(PortfolioDao origin, PortfolioDao destination){
        LOGGER.info("Copping Origin DAO [{}] to Destination [{}]", origin, destination);
        destination.setDescription(origin.getDescription());
        destination.setImageUrl(origin.getImageUrl());
        destination.setTitle(origin.getTitle());
        destination.setTwitterUserName(origin.getTwitterUserName());
        LOGGER.info("Final object [{}]", destination);
     }
}
