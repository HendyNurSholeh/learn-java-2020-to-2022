package programmer.zaman.now.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CounterReadWriteLock {
        private ReadWriteLock lock = new ReentrantReadWriteLock();
        private Long value = 0L;

        public void increment(){
            try {
                lock.writeLock().lock();
                value++;
            }finally {
                lock.writeLock().unlock();
            }
        }

        public Long getValue(){
            try {
                lock.readLock().lock();
                return value;
            }finally {
                lock.readLock().lock();
            }
        }
}
