package containers;

import java.util.*;
import net.mindview.util.*;

public class SlowMap<K, V> extends AbstractMap<K, V> {
	private List<K> keys = new ArrayList<>();
	private List<V> values = new ArrayList<>();

	public V put(K key, V value) {
		V oldValue = get(key);
		if (!keys.contains(key)) {
			values.add(value);
		} else {
			values.set(keys.indexOf(key), value);
		}
		return oldValue;
	}

	public V get(Object key) {
		if (!keys.contains(key)) {
			return null;
		}
		return values.get(keys.indexOf(key));
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Set<Map.Entry<K, V>> entrySet() {
//		Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K, V>>();
//		Iterator<K> ki = keys.iterator();
//		Iterator<V> vi = values.iterator();
//		while (ki.hasNext())
////			set.add(new MapEntry<K, V>(ki.next(), vi.next()));
//		return set;
//	}

}
