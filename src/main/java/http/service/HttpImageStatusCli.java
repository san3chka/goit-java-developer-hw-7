package http.service;

import java.util.Scanner;

public class HttpImageStatusCli {

   public void askStatus() {
       Scanner scanner = new Scanner(System.in);
       HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();
       System.out.println("enter HTTP status code: ");
       while (!scanner.hasNextInt()) {
           System.out.println("please enter valid number");
           scanner.next();
       }

       int code = scanner.nextInt();
       try {
           httpStatusImageDownloader.downloadStatusImage(code);
       } catch (Exception e) {
           System.out.printf("There is not image for HTTP status <%d>", code);
       }
   }
}
