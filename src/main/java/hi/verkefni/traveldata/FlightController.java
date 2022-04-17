package hi.verkefni.traveldata;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FlightController {
    private ArrayList<Flight> flights = (ArrayList<Flight>) DataFactory.selectAllFlight();

    public int findNextIdFlight() {
        List<Flight> flight = DataFactory.selectAllFlight();
        int id = flight.get(0).getId();
        for (int n = 0; n < flight.size(); n++) {
            if (flight.get(n).getId() > id) {
                id = flight.get(n).getId();
            }
        }
        return id+1;
    }

    public void addFlight(LocalDate date, int price, Arrival arrival, Departure departure, Airplane plane) {
        int id = findNextIdFlight();
        DataFactory.insertFlight(new Flight(id,date,price,arrival,departure,plane));
    }

    public void deleteFlight(int id) {
        String sql = "DELETE FROM Flight WHERE id = " + id + ";";
        DataFactory.runSQL(sql);
    }

    public void changeFlightPrice(Flight flight, int newPrice) {
        String sql = "UPDATE Flight SET price = " + newPrice + " WHERE id = " + flight.getId() + ";";
        DataFactory.runSQL(sql);
    }

    public void changeFlightDate(Flight flight, LocalDate newDate) {
        String sql = "UPDATE Flight SET date = '" + newDate.toString() + "' WHERE id = " + flight.getId() + ";";
        DataFactory.runSQL(sql);
    }

    public void changeArrival(Flight flight, Arrival newArrival) {
        int ArrivalID = newArrival.getId();
        String sql = "UPDATE Flight SET arrival_id = " + ArrivalID + " WHERE id = " + flight.getId() + ";";
        DataFactory.runSQL(sql);
    }

    public void changeDeparture(Flight flight, Departure newDeparture) {
        int DepartureID = newDeparture.getId();
        String sql = "UPDATE Flight SET departure_id = " + DepartureID + " WHERE id = " + flight.getId() + ";";
        DataFactory.runSQL(sql);
    }

    public void changePlane(Flight flight, Airplane newPlane) {
        int AirplaneID = newPlane.getId();
        String sql = "UPDATE Flight SET plane_id = " + AirplaneID + " WHERE id = " + flight.getId() + ";";
        DataFactory.runSQL(sql);
    }
}
