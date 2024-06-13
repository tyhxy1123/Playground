public class IDownloader implements Runnable{
    private String url;
    private String fileName;

    public IDownloader(String url, String fileName) {
        this.url = url;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        WebDownloader wd = new WebDownloader();
        wd.download(this.url,this.fileName);
    }

    public static void main(String[] args) {
        String url = "http://www.163.com";
        String fileName = "163.html";
        IDownloader iDownloader1 = new IDownloader(url, fileName);
        Thread t1 = new Thread(iDownloader1);
        Thread t2 = new Thread(iDownloader1);
        Thread t3 = new Thread(iDownloader1);
        t1.start();
        t2.start();
        t3.start();
    }



}
