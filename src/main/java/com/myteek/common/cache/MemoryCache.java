package com.myteek.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.myteek.common.constant.MemoryConstant;
import lombok.Getter;

import java.io.Closeable;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Getter
public class MemoryCache<K, V> implements Closeable {

    private final int capacity;

    private final int maxAge;

    private final Cache<K, V> cache;

    public MemoryCache() {
        this(MemoryConstant.DEFAULT_CAPACITY);
    }

    public MemoryCache(int capacity) {
        this(capacity, MemoryConstant.DEFAULT_MAX_AGE);
    }

    /**
     * constructor
     * @param capacity memory size
     * @param maxAge max age
     */
    public MemoryCache(int capacity, int maxAge) {
        this.capacity = capacity;
        this.maxAge = maxAge;
        this.cache = CacheBuilder.newBuilder()
                .expireAfterWrite(maxAge, TimeUnit.MILLISECONDS)
                .initialCapacity(capacity)
                .build();
    }

    public V get(K key) {
        Preconditions.checkNotNull(key);
        return cache.getIfPresent(key);
    }

    /**
     * get or return default
     * @param key key
     * @param defaultValue default
     * @return
     */
    public V getOrElse(K key, V defaultValue) {
        V v = get(key);
        if (Objects.isNull(v)) {
            v = defaultValue;
        }
        return v;
    }

    public void del(K key) {
        Preconditions.checkNotNull(key);
        cache.invalidate(key);
    }

    public void set(K key, V value) {
        cache.put(key, value);
    }

    public void close() {
        cache.cleanUp();
    }

}
