package Hashing;

class HashTable {

    int[] arr;
    int cap, size;

    HashTable(int c) {
        cap = c;
        size = 0;
        arr = new int[cap];
        for (int i = 0; i < cap; i++)
            arr[i] = -1;
    }

    int hash(int key) {
        return key % cap;
    }

    boolean insert(int key) {
        if (size == cap)
            return false;
        int i = hash(key);
        while (arr[i] != -1 && arr[i] != -2 && arr[i] != key)
            i = (i + 1) % cap;
        if (arr[i] == key)
            return false;
        else {
            arr[i] = key;
            size++;
            return true;
        }
    }

    boolean search(int key) {
        int h = hash(key);
        int i = h;
        while (arr[i] != -1) {
            if (arr[i] == key)
                return true;
            i = (i + 1) % cap;
            if (i == h)
                return false;
        }
        return false;
    }

    boolean erase(int key) {
        int h = hash(key);
        int i = h;
        while (arr[i] != -1) {
            if (arr[i] == key) {
                arr[i] = -2;
                return true;
            }
            i = (i + 1) % cap;
            if (i == h)
                return false;
        }
        return false;
    }

}

public class MyHash {

    public static void main(String[] args) {

        HashTable myhash = new HashTable(7);

        myhash.insert(49);
        myhash.insert(56);
        myhash.insert(72);
        // myhash.insert(14);
        // myhash.insert(21);
        // myhash.insert(28);
        // myhash.insert(35);

        // System.out.print(myhash.hash.size());
        // myhash.print();
        myhash.search(56);
    }
}
