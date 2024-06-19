package com.fernandosalas.sec01;

/*
   1. publisher does not produce data unless subscriber requests for it.
   2. publisher will produce only <= subscriber requested items. publisher can also produce 0 items!
   3. subscriber can cancel the subscription. producer should stop at that moment as subscriber is no longer interested in consuming the data
   4. producer can send the error signal
 */

import com.fernandosalas.sec01.publisher.PublisherImpl;
import com.fernandosalas.sec01.subscriber.SubscriberImpl;

import java.time.Duration;

public class Demo {
    private static void demo1() {
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
    }

    private static void demo2() throws InterruptedException {
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2).toMillis());

        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2).toMillis());

        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2).toMillis());

        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2).toMillis());
    }

    private static void demo3() throws InterruptedException {
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2).toMillis());

        subscriber.getSubscription().cancel();

        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2).toMillis());
    }

    private static void demo4() throws InterruptedException {
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2).toMillis());

        subscriber.getSubscription().request(11);
        Thread.sleep(Duration.ofSeconds(2).toMillis());

        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2).toMillis());
    }


    public static void main(String[] args) throws InterruptedException {
        demo4();
    }
}
