using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Threading;
using System.Threading.Tasks;

namespace App
{
    class Program
    {
        private static long recurCount = 0;
        async static Task<Int64> Fib(Int64 n)
        {
            recurCount++;
            if (n == 0)
            {
                return 0;
            }
            return n == 1 ? n : await Fib(n - 1) + await Fib(n - 2);
        }
        async static Task<long> getStringFromDemo()
        {
            var client = new HttpClient();
            return (await client.GetStringAsync("https://docs.microsoft.com/dotnet")).Length;
        }

        async static void BeginAsyncRun(int n)
        {
            var tasks = new List<Task>(){Fib(n),getStringFromDemo()};
            while (tasks.Any())
            {
                var theTask = await Task.WhenAny(tasks);
                Console.WriteLine(theTask);
                tasks.Remove(theTask);
            }
            Console.WriteLine(recurCount);
        }

        static void Run(int n)
        {
            BeginAsyncRun(n);
            Console.WriteLine("Finished");
        }
        
        public static void Main(String[] args)
        {
            string n = "5";
            Run(int.Parse(n));
            // BeginAsyncRun(int.Parse(n));
        }
    }
}
