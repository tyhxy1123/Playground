using System.Threading.Tasks;
using System;
using System.Net.Http;

namespace Fib
{
    class App
    {
        async static Task<Int64> Fib(Int64 n){
            if (n == 0)
            {
                return 0;
            }
            else if (n == 1)
            {
                return 1;
            }
            return await Fib(n-1) + await Fib(n-2);
        }
        async static Task<string> getStringFromDemo()
        {
            var client = new HttpClient();
            var getStringTask = client.GetStringAsync("https://docs.microsoft.com/dotnet");
            var urlContent = await getStringTask;
            return urlContent;
        }
        public static void Main(String[] args){
            System.Console.WriteLine(Fib(Int64.Parse(args[0])));
            System.Console.WriteLine(getStringFromDemo());
        }
    }
}