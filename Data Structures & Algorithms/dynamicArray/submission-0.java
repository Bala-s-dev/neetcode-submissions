class DynamicArray {
    int[] arr;
    int capacity;
    int size;
    public DynamicArray(int capacity) {
        this.arr = new int[capacity];
        this.capacity = capacity;
        this.size = size;
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
    }

    public void pushback(int n) {
        if(size == capacity){
            resize();
        }
        arr[size] = n;
        size++; 
    }

    public int popback() {
        if(size == 0){
            throw new RuntimeException("Array is empty");
        }
        int last = arr[size-1];
        size--;
        return last;
    }

    private void resize() {
        capacity = capacity*2;
        int[] newarr = new int[capacity];
        for(int i=0; i<size; i++){
            newarr[i] = arr[i];
        }
        arr = newarr;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
