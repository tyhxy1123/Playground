﻿using System;
using System.Linq;
using System.Threading.Tasks;

namespace ConsoleApp2
{
    public class AsyncReturnTypes
    {
        public static void Main()
        {
            Console.WriteLine(ShowTodaysInfo().Result);
        }

        private static async Task<string> ShowTodaysInfo()
        {
            string ret = $"Today is {DateTime.Today:D}\n" +
                         "Today's hours of leisure: " +
                         $"{await GetLeisureHours()}";
            return ret;
        }

        static async Task<int> GetLeisureHours()  
        {  
            // Task.FromResult is a placeholder for actual work that returns a string.  
            var today = await Task.FromResult<string>(DateTime.Now.DayOfWeek.ToString());  
     
            // The method then can process the result in some way.  
            int leisureHours;  
            if (today.First() == 'S')  
                leisureHours = 16;  
            else  
                leisureHours = 5;  
     
            return leisureHours;  
        }  
    }
}