package project.service;

import project.last.Route;
import project.clasess.Price;

import java.util.List;

public interface ServiceRoute <T> extends Service <T>{
    public List<T> getRouteByEndStart(Integer start, Integer end);
    public List<Price> listOfRoute(List <Route> route, double mass);
}
