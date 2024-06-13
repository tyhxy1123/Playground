using System.Collections.Generic;
using WebApplicationDemo01.Models;

namespace WebApplicationDemo01.ViewModels
{
    public class IndexViewModel
    {
        public IEnumerable<Student> AllStudents { get; set; }
        public string PageTitle { get; set; }
    }
}