package hi.verkefni.traveldata;

import java.util.ArrayList;

public class FlightSearchController {

    public static Seat findSeatById(int id){
        ArrayList<Seat> Seats = new ArrayList<>();
        Seats = (ArrayList<Seat>) DataFactory.selectAllSeat();

        Seats.removeIf(i -> i.getId() != id);
        return Seats.get(0);
    }

    public static Arrival findArrivalById(int id){
        ArrayList<Arrival> Arrivals = new ArrayList<>();
        Arrivals = (ArrayList<Arrival>) DataFactory.selectAllArrival();

        Arrivals.removeIf(i -> i.getId() != id);
        return Arrivals.get(0);
    }

    public static Departure findDepartureById(int id){
        ArrayList<Departure> Departures = new ArrayList<>();
        Departures = (ArrayList<Departure>) DataFactory.selectAllDeparture();

        Departures.removeIf(i -> i.getId() != id);
        return Departures.get(0);
    }

    public static Airplane findAirplaneById(int id){
        ArrayList<Airplane> Airplanes = new ArrayList<>();
        Airplanes = (ArrayList<Airplane>) DataFactory.selectAllAirplane();

        Airplanes.removeIf(i -> i.getId() != id);
        return Airplanes.get(0);
    }

    public static Flight findFlightById(int id){
        ArrayList<Flight> Flights = new ArrayList<>();
        Flights = (ArrayList<Flight>) DataFactory.selectAllFlight();

        Flights.removeIf(i -> i.getId() != id);
        return Flights.get(0);
    }

    public static Airport findAirportById(int id){
        ArrayList<Airport> ap = new ArrayList<>();
        ap = (ArrayList<Airport>) DataFactory.selectAllAirport();

        ap.removeIf(i -> i.getId() != id);
        return ap.get(0);
    }

    public static ArrayList<Flight> findFlightByArrival(String location) {
        ArrayList<Flight> flights = new ArrayList<>();
        flights = (ArrayList<Flight>) DataFactory.selectAllFlight();

        flights.removeIf(i -> i.getArrival().getLocation().getName().compareTo(location) != 0);
        return flights;
    }

    public static ArrayList<Flight> findFlightByDeparture(String location) {
        ArrayList<Flight> flights = new ArrayList<>();
        flights = (ArrayList<Flight>) DataFactory.selectAllFlight();

        flights.removeIf(i -> i.getDeparture().getLocation().getName().compareTo(location) != 0);
        return flights;
    }

}
