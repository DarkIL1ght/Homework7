package Part1;

import java.util.List;

public class SeasonIterator implements EpisodeIterator {
    private final List<Episode> episodes;
    private int position = 0;

    SeasonIterator(List<Episode> episodes) {
        this.episodes = episodes;
    }

    @Override
    public boolean hasNext() {
        return position < episodes.size();
    }

    @Override
    public Episode next() {
        return episodes.get(position++);
    }
}