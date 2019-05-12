# Guarded Suspension模式>>>等我准备好哦

## 阻塞队列
```
//非线程安全的队列
private final Queue<Request> queue = new LinkedList<>();
//线程安全的队列
private final BlockingDeque<Request> queue = new LinkedBlockingDeque<>();
```