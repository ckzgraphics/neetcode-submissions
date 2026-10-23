class DynamicArray {

    int[] dynamoArr;
    boolean isArrFull = false;
    int elementCount = 0;

    public DynamicArray(int capacity) {
        dynamoArr = new int[capacity];
    }

    public int get(int i) {
        return dynamoArr[i];
    }

    public void set(int i, int n) {
        dynamoArr[i] = n;
    }

    public void pushback(int n) {
        if(!isArrFull){
            dynamoArr[elementCount] = n;
        } else {
            resize();
            dynamoArr[elementCount] = n;
        }
        elementCount++;
        if(elementCount == dynamoArr.length){
            isArrFull = true;
        }
    }

    public int popback() {
        int infoPop = dynamoArr[elementCount-1];
        elementCount--;
        return infoPop;
    }

    private void resize() {
        int[] tempArray = new int[dynamoArr.length * 2];
        for (int i=0; i<dynamoArr.length; i++){
            tempArray[i] = dynamoArr[i];
        }
        // for (int idx : dynamoArr) {
        //     tempArray[idx] = dynamoArr[idx];
        // }
        dynamoArr = tempArray;
        isArrFull = false;
    }

    public int getSize() {
        return elementCount;
    }

    public int getCapacity() {
        return dynamoArr.length;
    }
}