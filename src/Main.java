import Part1.*;

public class Main {
    public static void main(String[] args) {

        Season season1 = new Season();
        season1.addEpisode(new Episode("Пилотная серия", 45));
        season1.addEpisode(new Episode("Второй эпизод", 42));

        Season season2 = new Season();
        season2.addEpisode(new Episode("Новое начало", 47));
        season2.addEpisode(new Episode("Неожиданный поворот", 44));

        Series series = new Series();
        series.addSeason(season1);
        series.addSeason(season2);

        System.out.println("Обычный порядок:");
        printEpisodes((EpisodeIterator) season1.iterator());

        System.out.println("\nОбратный порядок:");
        printEpisodes(season1.reverseIterator());

        System.out.println("\nСлучайный порядок:");
        printEpisodes(season1.shuffleIterator());

        System.out.println("\nПоследовательный просмотр всех сезонов:");
        BingeIterator binge = new BingeIterator(series.getSeasons());
        printEpisodes(binge);
    }

    private static void printEpisodes(EpisodeIterator iterator) {
        while (iterator.hasNext()) {
            Episode episode = iterator.next();
            System.out.println(episode.getTitle());
        }
    }
}