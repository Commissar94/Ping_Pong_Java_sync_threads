import java.util.concurrent.SynchronousQueue;

class PingPong {

    private SynchronousQueue<Integer> syncQueue = new SynchronousQueue<Integer>();

    private Thread ping = new Thread() {

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("Ping");
                    syncQueue.put(1);
                } catch (Exception e) { }
            }
        }
    };

    private Thread pong = new Thread() {

        @Override
        public void run() {

            while (true) {
                try {
                    syncQueue.take();
                    System.out.println("Pong");
                } catch (Exception e) { }
            }
        }
    };

    public static void main(String[] args) {
        PingPong p = new PingPong();
        p.ping.start();
        p.pong.start();
    }

}