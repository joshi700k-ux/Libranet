import java.util.*;

public class BranchNetwork {

    static class Edge {

        String destination;

        int distance;

        Edge(
                String destination,
                int distance) {

            this.destination =
                    destination;

            this.distance =
                    distance;
        }
    }

    private Map<
            String,
            List<Edge>
            > graph;

    public BranchNetwork() {

        graph =
                new HashMap<>();
    }

    public void addBranchRoute(
            String from,
            String to,
            int distance) {

        graph.putIfAbsent(
                from,
                new ArrayList<>()
        );

        graph.putIfAbsent(
                to,
                new ArrayList<>()
        );

        graph.get(from)
                .add(
                        new Edge(
                                to,
                                distance
                        )
                );

        graph.get(to)
                .add(
                        new Edge(
                                from,
                                distance
                        )
                );
    }

    public void displayNetwork() {

        System.out.println(
                "\n===== BRANCH NETWORK ====="
        );

        for (String branch :
                graph.keySet()) {

            System.out.print(
                    branch + " -> "
            );

            for (Edge edge :
                    graph.get(branch)) {

                System.out.print(
                        "("
                                + edge.destination
                                + ", "
                                + edge.distance
                                + "km) "
                );
            }

            System.out.println();
        }
    }

    public void shortestPath(
            String source) {

        PriorityQueue<Edge> pq =
                new PriorityQueue<>(
                        Comparator.comparingInt(
                                e -> e.distance
                        )
                );

        Map<String, Integer> dist =
                new HashMap<>();

        for (String node :
                graph.keySet()) {

            dist.put(
                    node,
                    Integer.MAX_VALUE
            );
        }

        dist.put(source, 0);

        pq.offer(
                new Edge(
                        source,
                        0
                )
        );

        while (!pq.isEmpty()) {

            Edge current =
                    pq.poll();

            for (Edge neighbor :
                    graph.get(
                            current.destination
                    )) {

                int newDist =
                        dist.get(
                                current.destination
                        )
                                +
                                neighbor.distance;

                if (newDist
                        <
                        dist.get(
                                neighbor.destination
                        )) {

                    dist.put(
                            neighbor.destination,
                            newDist
                    );

                    pq.offer(
                            new Edge(
                                    neighbor.destination,
                                    newDist
                            )
                    );
                }
            }
        }

        System.out.println(
                "\n===== SHORTEST PATHS ====="
        );

        for (String branch :
                dist.keySet()) {

            System.out.println(
                    source
                            + " -> "
                            + branch
                            + " = "
                            + dist.get(branch)
                            + " km"
            );
        }
    }
}