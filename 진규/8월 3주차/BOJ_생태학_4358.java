import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Map<String, Integer> hashMap = new HashMap<>();
    static int treeCnt = 0;

    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            String treeName = br.readLine();
            if (treeName == null) break;

            hashMap.put(treeName, hashMap.getOrDefault(treeName, 0)+1);
            treeCnt += 1;
        }

        List<String> treeNameList = new ArrayList<>();
        for(Map.Entry<String, Integer> hM : hashMap.entrySet()) {
            treeNameList.add(hM.getKey());
        }

        Collections.sort(treeNameList, (a, b) -> a.compareTo(b));

        for(String tN : treeNameList) {

            String ratio = String.format("%.4f", (double)hashMap.get(tN) / treeCnt * 100);
            System.out.println(tN + " " + ratio);
        }
    }
}