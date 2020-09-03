package org.creditMutuel.utils;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CacheEventLogger implements CacheEventListener<Object, Object>{
	
	 /** Logback logger reference. */
    private static final Logger logger = LoggerFactory.getLogger(CacheEventLogger.class);
    /**
     * Log the cache event key, old value and new value.
     */
    @Override
    public void onEvent(CacheEvent<? extends Object, ? extends Object> cacheEvent) {
        logger.debug("Cache key: {}, Cache old value {}, Cache new value {}", cacheEvent.getKey(), cacheEvent.getOldValue(), cacheEvent.getNewValue());
    }

}
