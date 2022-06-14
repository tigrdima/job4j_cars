package ru.job4j.store;

import org.hibernate.SessionFactory;
import ru.job4j.model.Announcement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AnnouncementStore implements Store {
    private final SessionFactory sf;

    public AnnouncementStore(SessionFactory sf) {
        this.sf = sf;
    }

    public List<Announcement> findAllLastDay() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateNow = formatter.format(new Date());

        return sessionApply(s -> s
                .createQuery("select distinct a from Announcement a join fetch a.user "
                        + "join fetch a.car where a.created >= :aCreated")
                .setParameter("aCreated", dateNow)
                .list(), sf);
    }

    public List<Announcement> findAllContainsPhoto() {
        return sessionApply(s -> s
                .createQuery("select distinct a from Announcement a join fetch a.user "
                        + "join fetch a.car c where c.photo.size > :cPhoto")
                .setParameter("cPhoto", 0)
                .list(), sf);
    }

    public List<Announcement> findAllContainsMark(String mark) {
        return sessionApply(s -> s
                .createQuery("select distinct a from Announcement a join fetch a.user "
                        + "join fetch a.car c where c.name = :cName")
                .setParameter("cName", mark)
                .list(), sf);
    }
}
