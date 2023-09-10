package programmerzamannow.mengulang.others;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.ArrayList;
import java.util.List;

public class ThreetonScope implements Scope {

    private List<Object> list = new ArrayList<>();

    private Integer counter = 0;

    @Override
    public Object get(String s, ObjectFactory<?> objectFactory) {
        if (list.size() == 3){
            int index = counter % 3;
            counter++;
            return list.get(index);
        } else {
            Object object = objectFactory.getObject();
            list.add(object);
            counter++;
            return object;
        }
    }

    @Override
    public Object remove(String s) {
        if (!list.isEmpty()){
            return list.remove(0);
        }
        return null;
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
