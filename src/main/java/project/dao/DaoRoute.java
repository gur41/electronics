package project.dao;

import last.Route;

import java.util.List;

public interface DaoRoute <T> extends Dao <T> {
    public List<T> getRouteByEndStart(Integer start, Integer end);
}
