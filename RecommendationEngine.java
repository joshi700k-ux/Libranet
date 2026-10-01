import java.util.*;

public class RecommendationEngine {

    private Map<String, List<String>> graph;

    private LCSRecommendation lcsEngine;

    public RecommendationEngine() {

        graph = new HashMap<>();

        lcsEngine =
                new LCSRecommendation();
    }

    public void connectBooks(
            String book1,
            String book2) {

        graph.putIfAbsent(
                book1,
                new ArrayList<>()
        );

        graph.putIfAbsent(
                book2,
                new ArrayList<>()
        );

        graph.get(book1).add(book2);
        graph.get(book2).add(book1);
    }

    public void displayGraph() {

        System.out.println(
                "\n===== BOOK GRAPH ====="
        );

        for (String book :
                graph.keySet()) {

            System.out.print(
                    book + " -> "
            );

            System.out.println(
                    graph.get(book)
            );
        }
    }

    public List<String> bfsRecommendations(
            String startBook) {

        List<String> result =
                new ArrayList<>();

        Queue<String> queue =
                new LinkedList<>();

        Set<String> visited =
                new HashSet<>();

        queue.offer(startBook);

        visited.add(startBook);

        while (!queue.isEmpty()) {

            String current =
                    queue.poll();

            for (String neighbor :
                    graph.getOrDefault(
                            current,
                            new ArrayList<>())) {

                if (!visited.contains(neighbor)) {

                    visited.add(neighbor);

                    queue.offer(neighbor);

                    result.add(neighbor);
                }
            }
        }

        return result;
    }

    public List<Book> recommendByGenre(
            String userInterest,
            Collection<Book> books) {

        List<Book> recommendations =
                new ArrayList<>();

        int bestScore = -1;

        for (Book book : books) {

            int score =
                    lcsEngine.lcs(
                            userInterest.toLowerCase(),
                            book.getGenre()
                                    .toLowerCase()
                    );

            if (score > bestScore) {

                bestScore = score;

                recommendations.clear();

                recommendations.add(book);
            }

            else if (score == bestScore) {

                recommendations.add(book);
            }
        }

        return recommendations;
    }
}