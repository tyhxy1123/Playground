using Microsoft.AspNetCore.Mvc;

namespace WebApplicationDemo01.Controllers
{
    public class DepartmentController : Controller
    {
        public string List()
        {
            return "DepartmentController's list()";
        }

        public string Detail()
        {
            return "Detail() in DepatmentController";
        }
    }
}