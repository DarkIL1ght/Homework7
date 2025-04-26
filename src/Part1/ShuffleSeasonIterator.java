package Part1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ShuffleSeasonIterator implements EpisodeIterator {
    private final List<Episode> shuffled;
    private int position = 0;

    ShuffleSeasonIterator(List<Episode> episodes) {
        this.shuffled = new ArrayList<>(episodes);
        Collections.shuffle(shuffled, new Random(42)); // Фиксированное зерно
    }

    @Override
    public boolean hasNext() {
        return position < shuffled.size();
    }

    @Override
    public Episode next() {
        return shuffled.get(position++);
    }
}
