package http.service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class HttpStatusImageDownloader {

    public void downloadStatusImage(int code) throws Exception {
        OkHttpClient client = new OkHttpClient
                .Builder()
                .callTimeout(15, TimeUnit.SECONDS)
                .build();

        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
        String url = httpStatusChecker.getStatusImage(code);

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                ResponseBody responseBody = response.body();

                saveImage(responseBody.byteStream(), "cat.jpg");
                System.out.println("image downloaded successfully");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void saveImage(InputStream inputStream, String fileName) throws IOException {
        try (OutputStream outputStream = new FileOutputStream(fileName)) {
            byte[] buffer = new byte[8 * 1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
    }
}
