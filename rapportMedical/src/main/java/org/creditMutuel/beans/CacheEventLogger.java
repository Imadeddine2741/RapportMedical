package org.creditMutuel.beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

public class CacheEventLogger  implements CacheEventListener<Object, Object> {

  // Cache event listener which logs both CREATED and EXPIRED cache events

  // Logger
  private static final Logger LOGGER = LogManager.getLogger(CacheEventLogger.class);
 
  @Override
  public void onEvent(
    CacheEvent<? extends Object, ? extends Object> cacheEvent) {
	  LOGGER.info("Cache event " + cacheEvent.getType() + "for item " + cacheEvent.getKey() + ". Old value = " + cacheEvent.getOldValue() + ", new value = " + cacheEvent.getNewValue());
  }
}
