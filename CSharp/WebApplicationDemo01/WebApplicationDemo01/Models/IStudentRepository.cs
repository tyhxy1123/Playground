using System.Collections.Generic;

namespace WebApplicationDemo01.Models
{
    public interface IStudentRepository
    {
        Student GetStudentById(int id);
        Student Add(Student student);
        IEnumerable<Student> GetAllStudents();
    }
}