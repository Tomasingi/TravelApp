package hi.verkefni.traveldata;

import java.util.ArrayList;

public class ReviewController {

    public Review findReviewById(int id){
        ArrayList<Review> reviews = new ArrayList<>();
        reviews = (ArrayList<Review>) DataFactory.selectAllReview();

        reviews.removeIf(i -> i.getId() != id);
        return reviews.get(0);
    }

    public void changeReviewRating(Review review,int rating){
        String sql = "UPDATE Reviews SET rating=" + rating + " WHERE id=" + review.getId() + ";";
        DataFactory.runSQL(sql);
    }

    public void changeReview1(Review review, String str){
        String sql = "UPDATE Reviews SET Review1=" + str + " WHERE id=" + review.getId() + ";";
        DataFactory.runSQL(sql);
    }

    public void changeReview2(Review review, String str){
        String sql = "UPDATE Reviews SET Review2=" + str + " WHERE id=" + review.getId() + ";";
        DataFactory.runSQL(sql);
    }

    public static int findNextReviewId() {
        ArrayList<Review> reviews = new ArrayList<>();
        reviews = (ArrayList<Review>) DataFactory.selectAllReview();
        int id = reviews.get(0).getId();
        for (Review review : reviews) {
            if (review.getId() > id) {
                id = review.getId();
            }
        }
        return id+1;
    }

    public void insertReviewDayTour(DayTour dayTour, int rating, String review1, String review2){

        Review review = new Review(dayTour.getReview_id(), rating, review1, review2);

        DataFactory.insertReview(review);
    }

    public void insertReviewHotel(Hotel hotel, int rating, String review1, String review2){

        Review review = new Review(hotel.getReviewId(), rating, review1, review2);

        DataFactory.insertReview(review);
    }

}
