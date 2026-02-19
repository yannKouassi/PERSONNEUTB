import java.util.HashMap;
import java.util.Iterator;

public class Table<K,V> extends HashMap<K,V>{

    public Table(){
        super();
    }

    public int size(){
        return super.size ();
    }

    public boolean isEmpty(){
        return super.isEmpty ();

    }

    public V getValue(K key){
        return super.get (key);
    }

    public void clear(){
        super.clear ();
    }


    public V removeValue(K key){
        return super.remove (key);
    }

    public void addValue(K key ,V value){
        V valeur =this.getValue(key);
        if(valeur==null){
            super.put ( key,value );
        }
    }

    public void modifyValue(K key , V value){
        V valeur =this.getValue(key);
        if(valeur!=null){
            super.put ( key,value );
        }
    }

    public Iterator <K> iterator (){
        return super.keySet().iterator();
    }


}
