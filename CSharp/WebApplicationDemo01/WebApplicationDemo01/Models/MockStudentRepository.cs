using System.Collections.Generic;
using System.Linq;

namespace WebApplicationDemo01.Models
{
    public class MockStudentRepository : IStudentRepository
    {
        private readonly List<Student> _students;
        public IEnumerable<Student> GetAllStudents()
        {
            return _students;
        }

        public MockStudentRepository()
        {
            _students = new List<Student>()
            {
                new Student() {Id = 1, Name = "张三", ClassName = ClassNameEnum.FirstGrade, Email = "zhangsan@123.com"},
                new Student() {Id = 2, Name = "李四", ClassName = ClassNameEnum.SecondGrade, Email = "lisi@123.com"},
                new Student() {Id = 3, Name = "王五", ClassName = ClassNameEnum.ThirdGrade, Email = "wangwu@123.com"}
            };
        }

        public Student GetStudentById(int id)
        {
            return _students.FirstOrDefault(student => student.Id == id);
        }

        public Student Add(Student student)
        {
            student.Id = _students.Max(s => s.Id) + 1;
            _students.Add(student);
            return student;
        }
    }
}