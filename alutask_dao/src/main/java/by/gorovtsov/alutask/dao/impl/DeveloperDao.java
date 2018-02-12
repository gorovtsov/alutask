package by.gorovtsov.alutask.dao.impl;

import by.gorovtsov.alutask.dao.BaseDao;
import by.gorovtsov.alutask.entity.user.Developer;
import by.gorovtsov.alutask.entity.user.QDeveloper;
import by.gorovtsov.alutask.enumeration.DeveloperLevel;
import by.gorovtsov.alutask.enumeration.ProgrammingLanguage;
import com.querydsl.jpa.impl.JPAQuery;
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

    public Map<Long, List<Developer>> getDevelopersPortion(int elemsOnPage, int pageNum, ProgrammingLanguage langToFilter, DeveloperLevel devLevelToFilter){
        Session session = SESSION_FACTORY.openSession();

        DeveloperLevel level = null;
        List<Developer> developers;
        JPAQuery<Developer> query = new JPAQuery<>(session);
        QDeveloper developer = QDeveloper.developer;
        query.select(developer)
                .from(developer);
        if (langToFilter != null){
            query.where(developer.language.eq(langToFilter));
        }

        if (devLevelToFilter != null){
            query.where(developer.level.eq(devLevelToFilter));
        }

        Map<Long, List<Developer>> result = new HashMap<>();
        int start = pageNum * elemsOnPage  - elemsOnPage;

        developers = query.fetchResults().getResults();

        Long resultCount = Long.valueOf(developers.size());

        result.put(resultCount, developers);
        return  result;
    }
}
