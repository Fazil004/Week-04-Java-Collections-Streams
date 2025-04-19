import java.util.ArrayList;
import java.util.List;

class Rotate {
    public List<Integer> rotateList(List<Integer> list, int rotateBy) {
        if (list == null || list.isEmpty()) {
            return new ArrayList<>();
        }

        int n = list.size();
        rotateBy = rotateBy % n;
        if (rotateBy < 0) {
            rotateBy += n;
        }

        List<Integer> rotatedList = new ArrayList<>(n);
        for (int i = rotateBy; i < n; i++) {
            rotatedList.add(list.get(i));
        }

        for (int i = 0; i < rotateBy; i++) {
            rotatedList.add(list.get(i));
        }

        return rotatedList;
    }

    public static void main(String[] args) {
        List<Integer> inputList = List.of(10, 20, 30, 40, 50);
        int rotateBy = 2;
        Rotate solution = new Rotate();
        List<Integer> rotatedList = solution.rotateList(inputList, rotateBy);
        System.out.println("Input: " + inputList + ", rotate by " + rotateBy + " --> Output: " + rotatedList);

    }
}