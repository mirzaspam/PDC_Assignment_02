public class AsyncWebEngineApp {
    public static void main(String[] args) {
        System.out.println("Default thread name: " + Thread.currentThread().getName());

        TelemetryThread telemetry = new TelemetryThread();
        telemetry.setName("Telemetry-Worker");

        Thread logThread = new Thread(new LogProcessorTask());
        logThread.setName("Log-Worker");

        telemetry.start();
        logThread.start();

        System.out.println(telemetry.getName() + " state: " + telemetry.getState());
        System.out.println(logThread.getName() + " state: " + logThread.getState());

        try {
            telemetry.join();   // main waits for both
            logThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main interrupted");
        }

        System.out.println("Both threads finished. main() ending.");
    }
}