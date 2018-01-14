public interface Map <K,V>
{
	boolean containsKey(Object key);

	boolean containsValue(Object value);

	V get(Object key);

	boolean isEmpty();

	Set<K> keySet();

	V put(K key, V value);

	void putAll(Map<? extends K, ? extends V> m);

	V remove(Object key);

	int size();
	
	Vector<V> values();

}