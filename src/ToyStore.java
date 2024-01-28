import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;
public class ToyStore
{
    private List<String> idList = new ArrayList<>();
    private List<String> nameList = new ArrayList<>();
    private List<Integer> frequencyList = new ArrayList<>();
    private PriorityQueue<String> toyQueue = new PriorityQueue<>(Comparator.comparingInt(id ->
            frequencyList.get(idList.indexOf(id))));

    public void put(String input) {
        String[] parts = input.split(" ");
        Toy toy = new Toy(parts[0], parts[2], parts[1]);
        idList.add(toy.getId());
        nameList.add(toy.getName());
        frequencyList.add(toy.getFrequency());
        for (int i = 0; i < toy.getFrequency(); i++) {
            toyQueue.offer(toy.getId());
        }
    }

    public String get() {
        String randomToyId = toyQueue.poll();
        refillQueueIfEmpty();
        return randomToyId;
    }

    private void refillQueueIfEmpty() {
        if (toyQueue.isEmpty()) {
            for (int i = 0; i < idList.size(); i++) {
                String id = idList.get(i);
                for (int j = 0; j < frequencyList.get(i); j++) {
                    toyQueue.offer(id);
                }
            }
        }
    }

}
