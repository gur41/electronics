package project.dao;

import last.Route;

public interface DaoRoute <T> extends Dao <T> {
    public T getRouteByEndStart(Integer start, Integer end);
}
