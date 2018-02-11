package by.gorovtsov.alutask.dao.impl;

import by.gorovtsov.alutask.dao.BaseDao;
import by.gorovtsov.alutask.entity.user.Developer;
import org.hibernate.Session;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeveloperDao extends BaseDao<Developer> {
    public List<Developer> findDeveloperByName(String name) {
        Session session = SESSION_FACTORY.openSession();
        List<Developer> result = session.createQuery("select d from Developer d where d.name = :devName", Developer.class)
                .setParameter("devName", name)
                .getResultList();
        session.close();
        return result;
    }

    public Map<Long, List<Developer>> getDevelopersPortion(int elemsOnPage, int pageNum){
        Session session = SESSION_FACTORY.openSession();

        Map<Long, List<Developer>> result = new HashMap<>();
        int start = pageNum * elemsOnPage  - elemsOnPage;


        List<Developer> developers = session.createQuery("select d from Developer d", Developer.class)
                .setFirstResult(start)
                .setMaxResults(elemsOnPage)
                .getResultList();

        Long resultCount = (Long) session.createQuery("select count(*) from Developer ").uniqueResult();

        result.put(resultCount, developers);
        return  result;
    }
}
