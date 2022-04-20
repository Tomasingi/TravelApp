package hi.verkefni.traveldata;

import java.util.List;

public class FlightSearchController {

    // Gagnslaust
    public static Seat findSeatById(int id) {
        List<Seat> Seats = DataFactory.selectAllSeat();

        Seats.removeIf(i -> i.getId() != id);
        // WTF!?
        return Seats.get(0);
    }

    // Gagnslaust
    public static Arrival findArrivalById(int id){
        List<Arrival> Arrivals = DataFactory.selectAllArrival();

        Arrivals.removeIf(i -> i.getId() != id);
        return Arrivals.get(0);
    }

    // Gagnslaust
    public static Departure findDepartureById(int id){
        List<Departure> Departures = DataFactory.selectAllDeparture();

        Departures.removeIf(i -> i.getId() != id);
        return Departures.get(0);
    }

    // Gagnslaust
    public static Airplane findAirplaneById(int id){
        List<Airplane> Airplanes = DataFactory.selectAllAirplane();

        Airplanes.removeIf(i -> i.getId() != id);
        return Airplanes.get(0);
    }

    public static List<Flight> findAllFlights() {
        List<Flight> flights = DataFactory.selectAllFlight();
        return flights;
    }

    // Mögulega Gagnslaust
    public static Flight findFlightById(int id){
        List<Flight> Flights = DataFactory.selectAllFlight();

        Flights.removeIf(i -> i.getId() != id);
        return Flights.get(0);
    }

    // Gagnslaust
    public static Airport findAirportById(int id){
        List<Airport> ap = DataFactory.selectAllAirport();

        ap.removeIf(i -> i.getId() != id);
        return ap.get(0);
    }

    // Gagnslaust
    public static List<Flight> findFlightByArrival(String location) {
        List<Flight> flights = DataFactory.selectAllFlight();

        flights.removeIf(i -> i.getArrival().getLocation().getName().compareTo(location) != 0);
        return flights;
    }

    // Gagnslaust
    public static List<Flight> findFlightByDeparture(String location) {
        List<Flight> flights = DataFactory.selectAllFlight();

        flights.removeIf(i -> i.getDeparture().getLocation().getName().compareTo(location) != 0);
        return flights;
    }

}
