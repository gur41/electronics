package project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.clasess.MapsCarrier;
import project.clasess.RouteCarrier;
import project.clasess.RouteUser;
import last.Transport;
import last.Points;
import last.*;
import project.service.Service;
import project.service.ServiceRoute;
import project.service.ServiceTransport;
import project.service.TransportServiceImpl;



import java.util.ArrayList;
import java.util.List;


@Controller
public class PropertyController {
    //private Service propertyService;
    private Service pointsService;
    private ServiceRoute routeService;
    private Service transportService;
    private ServiceTransport transportserviceTransport;
    private RouteCarrier routeCarrier;
    private RouteUser routeUser;

    private Service mapsService;
    private int currentMaps;
    private List points =new ArrayList <Points>();
    private ArrayList<MapsCarrier> mapsCarriers = new ArrayList<MapsCarrier>();
    private ArrayList<Transport> transportArrayList = new ArrayList<Transport>();
    private ArrayList<Maps> mapsArrayList = new ArrayList<Maps>();
    private List<Route> routeArrayList = new ArrayList<Route>();



    public RouteUser getRouteUser() {
        return routeUser;
    }

    public void setRouteUser(RouteUser routeUser) {
        this.routeUser = routeUser;
    }


    @Autowired(required = true)
    @Qualifier(value = "pointsService")
    public void setPointsService(Service pointsService) {
        this.pointsService = pointsService;
    }


    @Autowired(required = true)
    @Qualifier(value = "routeService")
    public void setRouteService(ServiceRoute routeService) {
        this.routeService = routeService;
    }

    @Autowired(required = true)
    @Qualifier(value = "transportService")
    public void setTransportService(Service transportService) {
        this.transportService = transportService;
    }


    @Autowired(required = true)
    @Qualifier(value = "transportServiceTransport")
    public void setTransportserviceTransport(ServiceTransport transportserviceTransport) {
        this.transportserviceTransport = transportserviceTransport;
    }


    @Autowired(required = true)
    @Qualifier(value = "mapsService")
    public void setMapsService( Service mapsService) {
        this.mapsService = mapsService;
    }



    @RequestMapping(value = "/client/showClient", method = RequestMethod.POST)
    public String getListRoutes(@ModelAttribute("listRoutes") ArrayList<Route> routeArrayListGet){
        Integer start = ((Points)pointsService.getByLoginP(routeUser.getStart())).getIdPoint();
        Integer end = ((Points)pointsService.getByLoginP(routeUser.getEnd())).getIdPoint();
        this.routeArrayList = routeService.getRouteByEndStart(start,end);
        for (Route r:this.routeArrayList) {
            System.out.println(r.getNameOfRoute());
        }
        return "redirect:http://localhost:8080/show_routes";
    }

    @RequestMapping(value = "/carrier/showCarrier", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("routeCarrier") RouteCarrier routeCarrier){
        System.out.println(routeCarrier.getStart());
        System.out.println(routeCarrier.getEnd());
        this.routeCarrier=routeCarrier;
        this.currentMaps=0;
        if(!this.pointsService.getByLogin(routeCarrier.getStart())) {
            this.pointsService.add(new Points(routeCarrier.getStart()));

        }
        if(!this.pointsService.getByLogin(routeCarrier.getEnd())) {
            this.pointsService.add(new Points(routeCarrier.getEnd()));
        }
        this.points= pointsService.list();
        return "redirect:http://localhost:8080/add_AB";
    }

    @RequestMapping(value = "client", method = RequestMethod.GET)
    public String addClient(Model model){
        model.addAttribute("routeUser", this.routeUser = new RouteUser());
        return "AB_client";
    }

    @RequestMapping(value = "show_routes", method = RequestMethod.GET)
    public String showClientRoute(Model model){
        model.addAttribute("listRoutes", this.routeArrayList);
        return "show_routes";
    }

    @RequestMapping(value = "carrier", method = RequestMethod.GET)
    public String addCarrier(Model model){
        this.mapsCarriers.removeAll(this.mapsCarriers);
        model.addAttribute("routeCarrier", new RouteCarrier());
        return "AB_carrier";
    }

