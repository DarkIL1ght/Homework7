package Part1;

public class Episode {
    private final String title;
    private final int runtimeSec;
    private boolean watched;

    public Episode(String title, int runtimeSec) {
        this.title = title;
        this.runtimeSec = runtimeSec;
        this.watched = false;
    }

    public String getTitle() { return title; }
    public int getRuntimeSec() { return runtimeSec; }
    public boolean isWatched() { return watched; }
    public void markAsWatched() { watched = true; }
}