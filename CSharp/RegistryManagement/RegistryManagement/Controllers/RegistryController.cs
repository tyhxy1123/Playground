using Microsoft.AspNetCore.Mvc;
using RegistryManagement.Models;

namespace RegistryManagement.Controllers
{
    public class RegistryController : Controller
    {
        private readonly IUserRepository Repository;

        public RegistryController(IUserRepository repository)
        {
            Repository = repository;
        }
        
        [HttpGet]
        public IActionResult Register()
        {
            return View();
        }

        [HttpPost]
        public IActionResult Register(User user)
        {
            if (ModelState.IsValid)
            {
                var rookie = Repository.Add(user);
                return RedirectToAction("Detail", "Registry", new
                {
                    userId = rookie.Id
                });
            }
            
            
            return RedirectToAction("index","home");
        }

        public IActionResult Detail(long userId)
        {
            return View(Repository.GetUserById(userId));
        }
    }
    
    
}