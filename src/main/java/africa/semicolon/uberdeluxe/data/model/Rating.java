package africa.semicolon.uberdeluxe.data.model;

public enum Rating {
    BAD(1),
    SATISFACTORY(3),
    GOOD(2),
    EXCELLENT(5);
    private int rating;

    public int getRating() {
        return rating;
    }
    Rating(int rating){
        this.rating = rating;
    }
}
