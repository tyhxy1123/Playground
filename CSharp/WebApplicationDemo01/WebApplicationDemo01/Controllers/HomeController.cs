using System;
using System.Collections.Generic;
using System.Text;
using System.Text.Json;
using Microsoft.AspNetCore.Mvc;
using WebApplicationDemo01.Models;
using WebApplicationDemo01.ViewModels;

namespace WebApplicationDemo01.Controllers
{
    
    public class HomeController : Controller
    {
        private readonly IStudentRepository _studentRepository;
        public HomeController(IStudentRepository studentRepository)
        {
            _studentRepository = studentRepository;
        }
        
        [Route("")]
        public IActionResult Index()
        {
            IndexViewModel model = new IndexViewModel()
            {
                AllStudents = _studentRepository.GetAllStudents(),
                PageTitle = "Students Info"
            };
            return View(model);
        }
        
        public ViewResult Detail(int? id)
        {
            // ViewData and ViewBag are all weak type view
            Student model = _studentRepository.GetStudentById(id??1);
//            Response.ContentType = "application/xml";
//            ViewData["PageTitle"] = "Student Details";
//            ViewData["Student"] = model;
            HomeDetailViewModel homeDetailViewModel = new HomeDetailViewModel()
            {
                Student = model,
                PageTitle = "学生详细信息"
            };
            ViewBag.PageTitle = "学生详情";
            ViewBag.Student = model;
//            return $"id={id},姓名:{model.Name},邮箱:{model.Email}";
            return View(model);
        }
        
        [HttpGet]
        public IActionResult Create()
        {
            return View();
        }
        [HttpPost]
        public IActionResult Create(Student student)
        {
            if (ModelState.IsValid)
            {
                Student newStudent = _studentRepository.Add(student);
                return RedirectToAction("Detail", new {id=newStudent.Id});    
            }

            return View();
        }
    }
}