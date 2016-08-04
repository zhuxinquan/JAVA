package map;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhuxinquan on 16-8-1.
 * 通讯录
 */
public class Contacts {
    private Map<Integer, Contact> conactMap = new HashMap<>();
    int id = 1;
    public void add(Contact c){
        conactMap.put(id++, c);
    }
    public void update(int id, Contact c){
        Contact contact = find(id);
        contact.setName(c.getPhone());
    }
    public Contact find(int id){
        return conactMap.get(id);
    }
    public Map<Integer, Contact> getConacts(){
        return conactMap;
    }
}
