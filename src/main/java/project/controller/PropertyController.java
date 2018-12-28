package project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.clasess.MapsCarrier;
import project.clasess.Price;
import project.clasess.RouteCarrier;
import project.clasess.RouteUser;
import project.last.*;
import project.service.Service;
import project.service.ServiceRoute;
import project.service.ServiceTransport;


import java.util.ArrayList;
import java.util.List;


@Controller
public class PropertyController {
    //private Service propertyService;
    private Service pointsService;
    private ServiceRoute routeService;
    private Service transportService;
    private Service orderUserService;
    private ServiceTransport transportserviceTransport;
    private RouteCarrier routeCarrier;
    private RouteUser routeUser;

    private Integer id;
    private Service mapsService;
    private int currentMaps;
    private List points = new ArrayList<Points>();
    private ArrayList<MapsCarrier> mapsCarriers = new ArrayList<MapsCarrier>();
    private ArrayList<Transport> transportArrayList = new ArrayList<Transport>();
    private ArrayList<Maps> mapsArrayList = new ArrayList<Maps>();
    private List<Route> routeArrayList = new ArrayList<Route>();
    private List<Price> priceList = new ArrayList<Price>();


    /*public RouteUser getRouteUser() {
        return routeUser;
    }

    public void setRouteUser(RouteUser routeUser) {
        this.routeUser = routeUser;
    }*/
    @Autowired(required = true)
    @Qualifier(value = "orderUserService")
    public void setOrderUserService(Service orderUserService) {
        this.orderUserService = orderUserService;
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
    public void setMapsService(Service mapsService) {
        this.mapsService = mapsService;
    }


    @RequestMapping(value = "/client/showClient", method = RequestMethod.POST)
    public String getListRoutes(@ModelAttribute("routeUser") RouteUser routeUser) {
        this.routeUser = routeUser;
        Integer start = ((Points) pointsService.getByLoginP(routeUser.getStart())).getIdPoint();
        Integer end = ((Points) pointsService.getByLoginP(routeUser.getEnd())).getIdPoint();
        this.routeArrayList = (List<Route>) routeService.getRouteByEndStart(start, end);
        for (Route r : this.routeArrayList) {
            System.out.println(r.getNameOfRoute());
        }
        priceList = (List<Price>) routeService.listOfRoute(routeArrayList, routeUser.getMass());
        return "redirect:http://localhost:8080/show_routes";
    }

    @RequestMapping(value = "/carrier/showCarrier", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("routeCarrier") RouteCarrier routeCarrier) {
        System.out.println(routeCarrier.getStart());
        System.out.println(routeCarrier.getEnd());
        this.routeCarrier = routeCarrier;
        this.currentMaps = 0;
        if (!this.pointsService.getByLogin(routeCarrier.getStart())) {
            this.pointsService.add(new Points(routeCarrier.getStart()));

        }
        if (!this.pointsService.getByLogin(routeCarrier.getEnd())) {
            this.pointsService.add(new Points(routeCarrier.getEnd()));
        }
        this.points = pointsService.list();
        return "redirect:http://localhost:8080/add_AB";
    }

    @RequestMapping(value = "client", method = RequestMethod.GET)
    public String addClient(Model model) {
        this.mapsCarriers.removeAll(this.mapsCarriers);
        this.priceList.removeAll(this.priceList);
        this.routeArrayList.removeAll(this.routeArrayList);
        this.mapsArrayList.removeAll(this.mapsArrayList);
        this.transportArrayList.removeAll(this.transportArrayList);
        model.addAttribute("routeUser", new RouteUser());
        model.addAttribute("user", UserController.getCurrentUser());
        return "AB_client";
    }

    @RequestMapping(value = "show_routes", method = RequestMethod.GET)
    public String showClientRoute(Model model) {
        this.id = null;
        model.addAttribute("listRoutes", this.priceList);
        model.addAttribute("user", UserController.getCurrentUser());
        model.addAttribute("orderUser", new OrderUser());
        return "show_routes";
    }

    @RequestMapping(value = "add_order", method = RequestMethod.GET)
    public String addOrder(Model model) {
        model.addAttribute("orderUser", new OrderUser());
        return "add_order";
    }


    @RequestMapping(value = "/client/add_order", method = RequestMethod.POST)
    public String addOrderClient(@ModelAttribute("orderUser") OrderUser orderUser) {
        Price price = null;
        for (Price p : priceList) {
            if (p.getIdRoute().equals(id)) {
                price = p;
                break;
            }
        }
        System.out.println("id : " + id);
        System.out.println("mass : " + this.routeUser.getMass());
        System.out.println("id user : " + UserController.getCurrentUser().getId());
        System.out.println("price : " + price.getIdRoute());
        if (price != null) {
            this.orderUserService.add(new OrderUser(price.getPrice(), price.getIdRoute(), this.routeUser.getMass(), UserController.getCurrentUser().getId(), orderUser.getPhone(), orderUser.getFirstName(), orderUser.getSecondName(), "Оформлена", orderUser.geteMail()));
            this.routeUser = null;
        }
        return "redirect:/client";
    }


    @RequestMapping(value = "carrier", method = RequestMethod.GET)
    public String addCarrier(Model model) {
        this.mapsCarriers.removeAll(this.mapsCarriers);
        this.priceList.removeAll(this.priceList);
        this.routeArrayList.removeAll(this.routeArrayList);
        this.mapsArrayList.removeAll(this.mapsArrayList);
        this.transportArrayList.removeAll(this.transportArrayList);
        model.addAttribute("routeCarrier", new RouteCarrier());
        model.addAttribute("user", UserController.getCurrentUser());
        System.out.println(UserController.getCurrentUser().getLogin());
        return "AB_carrier";
    }


    @RequestMapping(value = "/order_carrier", method = RequestMethod.GET)
    public String showCarrier(Model model) {
        List<OrderUser> orderUsers = null;
        List<OrderUser> orderUsers1 = new ArrayList<OrderUser>();
        orderUsers = this.orderUserService.list();

        List<Route> routeList = null;
        List<Route> routeList1 = new ArrayList<Route>();
        routeList = this.routeService.list();
        for (Route r : routeList) {
            if (r.getIdUserCreatedRoute().equals(UserController.getCurrentUser().getId()))
                routeList1.add(r);
        }
        for (Route r : routeList1) {
            for (OrderUser o : orderUsers) {
                if (r.getIdRoute().equals(o.getIdRouteOrder())) {
                    orderUsers1.add(o);
                }
            }
        }
        model.addAttribute("listOrderUser", orderUsers1);
        model.addAttribute("user", UserController.getCurrentUser());
        return "order_carrier";
    }

    @RequestMapping(value = "/order_client", method = RequestMethod.GET)
    public String showClient(Model model) {

        List<OrderUser> orderUsers = null;
        List<OrderUser> orderUsers1 = new ArrayList<OrderUser>();
        orderUsers = this.orderUserService.list();
        for (OrderUser o : orderUsers) {
            if (o.getIdUserOrder().equals(UserController.getCurrentUser().getId())) {
                orderUsers1.add(o);
            }
        }
        model.addAttribute("listOrderUser", orderUsers1);
        model.addAttribute("user", UserController.getCurrentUser());

        return "order_client";
    }

    @RequestMapping(value = "/all_routes_for_carrier", method = RequestMethod.GET)
    public String getAllRoutesForCarrier(Model model) {

        List<Route> routes = null;
        List<Route> routes1 = new ArrayList<Route>();
        routes = this.routeService.list();
        model.addAttribute("user", UserController.getCurrentUser());
        if (UserController.getCurrentUser().getRole().equals("admin")) {
            model.addAttribute("listRoutes", routes);
            return "note/show_routes_all";
        } else {
            for (Route r : routes) {
                if (r.getIdUserCreatedRoute().equals(UserController.getCurrentUser().getId())) {
                    routes1.add(r);
                }
            }
            model.addAttribute("listRoutes", routes1);
            return "show_routes_for_carrier";
        }
    }

    @RequestMapping(value = "add_AB", method = RequestMethod.GET)
    public String addAb(Model model) {
        model.addAttribute("routeCarrier", this.routeCarrier);
        model.addAttribute("mapsCarrier", new MapsCarrier());
        model.addAttribute("user", UserController.getCurrentUser());
        if (currentMaps != 0) {
            model.addAttribute("start", this.mapsCarriers.get(this.currentMaps - 1).getEndPointName());
            model.addAttribute("currentMaps", this.currentMaps);
        } else {
            model.addAttribute("start", "");
            model.addAttribute("currentMaps", this.currentMaps);
        }
        return "add_A_B";
    }

    @RequestMapping("/editOrderUser/{id}")
    public String editOrder(@PathVariable("id") Integer id, Model model) {
        //this.orderUserService.add(new OrderUser());
        this.id = id;
        return "redirect:http://localhost:8080/add_order";
    }

    @RequestMapping("/changeStatus/{string}")
    public String changeStatus(@PathVariable("string") String string, Model model) {
        //this.orderUserService.add(new OrderUser());
        String[] arg = string.split("_");
        String status = arg[1];
        Integer id = Integer.parseInt(arg[0]);
        /*System.out.println("id "+arg[0]);
        System.out.println("status "+status);
        System.out.println("id "+id);
        System.out.println("STRING : "+string);*/
        OrderUser orderUser = (OrderUser) this.orderUserService.getById(id);
        orderUser.setStatus(status);
        this.orderUserService.update(orderUser);
        System.out.println("status " + orderUser.getStatus());

        return "redirect:/order_carrier";
    }



    @RequestMapping(value = "/nextAB", method = RequestMethod.POST)
    public String addPoin(@ModelAttribute("mapsCarrier") MapsCarrier mapsCarrier) {
        this.mapsCarriers.add(mapsCarrier);
        System.out.println("SIZE MAPS = " + mapsCarriers.size());
        if (currentMaps == this.routeCarrier.getQuantity() && currentMaps != 0) {
            String str;
            str = routeCarrier.getStart();
            for (int i = 0; i < this.routeCarrier.getQuantity(); i++) {
                str = str + " - " + mapsCarriers.get(i).getEndPointName();
            }
            str = str + " - " + routeCarrier.getEnd();
            for (int i = 0; i < this.routeCarrier.getQuantity(); i++) {
                if (!this.pointsService.getByLogin(mapsCarriers.get(i).getEndPointName())) {
                    Points point = new Points(mapsCarriers.get(i).getEndPointName());
                    pointsService.add(point);
                }
            }
            for (int i = 0; i <= this.routeCarrier.getQuantity(); i++) {
                Transport transport = new Transport(mapsCarriers.get(i).getNameOfTransport(), mapsCarriers.get(i).getSpeed(), mapsCarriers.get(i).getCoefficient(), mapsCarriers.get(i).getMaxWeight());
                if (transportserviceTransport.getByTransport(transport) == null) {
                    transportService.add(transport);
                    System.out.println("null");
                }
                transportArrayList.add(transport);
                System.out.println(i);
            }
            routeService.add(new Route(str, ((Points) pointsService.getByLoginP(routeCarrier.getStart())).getIdPoint(), ((Points) pointsService.getByLoginP(routeCarrier.getEnd())).getIdPoint(), UserController.getCurrentUser().getId()));
            for (int i = 0; i < mapsCarriers.size(); i++) {
                System.out.println(mapsCarriers.size());
                Maps maps = null;
                if (i == 0) {
                    Points p1, p2 = null;
                    Route r = null;
                    Transport t = null;
                    p1 = (Points) pointsService.getByLoginP(routeCarrier.getStart());
                    p2 = (Points) pointsService.getByLoginP(mapsCarriers.get(i).getEndPointName());
                    r = (Route) routeService.getByLoginP(str);
                    t = (Transport) transportserviceTransport.getByTransport(transportArrayList.get(i));
                    maps = new Maps(p1.getIdPoint(), p2.getIdPoint(), r.getIdRoute(), mapsCarriers.get(i).getDistance(), t.getIdTransport(), mapsCarriers.get(i).getCostForHour());
                } else {
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
        } else {
            ++this.currentMaps;
            return "redirect:/add_AB";
        }
    }

}