    @RequestMapping(value = "add_AB", method = RequestMethod.GET)
    public String addAb(Model model){
        model.addAttribute("routeCarrier", this.routeCarrier);
        model.addAttribute("mapsCarrier", new MapsCarrier());
        if(currentMaps!=0) {
            model.addAttribute("start", this.mapsCarriers.get(this.currentMaps - 1).getEndPointName());
            model.addAttribute("currentMaps", this.currentMaps);
        }
        else {
            model.addAttribute("start", "");
            model.addAttribute("currentMaps", this.currentMaps);
        }
        return "add_A_B";
    }

    @RequestMapping(value = "/nextAB", method = RequestMethod.POST)
    public String addPoin(@ModelAttribute("mapsCarrier") MapsCarrier mapsCarrier){
        this.mapsCarriers.add(mapsCarrier);
        System.out.println("SIZE MAPS = "+mapsCarriers.size());
        if(currentMaps==this.routeCarrier.getQuantity() && currentMaps!=0) {
            String str;
            str = routeCarrier.getStart();
            for (int i=0;i<this.routeCarrier.getQuantity();i++){
                str = str + " - "+ mapsCarriers.get(i).getEndPointName();
            }
            str = str+" - " +  routeCarrier.getEnd();
            for(int i=0;i<this.routeCarrier.getQuantity();i++){
                if(!this.pointsService.getByLogin(mapsCarriers.get(i).getEndPointName())){
                    Points point = new Points(mapsCarriers.get(i).getEndPointName());
                    pointsService.add(point);
                }
            }
            for(int i=0;i<=this.routeCarrier.getQuantity();i++){
                Transport transport = new Transport(mapsCarriers.get(i).getNameOfTransport(),mapsCarriers.get(i).getSpeed(),mapsCarriers.get(i).getCoefficient(),mapsCarriers.get(i).getMaxWeight());
                if(transportserviceTransport.getByTransport(transport) == null) {
                    transportService.add(transport);
                    System.out.println("null");
                }
                transportArrayList.add(transport);
                System.out.println(i);
            }
            routeService.add(new Route(str, ((Points) pointsService.getByLoginP(routeCarrier.getStart())).getIdPoint(), ((Points)pointsService.getByLoginP(routeCarrier.getEnd())).getIdPoint()));
            for (int i=0;i<mapsCarriers.size();i++) {
                System.out.println(mapsCarriers.size());
                Maps maps = null;
                if(i == 0) {
                    Points p1,p2  = null;
                    Route r = null;
                    Transport t = null;
                    p1 = (Points) pointsService.getByLoginP(routeCarrier.getStart());
                    p2 = (Points) pointsService.getByLoginP(mapsCarriers.get(i).getEndPointName());
                    r = (Route) routeService.getByLoginP(str);
                    t = (Transport) transportserviceTransport.getByTransport(transportArrayList.get(i));
                    maps = new Maps(p1.getIdPoint(), p2.getIdPoint(), r.getIdRoute(), mapsCarriers.get(i).getDistance(), t.getIdTransport(), mapsCarriers.get(i).getCostForHour());
                }
                else {
                    if (i + 1 == mapsCarriers.size()) {
                        maps = new Maps(((Points) pointsService.getByLoginP(mapsCarriers.get(i - 1).getEndPointName())).getIdPoint(), ((Points) pointsService.getByLoginP(routeCarrier.getEnd())).getIdPoint(), ((Route) routeService.getByLoginP(str)).getIdRoute(), mapsCarriers.get(i).getDistance(), ((Transport) transportserviceTransport.getByTransport(transportArrayList.get(i))).getIdTransport(), mapsCarriers.get(i).getCostForHour());
                    } else {
                        maps = new Maps(((Points) pointsService.getByLoginP(mapsCarriers.get(i - 1).getEndPointName())).getIdPoint(), ((Points) pointsService.getByLoginP(mapsCarriers.get(i).getEndPointName())).getIdPoint(), ((Route) routeService.getByLoginP(str)).getIdRoute(), mapsCarriers.get(i).getDistance(), ((Transport) transportserviceTransport.getByTransport(transportArrayList.get(i))).getIdTransport(), mapsCarriers.get(i).getCostForHour());
                    }
                }
                mapsArrayList.add(maps);
                mapsService.add(maps);
            }
            return "redirect:/carrier";
        }
        else{
            ++this.currentMaps;
            return "redirect:/add_AB";
        }
    }

}
