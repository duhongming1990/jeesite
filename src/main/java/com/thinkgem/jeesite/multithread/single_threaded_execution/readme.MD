#Single Threaded Execution模式>>>能通过这座桥的只有一个人

## 标准类库中用到的Single Threaded Execution模式
```
import java.util.Collections;
Collections.synchronizedCollection();
Collections.synchronizedList();
Collections.synchronizedMap();
Collections.synchronizedSet();
Collections.synchronizedSortedMap();
Collections.synchronizedSortedSet();
```


## Before/After模式
```
private final Mutex mutex = new Mutex();
mutex.lock();
try{
    unsafeMethod();
}finally {
    mutex.unlock();
}
```