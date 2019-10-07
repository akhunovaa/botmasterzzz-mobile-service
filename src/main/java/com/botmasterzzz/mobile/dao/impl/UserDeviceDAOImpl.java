package com.botmasterzzz.mobile.dao.impl;

import com.botmasterzzz.mobile.dao.UserDeviceDAO;
import com.botmasterzzz.mobile.entity.UserDeviceEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDeviceDAOImpl implements UserDeviceDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void userDeviceAdd(UserDeviceEntity userDeviceEntity) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(userDeviceEntity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    @SuppressWarnings({"deprecation", "unchecked"})
    public List<UserDeviceEntity> getUserDeviceList() {
        List<UserDeviceEntity> userDeviceEntityList;
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(UserDeviceEntity.class);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        userDeviceEntityList = criteria.list();
        session.close();
        return userDeviceEntityList;
    }

    @Override
    @SuppressWarnings({"deprecation", "unchecked"})
    public List<UserDeviceEntity> getUserDeviceList(long userId) {
        List<UserDeviceEntity> userDeviceEntityList;
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(UserDeviceEntity.class);
        criteria.add(Restrictions.eq("userEntity.id", userId));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        userDeviceEntityList = criteria.list();
        session.close();
        return userDeviceEntityList;
    }

    @Override
    public void userDeviceDelete(long userId) {
        List<UserDeviceEntity> userDeviceEntityList = getUserDeviceList(userId);
        for (UserDeviceEntity userDeviceEntity : userDeviceEntityList) {
            userDeviceDelete(userDeviceEntity);
        }
    }

    @Override
    public void userDeviceDelete(UserDeviceEntity userDevice) {
        Session session = sessionFactory.openSession();
        Transaction updateTransaction = session.beginTransaction();
        session.delete(userDevice);
        updateTransaction.commit();
        session.close();
    }

    @Override
    public void userDeviceUpdate(UserDeviceEntity userDevice) {
        Session session = sessionFactory.openSession();
        Transaction updateTransaction = session.beginTransaction();
        session.update(userDevice);
        updateTransaction.commit();
        session.close();
    }
}
