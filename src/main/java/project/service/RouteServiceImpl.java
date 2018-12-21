package project.service;

import com.sun.org.apache.xerces.internal.xs.LSInputList;
import last.Maps;
import last.Transport;
import org.springframework.transaction.annotation.Transactional;
import project.clasess.MapsCarrier;
import project.clasess.Price;
import project.dao.Dao;
import last.Route;
import project.dao.DaoRoute;


import java.util.ArrayList;
import java.util.List;

public class RouteServiceImpl implements ServiceRoute<Route> {
    private DaoRoute<Route> routeDao;
    private Dao <Maps> mapsDao;
    private Dao <Transport> transportDao;



    public void setRouteDao(DaoRoute routeDao) {
        this.routeDao = routeDao;
    }



    @Override
    @Transactional
    public void add(Route route) {
        this.routeDao.add(route);
    }


    @Override
    @Transactional
    public void update(Route route) {

    }

    @Override
    @Transactional
    public void remove(int id) {

    }

    @Override
    @Transactional
    public Route getById(int id) {
        return null;
    }

    @Override
    @Transactional
    public boolean getByLogin(String login) {
        return false;
    }

    @Override
    public Route getByLoginP(String login) {
        return this.routeDao.getByLoginP(login);
    }

    @Override
    @Transactional
    public List<Route> list() {
        return this.routeDao.list();
    }

    @Override
    @Transactional
    public List<Route> find(String name) {
        return null;
    }

    @Override
    public List<Route> getRouteByEndStart(Integer start, Integer end) {
        return this.routeDao.getRouteByEndStart(start, end);
    }

    @Override
    public List<Price> listOfRoute(List<Route> route, double mass) {
        List <Price> prices = new ArrayList<Price>();
        System.out.println(route.size());
        List <Maps> mapsList = new ArrayList<Maps>();
        List <Transport> transportList = new ArrayList<Transport>();
        ArrayList <Double> doubles = new ArrayList<Double>();
        Double price;
        mapsList = mapsDao.list();
        transportList = transportDao.list();
        System.out.println("list of maps " +mapsList.size());
        for (Route r: route) {
            price = 0.0;
            String desc = "";
            int id = r.getIdRoute();
            for (Maps m: mapsList) {
                if(m.getRoute() == id){
                    for (Transport t:transportList) {
                        if(m.getIdTransportInMaps()==t.getIdTransport()) {
                            Double k = Math.ceil(mass / t.getMaxWeight());
                            price = price + m.getDistance() / t.getSpeed() * t.getCoefficient() * m.getCostForHour() * k;
                            System.out.println("price = " + price);
                            System.out.println("transport");
                            if (t.getTransportName().equals("Автомобильный")) {
                                desc = desc + "Авто : "+k.intValue()+" ";
                            }
                            if (t.getTransportName().equals("Морской")) {
                                desc = desc + "Контейнеров : "+k.intValue()+" ";
                            }
                            if (t.getTransportName().equals("Воздушный")) {
                                desc = desc + "Самолетов : "+k.intValue()+" ";
                            }
                            if (t.getTransportName().equals("Железнодорожный")) {
                                desc = desc + "Вагонов : "+k.intValue()+" ";
                            }
                            System.out.println("desc"+desc);
                        }
                    }
                }
            }
            prices.add(new Price(r.getIdRoute(), (double)Math.round(price*100)/100, r.getNameOfRoute(),desc));
        }
        System.out.println("size price "+prices.size());
        return prices;
    }

    public void setMapsDao(Dao<Maps> mapsDao) {
        this.mapsDao = mapsDao;
    }

    public void setTransportDao(Dao<Transport> transportDao) {
        this.transportDao = transportDao;
    }
}
