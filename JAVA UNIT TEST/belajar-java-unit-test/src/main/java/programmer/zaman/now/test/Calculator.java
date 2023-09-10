package programmer.zaman.now.test;

public class Calculator {

    public Integer devide(Integer first, Integer second){
        if (second == 0){
            throw new IllegalArgumentException("Cank not devide by zero");
        }else {
            return first / second;
        }
    }

    public Integer add(Integer first, Integer second){
        return first + second;
    }

}
