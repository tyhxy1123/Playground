using System;
using System.Collections;
using System.Collections.Generic;
using System.Net.Http;
using System.Net;
using System.IO;
using System.Linq;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    class Program
    {
        private readonly HttpClient client = new HttpClient(){MaxResponseContentBufferSize = 100000000};
        private async Task<int> ProcessURLAsync(string url)
        {
            var byteArray = await client.GetByteArrayAsync(url);
            DisplayResults(url, byteArray);
            return byteArray.Length;
        }
        
        private async Task SumPageSizesAsync()
        {
            // Make a list of web addresses.
            List<string> urlList = SetUpURLList();
            IEnumerable<Task<int>> downloadTasksQuery = 
                from url in urlList select ProcessURLAsync(url);
            Task<int>[] downloadTasks = downloadTasksQuery.ToArray();
            int[] lengths = await Task.WhenAll(downloadTasks);
            int total = lengths.Sum();
            Console.WriteLine(total);
            // var total = 0;
            // foreach (var url in urlList)
            // {
            //     // GetURLContents returns the contents of url as a byte array.
            //     // byte[] urlContents = await GetURLContentsAsync(url);
            //     byte[] urlContents = await client.GetByteArrayAsync(url);
            //     
            //     DisplayResults(url, urlContents);
            //
            //     // Update the total.
            //     total += urlContents.Length;
            // }

            // Display the total count for all of the web addresses.
            // Console.WriteLine("Total byte returned: " + total);
        }

        private List<string> SetUpURLList()
        {
            var urls = new List<string>
            {
                "https://msdn.microsoft.com/library/windows/apps/br211380.aspx",
                "https://msdn.microsoft.com",
                "https://msdn.microsoft.com/library/hh290136.aspx",
                "https://msdn.microsoft.com/library/ee256749.aspx",
                "https://msdn.microsoft.com/library/hh290138.aspx",
                "https://msdn.microsoft.com/library/hh290140.aspx",
                "https://msdn.microsoft.com/library/dd470362.aspx",
                "https://msdn.microsoft.com/library/aa578028.aspx",
                "https://msdn.microsoft.com/library/ms404677.aspx",
                "https://msdn.microsoft.com/library/ff730837.aspx"
            };
            return urls;
        }

        // private async Task<byte[]> GetURLContentsAsync(string url)
        // {
        //     // The downloaded resource ends up in the variable named content.
        //     var content = new MemoryStream();
        //
        //     // Initialize an HttpWebRequest for the current URL.
        //     var webReq = (HttpWebRequest) WebRequest.Create(url);
        //
        //     // Send the request to the Internet resource and wait for
        //     // the response.
        //     // Note: you can't use HttpWebRequest.GetResponse in a Windows Store app.
        //     using (WebResponse response = await webReq.GetResponseAsync())
        //     {
        //         // Get the data stream that is associated with the specified URL.
        //         using (Stream responseStream = response.GetResponseStream())
        //         {
        //             // Read the bytes in responseStream and copy them to content.
        //             await responseStream.CopyToAsync(content);
        //         }
        //     }
        //
        //     // Return the result as a byte array.
        //     return content.ToArray();
        // }

        private void DisplayResults(string url, byte[] content)
        {
            // Display the length of each website. The string format
            // is designed to be used with a monospaced font, such as
            // Lucida Console or Global Monospace.
            var bytes = content.Length;
            // Strip off the "https://".
            var displayURL = url.Replace("https://", "");
            Console.WriteLine(displayURL + " Content length: " + bytes);
        }
        
        
        private async void eventHandler()
        {
            await SumPageSizesAsync();
        } 
        
        static void Main(string[] args)
        {
            new Program().eventHandler();
            while (true);
        }
    }
}