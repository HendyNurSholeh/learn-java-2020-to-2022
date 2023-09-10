package programmer.zaman.now.generic.application;

import programmer.zaman.now.generic.Util.ArrayHelper;

public class ArrayHelperApp {
    public static void main(String[] args) {
        String names[] = {"Hendy", "Usoppp", "Sanji"};
        Integer numbers[] = {2,3,4,6,7,7,5};

        ArrayHelper arrayHelper = new ArrayHelper();
        arrayHelper.count(names);
        arrayHelper.count(numbers);

    }
}
