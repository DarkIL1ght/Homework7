package Part1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Season implements Iterable<Episode> {
    private final List<Episode> episodes = new ArrayList<>();

    public void addEpisode(Episode e) {
        episodes.add(e);
    }

    // Обратный итератор
    public EpisodeIterator reverseIterator() {
        return new ReverseSeasonIterator(episodes);
    }

    // Перемешанный итератор
    public EpisodeIterator shuffleIterator() {
        return new ShuffleSeasonIterator(episodes);
    }

    // Реализация Iterable для for-each
    @Override
    public Iterator<Episode> iterator() {
        return episodes.iterator();
    }
}