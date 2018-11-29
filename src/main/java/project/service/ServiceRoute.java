package project.service;

public interface ServiceRoute <T> extends Service <T> {
    public T getRouteByEndStart(Integer start, Integer end);
}
