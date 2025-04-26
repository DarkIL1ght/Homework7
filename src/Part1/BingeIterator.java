package Part1;

import java.util.List;

public class BingeIterator implements EpisodeIterator {
    private final List<Season> seasons;
    private int currentSeasonIndex = 0;
    private EpisodeIterator currentIterator;

    public BingeIterator(List<Season> seasons) {
        this.seasons = seasons;
        if (!seasons.isEmpty()) {
            currentIterator = (EpisodeIterator) seasons.get(0).iterator();
        }
    }

    @Override
    public boolean hasNext() {
        while (currentIterator == null || !currentIterator.hasNext()) {
            if (currentSeasonIndex >= seasons.size() - 1) return false;
            currentIterator = (EpisodeIterator) seasons.get(++currentSeasonIndex).iterator();
        }
        return true;
    }

    @Override
    public Episode next() {
        return currentIterator.next();
    }
}