package hi.verkefni.traveldata;

public class Review {
    private int id;
    private int rating;
    private String review1;
    private String review2;

    public Review(int id, int rating, String review1, String review2) {
        this.id = id;
        this.rating = rating;
        this.review1 = review1;
        this.review2 = review2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReview1() {
        return review1;
    }

    public void setReview1(String review1) {
        this.review1 = review1;
    }

    public String getReview2() {
        return review2;
    }

    public void setReview2(String review2) {
        this.review2 = review2;
    }
}
