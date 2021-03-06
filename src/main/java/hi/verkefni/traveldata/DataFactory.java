package hi.verkefni.traveldata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.*;

public class DataFactory {
    private static final String URL = "jdbc:sqlite:/home/tomas/Desktop/THB_DB.db";

    //INSERT KLASAR
    public static void insertDayTour(DayTour dayTour) {
        String sql = "INSERT INTO DayTour(id, name, type, description, rating, availability, price, hotelPickUp, difficulty, language, review_id, location_id, date) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);

            try {
                LocalDate date = dayTour.getDate();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, dayTour.getId());
                pstmt.setString(2, dayTour.getName());
                pstmt.setString(3, dayTour.getType());
                pstmt.setString(4, dayTour.getDescription());
                pstmt.setInt(5, dayTour.getRating());
                pstmt.setInt(6, dayTour.getAvailability());
                pstmt.setInt(7, dayTour.getPrice());
                pstmt.setInt(8, dayTour.getHotelPickUp());
                pstmt.setInt(9, dayTour.getDifficulty());
                pstmt.setString(10, dayTour.getLanguage());
                pstmt.setInt(11, dayTour.getReview_id());
                pstmt.setInt(12, dayTour.getLocation().getLocation());
                pstmt.setString(12, date.toString());

                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void insertDTReservation(DTReservation reservation) {
        String sql = "INSERT INTO DayTourReservation(id, user_id, guest, daytour_id) VALUES(?,?,?,?)";
        Connection conn = null;
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(URL);

            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, reservation.getReservationId());
                pstmt.setInt(2, reservation.getUser().getId());
                pstmt.setInt(3, reservation.getAmountOfPeople());
                pstmt.setInt(4, reservation.getDayTour().getId());


                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void insertUser(User user) {
        String sql = "INSERT INTO User(Id, name, email) VALUES(?,?,?)";
        Connection conn = null;
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(URL);

            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, user.getId());
                pstmt.setString(2, user.getName());
                pstmt.setString(3, user.getEmail());

                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void insertSeat(Seat seat) {
        String sql = "INSERT INTO Seat(id, price, occupied) VALUES(?,?,?)";
        Connection conn = null;
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(URL);

            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, seat.getId());
                pstmt.setInt(2, seat.getPrice());
                pstmt.setInt(3, seat.isOccupied());

                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void insertAirplane(Airplane ap) {
        String sql = "INSERT INTO Airplane(id, seat1_id) VALUES(?,?)";
        Connection conn = null;
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(URL);

            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, ap.getId());
                pstmt.setInt(2, ap.getSeats().get(0).getId());

                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void insertArrival(Arrival arrival) {
        String sql = "INSERT INTO Arrival(id, airport_id, location_id, time) VALUES(?,?,?,?)";
        Connection conn = null;
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(URL);

            try {
                LocalDate date = arrival.getDate();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, arrival.getId());
                pstmt.setInt(2, arrival.getAirport().getId());
                pstmt.setInt(3, arrival.getLocation().getLocation());
                pstmt.setString(4, date.toString());

                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void insertDeparture(Departure departure) {
        String sql = "INSERT INTO Departure(id, airport_id, location_id, time) VALUES(?,?,?,?)";
        Connection conn = null;
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(URL);

            try {
                LocalDate date = departure.getDate();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, departure.getId());
                pstmt.setInt(2, departure.getAirport().getId());
                pstmt.setInt(3, departure.getLocation().getLocation());
                pstmt.setString(4, date.toString());

                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void insertFlight(Flight flight) {
        String sql = "INSERT INTO Flight(id, date, price, arrival_id, departure_id, plane_id) VALUES(?,?,?,?,?,?)";
        Connection conn = null;
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(URL);

            try {
                LocalDate date = flight.getDate();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, flight.getId());
                pstmt.setString(2, date.toString());
                pstmt.setInt(3, flight.getPrice());
                pstmt.setInt(4, flight.getArrival().getId());
                pstmt.setInt(5, flight.getDeparture().getId());
                pstmt.setInt(6, flight.getPlane().getId());

                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void insertFlightReservation(FlightReservation freservation) {
        String sql = "INSERT INTO FlightReservations(id, user_id, passangers, flight_id, seat_id, bothWays) VALUES(?,?,?,?,?,?)";
        Connection conn = null;
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(URL);

            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, freservation.getId());
                pstmt.setInt(2, freservation.getUser().getId());
                pstmt.setInt(3, freservation.getPassengers());
                pstmt.setInt(4, freservation.getFlight().getId());
                pstmt.setInt(5, freservation.getSeat().getId());
                pstmt.setInt(6, freservation.getBothways());

                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void insertHotelReservation(HotelReservation hotelReservation){
        String sql = "INSERT INTO HotelReservations(id, user_id, room_id, hotel_id, date) VALUES(?,?,?,?,?)";
        Connection conn = null;
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(URL);

            try {
                LocalDate date = hotelReservation.getDate();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, hotelReservation.getId());
                pstmt.setInt(2, hotelReservation.getUser().getId());
                pstmt.setInt(3, hotelReservation.getRoom().getId());
                pstmt.setInt(4, hotelReservation.getHotel().getId());
                pstmt.setString(5, date.toString());

                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void insertReview(Review review) {
        String sql = "INSERT INTO Reviews(id, rating, Review1, Review2) VALUES(?,?,?,?)";
        Connection conn = null;
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(URL);

            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, review.getId());
                pstmt.setInt(2, review.getRating());
                pstmt.setString(3, review.getReview1());
                pstmt.setString(4, review.getReview2());

                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }


    //SELECT KLASSAR
    public static List<Reservation> selectAllDayTour() {
        String sql = "SELECT * FROM DayTour;";
        Connection conn = null;
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(URL);

            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                List<Reservation> Daytours = new ArrayList<>();
                // loop through the result set
                while (rs.next()) {
                    Daytours.add(new DayTour(rs.getInt(1), rs.getString(2), LocalDate.parse(rs.getString(13)), new TravelLocation("", rs.getInt(12)), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getString(10), rs.getInt(11)));
                }

                return Daytours;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return null;
    }

    public static List<DTReservation> selectAllDayTourReservations() {
        String sql = "SELECT * FROM DayTourReservations";
        Connection conn = null;
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(URL);

            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                List<DTReservation> Daytoursreservation = new ArrayList<>();
                // loop through the result set
                while (rs.next()) {
                    int reservationId = rs.getInt(1);
                    int UserId = rs.getInt(2);
                    int AmountOfP = rs.getInt(3);
                    int DaytourId = rs.getInt(4);

                    DayTour x = TourSearchController.searchById(DaytourId);
                    User n = UserSearchController.searchById(UserId);

                    Daytoursreservation.add(new DTReservation(n, x, AmountOfP, reservationId));
                }

                return Daytoursreservation;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return null;
    }

    public static List<User> selectAllUsers() {
        String sql = "SELECT * FROM User";
        Connection conn = null;
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(URL);

            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                List<User> Users = new ArrayList<>();
                // loop through the result set
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    String email = rs.getString(3);

                    // TODO: ??tf??ra password
                    Users.add(new User(id, name, email, "password123"));
                }

                return Users;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return null;
    }

    public static List<TravelLocation> selectAllLocation() {
        String sql = "SELECT * FROM Location";
        Connection conn = null;
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(URL);

            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                List<TravelLocation> Loc = new ArrayList<>();
                // loop through the result set
                while (rs.next()) {
                    int Id = rs.getInt(1);
                    String name = rs.getString(2);

                    Loc.add(new TravelLocation(name, Id));
                }

                return Loc;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return null;
    }

    public static List<Reservations> selectAllReservations() {
        String sql = "SELECT * FROM Reservations";
        Connection conn = null;
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(URL);

            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                List<Reservations> Reserv = new ArrayList<>();
                // loop through the result set
                while (rs.next()) {
                    int Id = rs.getInt(1);
                    int UserId = rs.getInt(2);
                    int ReservId = rs.getInt(3);

                    Reserv.add(new Reservations(Id, UserId, ReservId));
                }

                return Reserv;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return null;
    }

    public static List<Airport> selectAllAirport() {
        String sql = "SELECT * FROM Airport";
        Connection conn = null;
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(URL);

            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                List<Airport> Airports = new ArrayList<>();
                // loop through the result set
                while (rs.next()) {
                    int Id = rs.getInt(1);
                    String shortname = rs.getString(2);
                    String name = rs.getString(3);
                    //int location = rs.getInt(4);

                    Airports.add(new Airport(Id, shortname, name));
                }

                return Airports;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return null;
    }

    public static List<Seat> selectAllSeat() {
        String sql = "SELECT * FROM Seat";
        Connection conn = null;
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(URL);

            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                List<Seat> seats = new ArrayList<>();
                // loop through the result set
                while (rs.next()) {
                    int id = rs.getInt(1);
                    int price = rs.getInt(2);
                    int occupied = rs.getInt(3);

                    seats.add(new Seat(id, price, occupied));
                }

                return seats;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return null;
    }

    public static List<Airplane> selectAllAirplane() {
        String sql = "SELECT * FROM Airplane";
        Connection conn = null;
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(URL);

            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                List<Airplane> airplanes = new ArrayList<>();
                Map<Integer, Airplane> airplaneMap = new HashMap<>();
                List<Seat> seats = selectAllSeat();
                Collections.sort(seats);
                Integer[] seatIdArray = new Integer[seats.size()];
                for (int i = 0; i < seats.size(); i++) {
                    seatIdArray[i] = seats.get(i).getId();
                }
                List<Integer> seatIds = Arrays.asList(seatIdArray);
                // loop through the result set
                int counter = 0;
                while (rs.next()) {
                    int id = rs.getInt(1);
                    int seatId = rs.getInt(2);

                    Seat seat = seats.get(Collections.binarySearch(seatIds, seatId));
                    if (airplaneMap.containsKey(id)) {
                        airplaneMap.get(id).getSeats().add(seat);
                    } else {
                        List<Seat> seatList = new ArrayList<>();
                        seatList.add(seat);
                        Airplane airplane = new Airplane(id, seatList);
                        airplaneMap.put(id, airplane);
                    }
                }
                for (Airplane airplane : airplaneMap.values()) {
                    airplanes.add(airplane);
                }
                return airplanes;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return null;
    }

    public static List<Arrival> selectAllArrival() {
        String sql = "SELECT * FROM Arrival";
        Connection conn = null;
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(URL);

            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                List<Arrival> Arrivals = new ArrayList<>();
                List<Airport> airports = selectAllAirport();
                Collections.sort(airports);
                Integer[] airportIdArray = new Integer[airports.size()];
                for (int i = 0; i < airports.size(); i++) {
                    airportIdArray[i] = airports.get(i).getId();
                }
                List<Integer> airportIds = Arrays.asList(airportIdArray);
                // loop through the result set
                while (rs.next()) {
                    int id = rs.getInt(1);
                    int airportId = Collections.binarySearch(airportIds, rs.getInt(2));
                    Airport airport = airports.get(airportId);
                    TravelLocation loc = new TravelLocation("", rs.getInt(3));
                    LocalDate d = LocalDate.parse(rs.getString(4));

                    Arrivals.add(new Arrival(id, airport, loc, d));
                }

                return Arrivals;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return null;
    }

    public static List<Departure> selectAllDeparture() {
        String sql = "SELECT * FROM Departure";
        Connection conn = null;
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(URL);

            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                List<Departure> Departures = new ArrayList<>();
                List<Airport> airports = selectAllAirport();
                Collections.sort(airports);
                Integer[] airportIdArray = new Integer[airports.size()];
                for (int i = 0; i < airports.size(); i++) {
                    airportIdArray[i] = airports.get(i).getId();
                }
                List<Integer> airportIds = Arrays.asList(airportIdArray);
                // loop through the result set
                while (rs.next()) {
                    int id = rs.getInt(1);
                    int airportId = Collections.binarySearch(airportIds, rs.getInt(2));
                    Airport airport = airports.get(airportId);
                    TravelLocation loc = new TravelLocation("", rs.getInt(3));
                    LocalDate d = LocalDate.parse(rs.getString(4));

                    Departures.add(new Departure(id, airport, loc, d));
                }

                return Departures;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return null;
    }

    public static List<Flight> selectAllFlight() {
        String sql = "SELECT * FROM Flight";
        Connection conn = null;
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(URL);

            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                List<Flight> Flights = new ArrayList<>();
                List<Arrival> arrivals = selectAllArrival();
                List<Departure> departures = selectAllDeparture();
                List<Airplane> airplanes = selectAllAirplane();
                Collections.sort(arrivals);
                Integer[] arrivalIdArray = new Integer[arrivals.size()];
                for (int i = 0; i < arrivals.size(); i++) {
                    arrivalIdArray[i] = arrivals.get(i).getId();
                }
                Collections.sort(departures);
                Integer[] departureIdArray = new Integer[departures.size()];
                for (int i = 0; i < departures.size(); i++) {
                    departureIdArray[i] = departures.get(i).getId();
                }
                Collections.sort(airplanes);
                Integer[] airplaneIdArray = new Integer[airplanes.size()];
                for (int i = 0; i < airplanes.size(); i++) {
                    airplaneIdArray[i] = airplanes.get(i).getId();
                }
                List<Integer> arrivalIds = Arrays.asList(arrivalIdArray);
                List<Integer> departureIds = Arrays.asList(departureIdArray);
                List<Integer> airplaneIds = Arrays.asList(airplaneIdArray);
                // loop through the result set
                while (rs.next()) {
                    int Id = rs.getInt(1);
                    LocalDate d = LocalDate.parse(rs.getString(2));
                    int price = rs.getInt(3);
                    int arrivalId = Collections.binarySearch(arrivalIds, rs.getInt(4));
                    int departureId = Collections.binarySearch(departureIds, rs.getInt(5));
                    int airplaneId = Collections.binarySearch(airplaneIds, rs.getInt(6));
                    Arrival arrival = arrivals.get(arrivalId);
                    Departure departure = departures.get(departureId);
                    Airplane airplane = airplanes.get(airplaneId);

                    Flights.add(new Flight(Id, d, price, arrival, departure, airplane));
                }

                return Flights;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return null;
    }

    public static List<Hotel> selectAllHotels() {
        String sql = "SELECT * FROM Hotel;";
        Connection conn = null;
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(URL);

            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                List<Hotel> Hotels = new ArrayList<>();
                // loop through the result set
                while (rs.next()) {
                    int id = rs.getInt(1);
                    List<Room> rooms = selectAllRooms();
                    rooms.removeIf(i -> i.getHotelId() != id);
                    Hotels.add(new Hotel(id, rs.getString(2), new TravelLocation("", rs.getInt(3)), rs.getInt(4), rs.getInt(5), rs.getInt(6), rooms));
                }

                return Hotels;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return null;
    }

    public static List<Room> selectAllRooms() {
        String sql = "SELECT * FROM HotelRoom;";
        Connection conn = null;
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(URL);

            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                List<Room> Rooms = new ArrayList<>();
                // loop through the result set
                while (rs.next()) {
                    List<RoomAvailability> availabilities = selectAllRoomAvailability();
                    int id = rs.getInt(1);
                    availabilities.removeIf(i -> i.getId() != id);
                    Room room = new Room(id, rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5), availabilities);
                    Rooms.add(room);
                    for (RoomAvailability availability : availabilities) {
                        availability.setRoom(room);
                        availability.setPrice(room.getPrice());
                    }
                }

                return Rooms;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return null;
    }

    public static List<HotelReservation> selectAllHotelReservations() {
        String sql = "SELECT * FROM HotelReservations;";
        Connection conn = null;
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(URL);

            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                List<HotelReservation> hr = new ArrayList<>();
                // loop through the result set
                while (rs.next()) {
                    hr.add(new HotelReservation(rs.getInt(1), UserSearchController.searchById(rs.getInt(2)), HotelSearchController.findRoomById(rs.getInt(3)),HotelSearchController.findHotelById(rs.getInt(4)),LocalDate.parse(rs.getString(5))));
                }

                return hr;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return null;
    }

    public static List<FlightReservation> selectAllFlightReservations() {
        String sql = "SELECT * FROM FlightReservations";
        Connection conn = null;
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(URL);

            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                List<FlightReservation> Freservations = new ArrayList<>();
                // loop through the result set
                while (rs.next()) {
                    int Id = rs.getInt(1);
                    User uId = UserSearchController.searchById(rs.getInt(2));
                    int passengers = rs.getInt(3);
                    //Flight F = FlightSearchController.findFlightById(rs.getInt(4));
                    //Seat S = FlightSearchController.findSeatById(rs.getInt(5));
                    int bw = rs.getInt(6);

                    //Freservations.add(new FlightReservation(Id, uId, passengers, F, S, bw));
                }

                return Freservations;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return null;
    }

    public static List<Review> selectAllReview() {
        String sql = "SELECT * FROM Reviews;";
        Connection conn = null;
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(URL);

            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                List<Review> Reviews = new ArrayList<>();
                // loop through the result set
                while (rs.next()) {
                    Reviews.add(new Review(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
                }

                return Reviews;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return null;
    }
    
    public static List<RoomAvailability> selectAllRoomAvailability() {
        String sql = "SELECT * FROM RoomAvailability;";
        Connection conn = null;
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(URL);

            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                List<RoomAvailability> availabilities = new ArrayList<>();
                // loop through the result set
                while (rs.next()) {
                    availabilities.add(new RoomAvailability(rs.getInt(1), LocalDate.parse(rs.getString(2)), rs.getInt(3)));
                }

                return availabilities;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return null;
    }

    //M??guleikar til a?? setja inn

    public static void runSQL(String sql) {
        Connection conn = null;
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(URL);

            Statement statement = conn.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate(sql);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}



