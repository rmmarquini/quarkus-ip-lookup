package com.rmmarquini.iplookup.microservice.repository;

import com.rmmarquini.iplookup.microservice.entity.UserStats;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import org.bson.types.ObjectId;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

/**
 * @author Rafael Marquini
 *         hello@rmmarquini.dev
 *         --
 */
@ApplicationScoped
public class UserStatsRepository implements PanacheMongoRepository<UserStats> {

    @Inject
    Logger logger;

    public UserStats createUserStats(HttpServletRequest request) {

        UserStats userStats = new UserStats();

        userStats.set_id(new ObjectId());
        userStats.setIpAddress(request.getRemoteAddr());
        userStats.setUserAgent(request.getHeader("User-Agent"));

        Iterator<Locale> locales = request.getLocales().asIterator();
        while (locales.hasNext()) {
            Locale locale = locales.next();
            userStats.setDisplayLanguage(locale.getDisplayLanguage());
            userStats.setLanguage(locale.getLanguage() + "-" + locale.getCountry());
        }

        userStats.setRequestURL(request.getRequestURL().toString());
        userStats.setMethod(request.getMethod());
        userStats.setRequestedAt(new Date());

        userStats.persist();

        return userStats;

    }

}
