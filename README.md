## Threads and Synchronization

This lab illustrates the problem of synchronization when many threads are operating on a shared object.  The general issue is called "thread safety", and it is a major cause of errors in computer software.

## Assignment

To the problems on the lab sheet and record your answers here.

1. Record average run times.
2. Write your explanation of the results.  Use good English and proper grammar.  Also use good Markdown formatting.

## ThreadCount run times

These are the average runtime using 3 or more runs of the application.
The Counter class is the object being shared by the threads.
The threads use the counter to add and subtract values.

| Counter class           | Limit              | Runtime (sec)   |
|:------------------------|:-------------------|-----------------|
| Unsynchronized counter  |    1,000,000       |     0.015050    |
| Using ReentrantLock     |    1,000,000       |     0.106703    |
| Synchronized method     |    1,000,000       |     0.119601    |
| AtomicLong for total    |    1,000,000       |     0.031853    |

## 1. Using unsynchronized counter object

1.1 Total isn't zero and it's not same result.
1.2 Average is 0.015066.
1.3 The operation of computer call and change value are overlap. if thread1(add) and thread2(subtract) call 5. Maybe when we replace new value to it. it can replace 4 or 6 too because it do in the same time to add and subtract in same value but replace it wrong. thread1 add and replace new value to it(6) but thread2 subtract and replace new value to it(4) so result is 4 if thread1 faster than thread2 but if thread 2 faster than thread1. The result is 6. If you are lucky the both is equal it can show 5(correct).  

## 2. Implications for Multi-threaded Applications

If my mom add money to my account and my dad withdraw my money from my account in the same time. It can overlap in process if I have 100 in my account and my mom and dad are add and withdraw in the same amount(50). my mom add 50. my money(100) should be 150 now but in the same time my dad withdraw it in the same time from my own money(100) too. so maybe my money can be 150 or 50 if my mom or my dad process is faster than other.

## 3. Counter with ReentrantLock

3.1 The results always be zero.
3.2 & 3.3 Because we use ReentrantLock to help in process. It will lock the method when someone call this method and not allow other to call this method until before user is finish with that method then it will unlock it to allow other to use it.
3.4 No matter what happen error or what. It must be unlock after finish the process in this method.

## 4. Counter with synchronized method

4.1 total is always zero. 
4.2 & 4.3 We use synchronized. The synchronized is like as ReentrantLock but synchronized will lock and unlock cover all that method but ReentrantLock can choose where to unlock and unlock in the method. 

## 5. Counter with AtomicLong

5.1 Method in Atomic help in do in 1 process. Different from problem1 that use (total += amount) has 3 process.
5.2 We use Atomic[types] when we use only that type in many threads. 

## 6. Analysis of Results

6.1 AtomicLong is fastest and synchronized is slowest
6.2 ReentrantLock is better than synchronized to deal with many threads. But if we use a little threads. We should use synchronized.

## 7. Using Many Threads (optional)

