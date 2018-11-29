package project.service;

import java.util.List;

public interface ServiceRoute <T> extends Service <T> {
    public List<T> getRouteByEndStart(Integer start, Integer end);
}
