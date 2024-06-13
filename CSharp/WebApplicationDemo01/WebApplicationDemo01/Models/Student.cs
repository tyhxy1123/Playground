using System.ComponentModel.DataAnnotations;

namespace WebApplicationDemo01.Models
{
    public class Student
    {
        public int Id { get; set; }
        [Required(ErrorMessage = "姓名为必填"),MaxLength(50,ErrorMessage = "名字不能过长")]
        [Display(Name = "姓名")]
        public string Name { get; set; }
        [Display(Name = "年级")]
        public ClassNameEnum? ClassName { get; set; }
        [Display(Name = "邮箱")]
        public string Email { get; set; }
    }
}