public class ThreadTest {
  private Queue<Integer> queue;
  private boolean running;

  private class Reader implements Runnable {
    public void run() {
      int dataCount = 0;
      int yieldCount = 0;
      while (running) {
        while (!queue.isEmpty()) {
          System.out.println("-->" + queue.remove());
          dataCount += 1;
        }
        if (running){
          Thread.yield();
          yieldCount += 1;
        }
      }
      System.out.format("Reader: dataCount=%d yieldCount=%d%n", dataCount, yieldCount);
    }
  }

  private class Writer implements Runnable {
    public void run() {
      for (Integer index = 0; index < 100000; index += 1) {
        queue.add(index);
        Thread.yield();
      }
    }
  }

  private void run() throws InterruptedException {
    queue = new Queue<>();

    running = true;

    Thread rt = new Thread(new Reader());
    rt.start();

    Thread wt = new Thread(new Writer());
    wt.start();

    wt.join();
    running = false;
    rt.join();

    System.out.format("queue.size=%d%n", queue.size());
    while (!queue.isEmpty()) {
      System.out.println("==>" + queue.remove());
    }

  }

  public static void main(String[] args) throws InterruptedException {
    ThreadTest application = new ThreadTest();
    application.run();
  }
}
