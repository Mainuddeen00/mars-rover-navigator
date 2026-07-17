import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;

public class FrontendLauncher {
    public static void main(String[] args) throws IOException {
        int port = 3000;
        String host = "localhost";

        HttpServer server = HttpServer.create(new InetSocketAddress(host, port), 0);
        System.out.println("Frontend Server running at http://" + host + ":" + port + "/");
        System.out.println("Working directory: " + new File(".").getAbsolutePath());

        server.createContext("/", new HttpHandler() {
            @Override
            public void handle(HttpExchange t) throws IOException {
                String uri = t.getRequestURI().getPath();

                // Handle root path
                if (uri.equals("/")) {
                    uri = "/index.html";
                }

                // Look for the file in the current directory
                File file = new File("." + uri);

                System.out.println("Requested: " + uri + " -> Looking at: " + file.getAbsolutePath());

                if (file.exists() && !file.isDirectory()) {
                    String contentType = "text/plain";
                    if (uri.endsWith(".html")) contentType = "text/html";
                    else if (uri.endsWith(".css")) contentType = "text/css";
                    else if (uri.endsWith(".js")) contentType = "application/javascript";
                    else if (uri.endsWith(".json")) contentType = "application/json";
                    else if (uri.endsWith(".png")) contentType = "image/png";
                    else if (uri.endsWith(".jpg") || uri.endsWith(".jpeg")) contentType = "image/jpeg";

                    t.getResponseHeaders().set("Content-Type", contentType);
                    t.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
                    t.sendResponseHeaders(200, file.length());

                    try (OutputStream os = t.getResponseBody()) {
                        Files.copy(file.toPath(), os);
                    }
                } else {
                    String response = "404: File Not Found\nRequested: " + uri +
                            "\nLooking at: " + file.getAbsolutePath() +
                            "\nFile exists: " + file.exists();
                    t.getResponseHeaders().set("Content-Type", "text/plain");
                    t.sendResponseHeaders(404, response.length());
                    try (OutputStream os = t.getResponseBody()) {
                        os.write(response.getBytes());
                    }
                }
            }
        });

        server.setExecutor(null);
        server.start();

        System.out.println("\nFrontend server ready!");
        System.out.println("Open browser at: http://localhost:3000");
    }
}