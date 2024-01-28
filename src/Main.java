import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
public class Main
{
    public static void main(String[] args)
    {
        ToyStore store = new ToyStore();
        store.put("1 2 конструктор");
        store.put("2 2 робот");
        store.put("3 6 кукла");
        List<String> results = new ArrayList<>();
        for (int i = 0; i < 10; i++)
        {
            results.add(store.get());
        }
        try
        {
            Files.write(Paths.get("results.txt"), results, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}