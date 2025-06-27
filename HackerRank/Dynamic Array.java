import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
    List<List<Integer>> seqList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        seqList.add(new ArrayList<>());
    }

    List<Integer> result = new ArrayList<>();
    int lastAnswer = 0;

    for (List<Integer> query : queries) {
        int type = query.get(0);
        int x = query.get(1);
        int y = query.get(2);

        int index = (x ^ lastAnswer) % n;
        List<Integer> seq = seqList.get(index);

        if (type == 1) {
            seq.add(y);
        } else if (type == 2) {
            lastAnswer = seq.get(y % seq.size());
            result.add(lastAnswer);
        }
    }
    return result;
}

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.dynamicArray(n, queries);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
